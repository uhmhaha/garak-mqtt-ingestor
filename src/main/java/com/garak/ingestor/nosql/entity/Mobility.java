package com.garak.ingestor.nosql.entity;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

//참고 : https://newbedev.com/jackson-how-to-process-deserialize-nested-json
@Getter
public class Mobility {

	@Id
	private String id;
	@JsonProperty("Gps")
	private Gps gps;
	@JsonProperty("Battery")
	private Battery battery;

}
