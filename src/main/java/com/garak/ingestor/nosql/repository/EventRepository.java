package com.garak.ingestor.nosql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garak.ingestor.nosql.entity.EventRuleEntity;

public interface EventRepository extends JpaRepository<EventRuleEntity, Long> {

}
