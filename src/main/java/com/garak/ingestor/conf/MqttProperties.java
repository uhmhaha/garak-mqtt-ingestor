package com.garak.ingestor.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@ConfigurationProperties(prefix = "mqtt")
@Component
public class MqttProperties {

	private String url;
	private String clientid;

}
