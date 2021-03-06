package com.garak.ingestor.vo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.garak.ingestor.entity.Battery;
import com.garak.ingestor.entity.Gps;

import lombok.Getter;

//참고 : https://newbedev.com/jackson-how-to-process-deserialize-nested-json
@Getter
@Document(collection="mobility")
public class MobilityVO {

	//ENTITY value
	@Id
	private String id;
	@JsonProperty("GPS")
	private Gps gps;
	@JsonProperty("BMS")
	private Battery battery;
	
	//Chief Data Sample
	//	  mobi_id: "Zigae001",
	//	  mobi_typ_cd: "01",
	//	  mobi_typ_nm: "지게차",
	//	  ctrl_stat_cd: "03",
	//	  ctrl_stat_nm: "충전중",
	//	  address: "서울시 강동구",             // map 에서 call 할때 가져올 예정
	//	  user_id: "",
	//	  user_nm: "",
	//	  interface_time: "2021.08.02 15:30:00",
	//	  lat: "37.49486973147452",         //lat
	//	  lon: "127.10951151762875",        //lon
	//	  reporttime: "2021.08.02 15:30:00", //삭
	//	  ctrl_serv_id: "1223347010",
	//	  department_nm: "기본소속",           //삭제
	//	  mobi_regi_num: "259216",
	//	  speed: 12,                        // 미사용
	//	  batt_soc: 0

	//VO object
	private String mobiId;
	private String mobiTypCd;
	private String mobiTypNm;
	private String ctrlStatCd;
	private String ctrlStatNm;
	private String userId;
	private String userNm;
	private String interfaceDate;
	private int ctrlServId;
	private String mobiRegiNum;
	private int battId;
	
	//VO object - event
	private String eventName;
	private String eventCode;
	private String rentalState;

	public void setMobiId(String mobiId) {
		this.mobiId = mobiId;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}
	
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public void setRentalState(String rentalState) {
		this.rentalState = rentalState;
	}

	public void setBattId(int battId) {
		this.battId = battId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setInterfaceDate(String localDateTime) {
		this.interfaceDate = localDateTime;
	}

	public void setMobiTypCd(String mobiTypCd) {
		this.mobiTypCd = mobiTypCd;
	}

	public void setMobiTypNm(String mobiTypNm) {
		this.mobiTypNm = mobiTypNm;
	}

	public void setCtrlStatCd(String ctrlStatCd) {
		this.ctrlStatCd = ctrlStatCd;
	}

	public void setCtrlStatNm(String ctrlStatNm) {
		this.ctrlStatNm = ctrlStatNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public void setCtrlServId(int ctrlServId) {
		this.ctrlServId = ctrlServId;
	}

	public void setMobiRegiNum(String mobiRegiNum) {
		this.mobiRegiNum = mobiRegiNum;
	}
	
}
