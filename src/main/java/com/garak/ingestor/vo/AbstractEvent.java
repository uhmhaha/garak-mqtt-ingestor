package com.garak.ingestor.vo;


public abstract class AbstractEvent {
	
	protected boolean warning;
	protected boolean error;
	protected String eventId;
	protected String eventName;
	protected String eventCode;
	protected double eventLowLimit;
	protected double eventHighLimit;
	
	AbstractEvent( ){
		warning = false;
		error = false;
	}
}
