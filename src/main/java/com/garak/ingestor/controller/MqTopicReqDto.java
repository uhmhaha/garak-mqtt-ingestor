package com.garak.ingestor.controller;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MqTopicReqDto {

	private String topicName;
	private String mobiId;
	private String battId;
	
	@Builder
	public MqTopicReqDto(String topicName, String mobiId, String battId) {
		this.topicName = topicName;
		this.mobiId = mobiId;
		this.battId = battId;
	}
}
