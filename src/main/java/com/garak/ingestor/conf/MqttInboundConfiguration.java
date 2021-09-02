package com.garak.ingestor.conf;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.garak.ingestor.nosql.entity.Mobility;
import com.garak.ingestor.nosql.entity.MobilityRDB;
import com.garak.ingestor.nosql.repository.MobilityRDBRepository;
import com.garak.ingestor.nosql.repository.MobilityRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class MqttInboundConfiguration {

	@Autowired
	private MyGateway myPublish;
	@Autowired
	private MobilityRDBRepository mobiRdbRepo;
	@Autowired
	private MobilityRepository mobiRepo;
	@Autowired
	private MqttProperties mqttProp;
	@Autowired
	private MobilityStateBroker mobiBroker;
	SimpleDateFormat sDate2 = new SimpleDateFormat("yyyyMMddhhmmssSSS");
	@Bean
	public MessageChannel mqttInputChannel() {
		return new DirectChannel();
	}
	
    @Bean("objectReader")
    public ObjectReader objectReader() {
    	ObjectReader reader = new ObjectMapper().readerFor(Mobility.class);
		return reader;
    }
    
	@Bean
	public MqttPahoMessageDrivenChannelAdapter inbound() {
		List<MobilityRDB> mobis = mobiRdbRepo.findAll();
		String[] topics = mobis.stream().map( mobi -> mobi.getMobiTopic()).toArray(String[]::new);
		
		MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter(
				mqttProp.getUrl(), mqttProp.getClientid(), topics);
		adapter.setCompletionTimeout(5000);
		adapter.setConverter(new DefaultPahoMessageConverter());
		adapter.setQos(1);
		adapter.setOutputChannel(mqttInputChannel());
		return adapter;
	}
	
	@Bean
	@ServiceActivator(inputChannel = "mqttInputChannel")
	public MessageHandler handler() {
		
		return new MessageHandler() {
			@Override
			public void handleMessage(Message<?> message) throws MessagingException {
				// TODO Auto-generated method stub
				Mobility m;
				try {
					// 데이터 수신
					m = objectReader().readValue(message.getPayload().toString());
					//id 설정 : 추후 edge단으로 추가 가능 
					m.setMobiId(message.getHeaders().get("mqtt_receivedTopic").toString().substring(12));
					//event state				
					MobiState mo = getMobiState(m.getMobiId());
					String eventName = evlauateEvent(mo.getRetalState(), m.getBattery().getBmsStat());
					if(!eventName.equals(mo.getEventState())) {
						mo.setEventState(eventName);
						//insert into event table
						MqttMessage mq = new MqttMessage();
						mq.setPayload("test".getBytes());
						//new ObjectMapper().writeValueAsBytes(mo);
						myPublish.sendToMqtt(new ObjectMapper().writeValueAsBytes(mo),"test1234");
					}
					m.setEventName(eventName);
					m.setMobiId(mo.getMobiId());
					m.setInterfaceDate(sDate2.format(new Date()));
					log.info("date print : >>>" + m.getInterfaceDate());
					//rental state
					m.setRentalState(mo.getRetalState());
					m.setBattId(mo.getBattId());
					m.setUserId(mo.getUserId());
					
					log.info(" >>>>>>>>>>>> [t.getId()] = {}", m.getGps().getCreated());
					mobiRepo.save(m);
					// 데이터
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
	}
	
	public String evlauateEvent( String rentalState, int mobiState ) throws Exception {
		
		if( rentalState.equals("Rental")) {
			switch(mobiState) {
				case 2://getBmsStat == 2 : Driving
					return "Driving";
				case 3://getBmsStat == 3 : Charging
					return "ChargingOnDriving";
				case 6://getBmsStat == 6 : Fault
					return "FaultOnBattery";
				default:
					return "NoneInRental";

			} 
		}else if( rentalState.equals("Waiting")) {
			switch(mobiState) {
				case 3://getBmsStat == 3 : Charging
					return "ChargingOnStaying";
				case 6://getBmsStat == 6 : Fault
					return "FaultOnBattery";
					
				case 7://getBmsStat == 7 : PostRun
					return "Staying";
				default:
					return "NoneInWaiting";
			} 
		}
		
		return "None";
		
	}
	
	public MobiState getMobiState( String mobiId) {
		
		return mobiBroker.getMobiStateMap().get(mobiId);
		
	}
}