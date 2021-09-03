package com.garak.ingestor.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garak.ingestor.entity.MobilityRDB;
import com.garak.ingestor.entity.MobilityServRDB;


public interface MobilityServRDBRepository extends JpaRepository<MobilityServRDB, Long> {
	List<MobilityServRDB> findAll();
}
