package com.garak.ingestor.nosql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.garak.ingestor.nosql.entity.MobilityKitRDB;
import com.garak.ingestor.nosql.entity.MobilityServRDB;


public interface MobilityKitRDBRepository extends JpaRepository<MobilityKitRDB, Long> {
	List<MobilityKitRDB> findAll();
	@Transactional
	List<MobilityKitRDB> findByKitYn(String kitYn);
}
