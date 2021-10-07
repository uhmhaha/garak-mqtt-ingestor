package com.garak.ingestor.conf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.garak.ingestor.entity.CodeDetailRDB;
import com.garak.ingestor.repository.CodeDetailRDBRepository;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
//@Component
public class CodeBroker {    
	
	private Map<String, List<CodeDetailRDB>> codeDetailMap;
	
	@Autowired
	private CodeDetailRDBRepository codeRDBRepo;
	
	@PostConstruct
	@Transactional
	public void init() {
		List<CodeDetailRDB> codes =  codeRDBRepo.findByUseYn("Y");
		
		Set<String> groupCodes = codes
		        .stream()
		        .map(CodeDetailRDB::getGroupCode)
		        .collect(Collectors.toSet());
		
		groupCodes.forEach(a -> {
			codeDetailMap.put(a, new ArrayList<CodeDetailRDB>());
		});
		
		for( CodeDetailRDB c : codes) {
			codeDetailMap.get(c.getGroupCode()).add(c);
		}
	}
}


