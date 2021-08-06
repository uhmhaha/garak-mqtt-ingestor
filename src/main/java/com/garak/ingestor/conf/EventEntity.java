package com.garak.ingestor.conf;

import javax.persistence.Column;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter // getter 메소드 생성
@Builder // 빌더를 사용할 수 있게 함
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EventEntity {

	@Column(name = "mobi_id", nullable = false)
	private String eventCode;
	@Column(name = "mobi_id", nullable = false)
	private String eventName;
	@Column(name = "mobi_id", nullable = false)
	private String eventDecsription;
}
