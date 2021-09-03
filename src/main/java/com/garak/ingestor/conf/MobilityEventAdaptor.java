package com.garak.ingestor.conf;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.garak.ingestor.entity.EventRuleEntity;
import com.garak.ingestor.repository.EventRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MobilityEventAdaptor implements MobilityEventHandler {

	private final Map<String, EventRuleEntity> events;
	private EventRepository eventRepository;
	private ObjectMapper objectMapper;
	
	public MobilityEventAdaptor(EventRepository eventRepository, ObjectMapper objectMapper) {
		this.events = new HashMap<String, EventRuleEntity>();
		this.eventRepository = eventRepository;
		this.objectMapper = objectMapper;
	}

	@Override
	public void setMobilityEvent(String fieldName) {
	}

	@Override
	public void setMobilityEvent() {
		// TODO Auto-generated method stub

	}

	public void addMobilityEvent() {
		// TODO Auto-generated method stub

	}
	// configuration으로 rest api로 동적으로 변경가능하다. api-key를 지정

}
