package com.garak.ingestor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class IngestorApplication {

	static ObjectMapper objectMapper;

	public static void main(String[] args) {
		//new SpringApplicationBuilder(IngestorApplication.class).web(WebApplicationType.NONE).run(args);
		SpringApplication.run(IngestorApplication.class, args);
	}

}
