package com.garak.ingestor.conf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.garak.ingestor.nosql.entity.MobilityServRDB;
import com.garak.ingestor.nosql.repository.EventRepository;
import com.garak.ingestor.nosql.repository.MobilityServRDBRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class MobilityEventConfiguration {
	

	@Autowired
	private ObjectMapper objectMapper;
	
	@Bean
	public MobilityEventAdaptor eventChannel(EventRepository eventRepository, ObjectMapper objectMapper) {
		return new MobilityEventAdaptor(eventRepository, objectMapper );
	}
	
	@Bean
	public MobilityStateBroker mobilityStateBroker() {
		
		MobilityStateBroker broker = new MobilityStateBroker();

		return broker;
	}
	
}
