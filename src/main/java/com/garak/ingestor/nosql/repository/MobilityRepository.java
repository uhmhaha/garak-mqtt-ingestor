package com.garak.ingestor.nosql.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.garak.ingestor.nosql.entity.Mobility;


public interface MobilityRepository extends MongoRepository<Mobility, String> {

}
