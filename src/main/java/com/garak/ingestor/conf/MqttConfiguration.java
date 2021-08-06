package com.garak.ingestor.conf;

import java.util.List;

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
public class MqttConfiguration {

	@Autowired
	private MobilityRDBRepository mobiRdbRepo;
	@Autowired
	private MobilityRepository mobiRepo;
	@Autowired
	private MqttProperties mqttProp;
	@Autowired
	private MobilityStateBroker mobiBroker;
	
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
					
					log.info(" >>>>>>>>>>>> [t.getId()] = {}", m.getGps().getCreated());
					mobiRepo.save(m);
					// 데이터
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
	}
	
	public EventEntity evlauateEvent( Mobility mobi ) {
		
		EventDto event = new EventDto();
		
		String rentalState = mobiBroker.getMobiState().get(mobi.getId());
		int mobiState = mobi.getBattery().getBmsStat();
		
		if( rentalState.equals("rental")) {
			switch(mobiState) {
				case 2://getBmsStat == 2 : Driving
					event.setEventCode("Driving");
						
					
					break;
				case 3://getBmsStat == 3 : Charging
					event.setEventCode("ChargingOnDriving");
					break;
				case 6://getBmsStat == 6 : Fault
					event.setEventCode("FaultOnBattery");
					break;

			} 
		}else if( rentalState.equals("waiting")) {
			switch(mobiState) {
				case 3://getBmsStat == 3 : Charging
					event.setEventCode("ChargingOnStaying");
					break;
				case 6://getBmsStat == 6 : Fault
					event.setEventCode("FaultOnBattery");
					break;
					
				case 7://getBmsStat == 7 : PostRun
					event.setEventCode("Staying");
					break;
			} 
		}
		
		return null;
	}
}
