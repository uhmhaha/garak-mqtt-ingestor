package com.garak.ingestor.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garak.ingestor.entity.MobilityRDB;


public interface MobilityRDBRepository extends JpaRepository<MobilityRDB, Long> {
	List<MobilityRDB> findAll();
}
