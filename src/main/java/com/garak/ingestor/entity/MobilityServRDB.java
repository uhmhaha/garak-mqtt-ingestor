package com.garak.ingestor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter // getter 메소드 생성
@Builder // 빌더를 사용할 수 있게 함
@ToString(exclude = "MobilityKitRDB")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "mobility_battery_service") // 테이블 명을 작성
public class MobilityServRDB {
    @Id
	@Column(name = "ctrl_serv_id", nullable = false)
	private int ctrl_serv_id;

	@Column(name = "kit_id", nullable = false)
	private String kitId;
	@Column(name = "uid", nullable = false)
	private int uid;
	@Column(name = "ctrl_stat_cd", nullable = false)
	private String ctrlStatCd;
	
    @ManyToOne
    @JoinColumn(name="kit_id", insertable = false, updatable = false)
    private MobilityKitRDB mobilityKitRDB;
}
