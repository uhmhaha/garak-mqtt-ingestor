package com.garak.ingestor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter // getter 메소드 생성
@Builder // 빌더를 사용할 수 있게 함
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "event_detail") // 테이블 명을 작성
public class EventRuleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "evt_id", nullable = false)
	private int eventId;
	@Column(name = "evt_nm", nullable = false)
	private String eventName;
	@Column(name = "evt_upper_limit", nullable = false)
	private float upperlimit;
	@Column(name = "evt_under_limit", nullable = false)
	private float underlimit;
	@Column(name = "evt_upper_msg", nullable = false)
	private String upperlimitDescription;
	@Column(name = "evt_under_msg", nullable = false)
	private String underlimitDescription;

}
