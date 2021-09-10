package com.garak.ingestor.conf;

import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.garak.ingestor.entity.MobilityKitRDB;
import com.garak.ingestor.entity.MobilityRDB;
import com.garak.ingestor.entity.MobilityServRDB;
import com.garak.ingestor.entity.UserRDB;
import com.garak.ingestor.repository.MobilityBatteryKitRDBRepository;
import com.garak.ingestor.repository.MobilityRDBRepository;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class MobilityStateBroker {

	private Map<String, MobiState> mobiStateMap;
	private Map<String, MobilityRDB> mobiMasterMap;

	@Autowired
	private MobilityBatteryKitRDBRepository mobiKitRDBRepo;

	@Autowired
	private MobilityRDBRepository mobiRDBRepo;

	@PostConstruct
	@Transactional
	public void init() {
		mobiMasterMap = mobiRDBRepo.findAll().stream()
				.collect(Collectors.toMap(MobilityRDB::getMobiId, x -> (MobilityRDB) x));

		mobiStateMap = mobiKitRDBRepo.findByKitYn("Y").stream()
				.filter(m -> m.getMobilityServRDBs().iterator().hasNext())
				.collect(Collectors.toMap(MobilityKitRDB::getMobiId, (m) -> {
					MobilityServRDB m1 = m.getMobilityServRDBs().iterator().next();
					log.debug("kit_id" + m1.getKitId());
					return new MobiState(m1.getCtrlStatCd(), m.getMobiId(), m.getBattId(), m1.getUid(), null,
							m1.getCtrl_serv_id(), m1.getKitId(), m1.getCtrlStatCd(),
							mobiMasterMap.get(m.getMobiId()).getMobiRegiNum(),
							mobiMasterMap.get(m.getMobiId()).getMobiTypCd(), null); // setMobiTypNm("");
				}));
	}
}

@Getter
@Setter
@Builder
class MobiState {
	private String retalState;
	private String mobiId;
	private int battId;
	private int userId;
	private String eventState;

	private int ctrlServId;
	private String kitId;
	private String ctrlStatCd;

	private String mobiRegiNum;
	private String mobiTypCd;
	private String mobiTypNm;

}
