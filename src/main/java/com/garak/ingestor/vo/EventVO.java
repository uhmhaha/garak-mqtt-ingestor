package com.garak.ingestor.vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EventVO extends AbstractEvent {

	private String eventId;
	private String eventName;
	private String eventCode;
	private double eventLowLimit;
	private double eventHighLimit;

	
	public EventVO () {
		eventId
		eventName
		eventCode
		eventLowLimit
		eventHighLimit
		warning = false;
		error = false;
		
	}
	
}
