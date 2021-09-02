package com.garak.ingestor.nosql.entity;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

//참고 : https://newbedev.com/jackson-how-to-process-deserialize-nested-json
@Getter
public class Mobility {

	@Id
	private String id;
	private String mobiId;
	private String battId;
	private int userId;
	@JsonProperty("gps")
	private Gps gps;
	@JsonProperty("battery")
	private Battery battery;
	
	private String eventName;
	private String rentalState;
	private String interfaceDate;
	
	public void setMobiId(String mobiId) {
		this.mobiId = mobiId;
	}
	
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public void setRentalState(String rentalState) {
		this.rentalState = rentalState;
	}

	public void setBattId(String battId) {
		this.battId = battId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setInterfaceDate(String localDateTime) {
		this.interfaceDate = localDateTime;
	}
	
}
