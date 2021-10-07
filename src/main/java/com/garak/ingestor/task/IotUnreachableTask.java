package com.garak.ingestor.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.garak.ingestor.repository.MobilityNosqlRepository;
import com.garak.ingestor.vo.MobilityVO;

public class IotUnreachableTask implements Runnable{
	
	private MobilityNosqlRepository mobiRepo;
//	private MobilityVO mvo;
    private String message;
    Map<String, Long> lastMobility;
    SimpleDateFormat sDate;
    
    public IotUnreachableTask(Map<String, Long> lastMobility, MobilityNosqlRepository mobiRepo){
    	this.mobiRepo = mobiRepo;
    	this.sDate = new SimpleDateFormat("yyyyMMddHHmmssSSS");
//    	this.mvo = new MobilityVO();
//    	this.mvo.setEventCode("FaultOnInterface");
//    	this.mvo.setEventName("FaultOnInterface");
    	this.lastMobility = lastMobility;
        this.message = "IOT Gateway I/F Error";
    }
    // + 32400000
    @Override
    public void run() {
    	lastMobility.entrySet()
    	   .parallelStream()
    	   .forEach(entry -> {
    		   //System.out.println("[" + entry.getValue() + "] Mobility id " + entry.getKey() + "is " + this.message);
    		   //System.out.println("[current mils : " + (System.currentTimeMillis() + 32400000) + "]");
    		   if((entry.getValue() + 10000) < (System.currentTimeMillis() + 32400000) ) {
    			   MobilityVO mvo = new MobilityVO();
    		       mvo.setEventCode("FaultOnInterface");
    		       mvo.setEventName("FaultOnInterface");
    		    	
    			   mvo.setMobiId(entry.getKey());
    			   mvo.setInterfaceDate(sDate.format(new Date()));
    			   //600은 10분입니다. 10분동안 응답없을시 문제발생으로 
    			   System.out.println("Mobility id " + entry.getKey() + "is " + this.message);
    			   mobiRepo.save(mvo);
    		   }
    	   });
        System.out.println("Task time with " + System.currentTimeMillis());
    }
}
