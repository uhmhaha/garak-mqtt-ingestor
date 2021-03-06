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
@Entity(name = "mobility") // 테이블 명을 작성
public class MobilityRDB {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mobi_id", nullable = false)
	private String mobiId;
	@Column(name = "mobi_typ_cd", nullable = false)
	private String mobiTypCd;
	@Column(name = "mobi_nm", nullable = false)
	private String mobiNm;
	@Column(name = "model", nullable = false)
	private String model;
	@Column(name = "mobiRegi_num", nullable = false)
	private String mobiRegiNum;
	@Column(name = "department_nm", nullable = false)
	private String departmentNm;
	@Column(name = "admin_nm", nullable = false)
	private String adminNm;
	@Column(name = "mobi_topic", nullable = false)
	private String mobiTopic;
	

}
