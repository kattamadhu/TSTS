package com.echallan.rta;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class RTAController {

private static final Logger logger = LoggerFactory.getLogger(RTAController.class);

@Autowired
private RTAService rtaService;

@GetMapping("/echallan/rta/rc")
public RCEntity getRCDetails(@RequestParam("regnNo") String regnNo) {
	logger.info("getRC method called for regnno regnNo:"+regnNo);
	RCEntity response= rtaService.getRCDetails(regnNo);
	logger.info("getRC Response:"+response);
	return response;
	
}

@GetMapping("/echallan/rta/dl")
public DLEntity getDLDetails(@RequestParam("dlNo") String dlNo) {
	logger.info("[getDLDetails: method] called for dlNo:"+dlNo);
	DLEntity response= rtaService.getDLDetails(dlNo);
	logger.info("getDLDetails Response:"+response);
	return response;

}


	@GetMapping("/echallan/rta/dlNDob")
	public DLEntity getDLDOBDetails(@RequestParam("dlNo") String dlNo,@RequestParam("dlDOB") String dlDOB) {
		logger.info("[getDLDOBDetails: method] called for dlNo:"+dlNo+ " dlDOB:"+dlDOB);
		DLEntity response= rtaService.getDLDOBDetails(dlNo,dlDOB);
		logger.info("getDLDOBDetails Response:"+response);
		return response;
}


}