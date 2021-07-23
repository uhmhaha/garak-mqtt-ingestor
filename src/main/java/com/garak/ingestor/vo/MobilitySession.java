package com.garak.ingestor.vo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@Getter @Setter
public class MobilitySession {
	
	private static Map<Integer, MobilitySession> mobilitySession;
	private int mobilityId;
	private String mobilityStatus;
	
	MobilitySession(){
		mobilitySession = new HashMap<>();
		
	}
	
}
