package com.echallan.rta;

import java.text.SimpleDateFormat;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RTAService {
	
	private static final Logger logger = LoggerFactory.getLogger(RTAService.class);
	
	@Autowired
	private RTARepository rtaRepository;
	
	@Autowired
	private DLRepository dlRepository;
	
	
	@Transactional
	public RCEntity getRCDetails(String regnNo) {
		
		RCEntity resp=null;
		try {
			
			Optional<RCEntity> rcentity =rtaRepository.findById(regnNo);
			
			if(rcentity.isPresent()) {
				resp=rcentity.get();
			}
			if (resp!=null) {
				logger.info("RC details found for Regn No:"+resp.getRegnNo());
				
			}else {
				logger.info("RC details Not found for Regn No:"+regnNo);
				
			}
			
			
		} catch (Exception e) {
			logger.error("[method:addUser] ERROR:",e);
		}
		
		 return resp;
	}

	@Transactional
	public DLEntity getDLDetails(String dlNo) {
		
		DLEntity resp=null;
		try {
			
			Optional<DLEntity> dlentity =dlRepository.findById(dlNo);
			
			if(dlentity.isPresent()) {
				resp=dlentity.get();
			}
			if (resp!=null) {
				logger.info("DL details found for DL No:"+resp.getLdcDlNO());
				
			}else {
				logger.info("DL details Not found for DL No:"+dlNo);
				
			}
			
			
		} catch (Exception e) {
			logger.error("[method:addUser] ERROR:",e);
		}
		
		 return resp;
	}
	@Transactional
	public DLEntity getDLDOBDetails(String dlNo, String dlDOB) {
		
		DLEntity resp=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			
			
			DLEntity dlentity =dlRepository.findByLdcDlNOAndLdcDob(dlNo,sdf.parse(dlDOB));
			
			if(dlentity!=null) {
				resp=dlentity;
			}
			if (resp!=null) {
				logger.info("DL details found for DL No:"+resp.getLdcDlNO() +" DOB :"+dlDOB);
				
			}else {
				logger.info("DL details Not found for DL No:"+dlNo+" DOB :"+dlDOB);
				
			}
			
			
		} catch (Exception e) {
			logger.error("[method:addUser] ERROR:",e);
		}
		
		 return resp;
	}
	
}
