package com.garak.ingestor.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.garak.ingestor.entity.MobilityKitRDB;
import com.garak.ingestor.entity.MobilityRDB;
import com.garak.ingestor.entity.MobilityServRDB;
import com.garak.ingestor.entity.UserRDB;


public interface UserRDBRepository extends JpaRepository<UserRDB, Long> {
	List<UserRDB> findAll();
	@Transactional
	List<UserRDB> findByUseYn(String userYn);
}
