package com.garak.ingestor.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.garak.ingestor.conf.EventRuleEntity;
import com.garak.ingestor.nosql.repository.EventRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class EventController {

	private final EventRepository eventRepository;
	@GetMapping("/")
	public String Welcome() {
		return "OK";
	}
	/*
	 * 멤버 조회
	 * @return 
	 */
	@GetMapping("/event")
	public List<EventRuleEntity> findAllEvent() {
		return eventRepository.findAll();
	}

}
