package com.garak.ingestor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.garak.ingestor.vo.MobilityVO;


public interface MobilityNosqlRepository extends MongoRepository<MobilityVO, String> {

}
