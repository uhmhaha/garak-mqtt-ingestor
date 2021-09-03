package com.garak.ingestor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.garak.ingestor.entity.MobilityKitRDB;
import com.garak.ingestor.entity.MobilityServRDB;


public interface MobilityBatteryKitRDBRepository extends JpaRepository<MobilityKitRDB, Long> {
	List<MobilityKitRDB> findAll();
	@Transactional
	List<MobilityKitRDB> findByKitYn(String kitYn);
}
