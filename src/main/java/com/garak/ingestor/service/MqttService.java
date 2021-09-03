package com.garak.ingestor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.stereotype.Service;

import com.garak.ingestor.entity.MobilityRDB;
import com.garak.ingestor.repository.MobilityRDBRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MqttService {
	
	private final MqttPahoMessageDrivenChannelAdapter adapter;
	private final MobilityRDBRepository mobiRdbRepo;	
	
	public void addTopic() {
		Optional<List<MobilityRDB>> mobis = Optional.of(mobiRdbRepo.findAll());
		String[] topics = mobis.orElseThrow(() -> new IllegalArgumentException("There is no data : id "))
				               .stream()
				               .map( mobi -> mobi.getMobiTopic())
				               .toArray(String[]::new);
		adapter.addTopic(topics);  
	}
}
