package com.garak.ingestor.nosql.entity;

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
@Entity(name = "mobility_battery_service") // 테이블 명을 작성
public class MobilityServRDB {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ctrl_serv_id", nullable = false)
	private int ctrl_serv_id;
	@Column(name = "mobi_id", nullable = false)
	private String mobiId;
	@Column(name = "uid", nullable = false)
	private int uid;
	@Column(name = "ctrl_stat_cd", nullable = false)
	private String ctrlStatCd;
}
