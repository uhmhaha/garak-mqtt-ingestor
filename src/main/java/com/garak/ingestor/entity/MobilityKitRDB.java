package com.garak.ingestor.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Where;

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
@Entity(name = "mobility_battery_kit") // 테이블 명을 작성
public class MobilityKitRDB {
    @Id
	@Column(name = "kit_id", nullable = false)
	private String kitId;
	@Column(name = "mobi_id", nullable = false)
	private String mobiId;
	@Column(name = "batt_id", nullable = false)
	private String battId;
	@Column(name = "kit_yn", nullable = false)
	private String kitYn;
	
    @OneToMany(mappedBy = "mobilityKitRDB", fetch = FetchType.EAGER)
    @Where(clause = "ctrl_stat_cd = 'Rental'")
    private Collection<MobilityServRDB> mobilityServRDBs;
}
