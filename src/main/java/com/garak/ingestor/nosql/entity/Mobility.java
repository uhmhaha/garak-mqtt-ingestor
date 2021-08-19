package com.garak.ingestor.nosql.entity;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.garak.ingestor.conf.EventDto;

import lombok.Getter;

//참고 : https://newbedev.com/jackson-how-to-process-deserialize-nested-json
@Getter
public class Mobility {

	@Id
	private String id;
	private String mobiId;
	@JsonProperty("gps")
	private Gps gps;
	@JsonProperty("battery")
	private Battery battery;
	
	private String eventName;
	private String rentalState;
	
	public void setMobiId(String mobiId) {
		this.mobiId = mobiId;
	}
	
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public void setRentalState(String rentalState) {
		this.rentalState = rentalState;
	}
	
	
	
}
