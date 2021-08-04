package com.garak.ingestor.conf;

public interface MobilityEventHandler {

	void setMobilityEvent();
	
	default void setMobilityEvent(String outputChannel) {
		throw new UnsupportedOperationException("This MessageProducer does not support setting the channel by name.");
	}
}
