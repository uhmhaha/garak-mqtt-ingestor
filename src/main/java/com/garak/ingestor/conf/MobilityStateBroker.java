package com.garak.ingestor.conf;

import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.garak.ingestor.nosql.entity.MobilityServRDB;
import com.garak.ingestor.nosql.repository.MobilityServRDBRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MobilityStateBroker {    
	
	private Map<String, String> mobiState;
	
	@Autowired
	private MobilityServRDBRepository mobiServRDBRepo;
	
	@PostConstruct
	public void init() {
		mobiState = mobiServRDBRepo.findAll()
				.stream()
				.collect(Collectors.toMap(MobilityServRDB::getMobiId, MobilityServRDB::getCtrlStatCd));
	}
}
