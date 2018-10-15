package com.echallan.reports;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportsController {
	private static final Logger logger = LoggerFactory.getLogger(ReportsController.class);

	@Autowired
	ReportsService reportsService; 
	
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/echallan/reports/enforcement")
	public Optional<EnforcementEntity> getenforcementReport(@RequestParam  String userID)  {
		Optional<EnforcementEntity> response=reportsService.getenforcementReport(userID); 
		return response;  
	}
	
}
