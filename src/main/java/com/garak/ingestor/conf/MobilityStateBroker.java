package com.garak.ingestor.conf;

import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.garak.ingestor.nosql.entity.MobilityKitRDB;
import com.garak.ingestor.nosql.entity.MobilityServRDB;
import com.garak.ingestor.nosql.repository.MobilityKitRDBRepository;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class MobilityStateBroker {    
	
	private Map<String, MobiState> mobiStateMap;
	
	@Autowired
	private MobilityKitRDBRepository mobiKitRDBRepo;
	
	@PostConstruct
	@Transactional
	public void init() {
		mobiStateMap = mobiKitRDBRepo.findByKitYn("Y")
				.stream()
				.filter(m -> m.getMobilityServRDBs().iterator().hasNext())
				.collect(Collectors.toMap(MobilityKitRDB::getKitId,
								(m) -> { 
										MobilityServRDB m1  = m.getMobilityServRDBs().iterator().next();
										log.debug("kit_id" + m1.getKitId());
										return new MobiState(m1.getCtrlStatCd(),
											 m.getMobiId(), m.getBattId(), m1.getUid(),null);
							   }
							)
						);
	}
}
@Getter
@Setter
@Builder
class MobiState {
	private String retalState;
	private String mobiId;
	private String battId;
	private int userId;
	private String eventState;
}

