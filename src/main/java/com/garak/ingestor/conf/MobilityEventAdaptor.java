package com.garak.ingestor.conf;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.management.IntegrationManagedResource;
import org.springframework.jmx.export.annotation.ManagedResource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.garak.ingestor.nosql.entity.Mobility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MobilityEventAdaptor implements MobilityEventHandler {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private final Map<String, EventRuleEntity> events;

	protected MobilityEventAdaptor() {
		this.events = new HashMap<String, EventRuleEntity>();
	}

	@Override
	public void setMobilityEvent( String fieldName ) {
	}

	@Override
	public void setMobilityEvent() {
		// TODO Auto-generated method stub
		
	}
	//configuration으로 rest api로 동적으로 변경가능하다. api-key를 지정
	
}
