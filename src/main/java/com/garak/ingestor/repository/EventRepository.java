package com.garak.ingestor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garak.ingestor.entity.EventRuleEntity;

public interface EventRepository extends JpaRepository<EventRuleEntity, Long> {

}
