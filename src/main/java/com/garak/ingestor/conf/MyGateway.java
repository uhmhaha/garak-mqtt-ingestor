package com.garak.ingestor.conf;

import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface MyGateway {

    void sendToMqtt(String data);
    void sendToMqtt(String payload, @Header(MqttHeaders.TOPIC) String topic);
    void sendToMqtt(MqttMessage payload, @Header(MqttHeaders.TOPIC) String topic);
    void sendToMqtt(MqttMessage payload);
    void sendToMqtt(byte[] bytes, @Header(MqttHeaders.TOPIC) String topic);

}