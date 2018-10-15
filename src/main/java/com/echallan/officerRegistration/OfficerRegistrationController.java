package com.echallan.officerRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OfficerRegistrationController {

private static final Logger logger = LoggerFactory.getLogger(OfficerRegistrationController.class);

@Autowired
private OfficerRegistrationService userService;


		@CrossOrigin(origins="http://localhost:4200")
		@GetMapping("/echallan/sendOTP")
		public ServiceResponse getsendOTP(@RequestParam  String mobileNo)  {
			ServiceResponse response=userService.getsendOTP(mobileNo); 
					logger.info("OTP -->"+response.getRespRemark());
			return response;  
		}

		@CrossOrigin(origins="http://localhost:4200")
		@PostMapping("/echallan/userRegistration" )  
		public ServiceResponse getuserRegistration(@RequestBody(required=false)   OfficerRegistrationEntity userRegstrationEntity)  {
			ServiceResponse response= userService.getuserRegistration(userRegstrationEntity); 
			return response;  
		} 
		
		@CrossOrigin(origins="http://localhost:4200")
		@GetMapping("/echallan/forgotPswd" )  
		public ServiceResponse getforgotPswd(@RequestParam  String empID)  {
			ServiceResponse response= userService.getforgotPswd(empID); 
			return response;  
		}
	
		@CrossOrigin(origins="http://localhost:4200")
		@GetMapping("/echallan/officerDetails")
		public ServiceResponse getofficerDetails(@RequestParam  String userID,@RequestParam  String pwd) {
			ServiceResponse response= userService.getofficerDetails(userID,pwd);
			return response; 
		}
		
		@CrossOrigin(origins="http://localhost:4200")
		@GetMapping("/echallan/officerPwdChange")
		public ServiceResponse getofficerChangePswd(@RequestParam  String empID,
				@RequestParam  String oldPwd,@RequestParam  String newPwd) {
			ServiceResponse response= userService.getofficerChangePswd(empID,oldPwd,newPwd);
			return response; 
		}
		
		
	
}