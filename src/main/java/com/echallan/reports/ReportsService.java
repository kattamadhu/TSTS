package com.echallan.reports;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportsService {
	private static final Logger logger = LoggerFactory.getLogger(ReportsService.class);

	
	@Autowired
	private EnforcementRepository enforcementRepository; 
	public Optional<EnforcementEntity> getenforcementReport(String userID) {
		
		Optional<EnforcementEntity> enforce=null;
		try {
			
			enforce=enforcementRepository.findById(userID);
			if(enforce!=null) {
				System.out.println(" Report Found");
			}else
				System.out.println(" Report Not Found");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return enforce;
	}

}
