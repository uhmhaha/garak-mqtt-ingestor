package com.garak.ingestor.conf;

import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.garak.ingestor.entity.UserRDB;
import com.garak.ingestor.repository.UserRDBRepository;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class UserStateBroker {    
	
	private Map<Integer, UserRDB> userStateMap;
	
	@Autowired
	private UserRDBRepository userRDBRepo;
	
	@PostConstruct
	@Transactional
	public void init() {
		userStateMap = userRDBRepo.findByUseYn("Y")
				.stream()
				.collect(Collectors.toMap(UserRDB::getId, x -> (UserRDB)x));
	}
}


