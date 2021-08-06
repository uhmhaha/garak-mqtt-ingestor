package com.garak.ingestor.nosql.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garak.ingestor.nosql.entity.MobilityRDB;
import com.garak.ingestor.nosql.entity.MobilityServRDB;


public interface MobilityServRDBRepository extends JpaRepository<MobilityServRDB, Long> {
	List<MobilityServRDB> findAll();
}
