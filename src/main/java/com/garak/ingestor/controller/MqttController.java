package com.garak.ingestor.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.garak.ingestor.entity.MobilityRDB;
import com.garak.ingestor.service.MqttService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MqttController {

	private final MqttService mqttService;
	
	@GetMapping("/mqtt/health")
	public String Welcome() {
		return "OK";
	}
	
	/*
	 * add topic
	 * database에 기기등록시 자동으로 등록된 topic 명을 읽어오게되는데
	 * (MqttPahoMessageDrivenChannelAdapter에서 추가구현)
	 * 추가로 등록된 장비가 있을시 구독을 위한 추가장비목록을 로딩한다.
	 */
	@PutMapping("/mqtt/topic")
	public String addTopic(@RequestBody MqTopicReqDto reqDto) {
   
		mqttService.addTopic();
		return "OK";
	}
	
	/*
	 * delete topic 
	 * 장비삭제(또는 탈착등)시 추가적으로 api call을 통해서 장비를 삭제한다.
	 */
	@DeleteMapping("/mqtt/topic")
	public String deleteTopic(@RequestBody MqTopicReqDto reqDto) {
		//추후 해당 mobi id로 삭제로 개발예정 
		return "OK";
	}

}
