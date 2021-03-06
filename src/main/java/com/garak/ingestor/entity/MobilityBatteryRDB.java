package com.garak.ingestor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Entity(name = "battery") // 테이블 명을 작성
public class MobilityBatteryRDB {
    @Id
	@Column(name = "batt_id", nullable = false)
	private String battId;
	@Column(name = "batt_typ_cd", nullable = false)
	private String battTypCd;
}
