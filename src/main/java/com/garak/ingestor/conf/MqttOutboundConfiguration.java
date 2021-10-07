package com.garak.ingestor.conf;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class MqttOutboundConfiguration {

	   @Bean
	    public MqttPahoClientFactory mqttClientFactory() {
	        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
	        MqttConnectOptions options = new MqttConnectOptions();
	        options.setServerURIs(new String[] { "tcp://175.106.98.100:1883"});
	        options.setUserName("username");
	        options.setPassword("password".toCharArray());
	        factory.setConnectionOptions(options);
	        return factory;
	    }

	    @Bean
	    @ServiceActivator(inputChannel = "mqttOutboundChannel")
	    public MessageHandler mqttOutbound() {
	        MqttPahoMessageHandler messageHandler =
	                       new MqttPahoMessageHandler(MqttClient.generateClientId(), mqttClientFactory());
	        messageHandler.setAsync(true);
	        messageHandler.setDefaultTopic("testTopic");
	        return messageHandler;
	    }

	    @Bean
	    public MessageChannel mqttOutboundChannel() {
	        return new DirectChannel();
	    }

}
