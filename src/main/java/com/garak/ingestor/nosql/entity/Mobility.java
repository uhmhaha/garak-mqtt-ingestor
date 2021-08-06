package com.garak.ingestor.nosql.entity;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.garak.ingestor.conf.EventDto;

import lombok.Getter;

//참고 : https://newbedev.com/jackson-how-to-process-deserialize-nested-json
@Getter
public class Mobility {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@JsonProperty("Gps")
	private Gps gps;
	@JsonProperty("Battery")
	private Battery battery;
	
	private EventDto eventState;
}
