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
	private ObjectMapper objectMapper;
	@Autowired
	private MqttProperties mqttProp;

	@Bean
	public MessageChannel mqttInputChannel() {
		return new DirectChannel();
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

				System.out.println("before convert" + message.getPayload());
				Mobility m;

				try {
					// 데이터 수신
					m = objectMapper.readValue(message.getPayload().toString(), Mobility.class);
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
}
