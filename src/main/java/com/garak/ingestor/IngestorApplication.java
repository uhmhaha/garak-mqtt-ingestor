package com.garak.ingestor;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class IngestorApplication {

	@PostConstruct
	public void start() {
		TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.of("Asia/Seoul")));
		System.out.println(">>>>>>>>>>>>> 현재시각 >>>>>"+ new Date());

	}
	public static void main(String[] args) {
		
		//new SpringApplicationBuilder(IngestorApplication.class).web(WebApplicationType.NONE).run(args);
		SpringApplication.run(IngestorApplication.class, args);
	}

}
