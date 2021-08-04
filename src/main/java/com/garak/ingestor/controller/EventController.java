package com.garak.ingestor.controller;

import java.util.List;

import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.garak.ingestor.conf.MobilityEventAdaptor;
import com.garak.ingestor.conf.MobilityEventHandler;
import com.garak.ingestor.nosql.entity.EventRuleEntity;
import com.garak.ingestor.nosql.repository.EventRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class EventController {

	private final MobilityEventAdaptor mobilityEventAdaptor;
	private final EventRepository eventRepository;
	
	@GetMapping("/event/welcome")
	public String Welcome() {
		return "OK";
	}
	/*
	 * 이벤트 조회 및 등
	 * @return 
	 */
	@GetMapping("/event")
	public List<EventRuleEntity> findAllEvent() {
		return eventRepository.findAll();
	}
	/*
	 * add event
	 * database에 기 등록된 event 목록을 읽어오게되는데
	 * (mobilityEventHandler에서 추가구현)
	 * 추가로 이벤트등록이 있을시 이벤트처리를 위한 구독을 위한 추가이벤트목록을 읽어온다.
	 */
	@PutMapping("/event/topic")
	public void addEvent() {
		mobilityEventAdaptor.addMobilityEvent();
	}

}
