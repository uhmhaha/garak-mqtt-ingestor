package com.garak.ingestor.conf;

import java.util.Set;

import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class MobilityEventConfiguration {
	
	private final Set<Integer, String> topics = LinkedHashMap<Integer, String>();;
	
	//configuration으로 rest api로 동적으로 변경가능하다. api-key를 지정  
	
}
