package com.garak.ingestor.conf;

import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.garak.ingestor.entity.CodeDetailRDB;
import com.garak.ingestor.entity.UserRDB;
import com.garak.ingestor.repository.CodeDetailRDBRepository;
import com.garak.ingestor.repository.UserRDBRepository;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
//@Component
public class CodeBroker {    
	
	private Map<String, CodeDetailRDB> codeDetailMap;
	
	@Autowired
	private CodeDetailRDBRepository codeRDBRepo;
	
	@PostConstruct
	@Transactional
	public void init() {
		codeDetailMap = codeRDBRepo.findByUseYn("Y")
				.stream()
				.collect(Collectors.toMap(CodeDetailRDB::getCode, x -> (CodeDetailRDB)x));
	}
}


