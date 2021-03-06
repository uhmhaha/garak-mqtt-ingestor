package com.garak.ingestor.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.garak.ingestor.entity.MobilityRDB;
import com.garak.ingestor.entity.UserRDB;


public interface MobilityRDBRepository extends JpaRepository<MobilityRDB, Long> {
	List<MobilityRDB> findAll();

}
