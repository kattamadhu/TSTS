package com.echallan.userRegistration;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterService {
	private static final Logger logger = LoggerFactory.getLogger(UserRegisterService.class);
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Transactional
	public UserRegistrationInitialisationResponse addUser(UserEntity user) {
		
		UserRegistrationInitialisationResponse resp=null;
		try {
			UserEntity user1=  userRepository.insertUser(user);
			
			if(user1!=null) {
				
				resp=new UserRegistrationInitialisationResponse("SUCCESS",""+user1.getUserOTP(),""+user1.getUserId());
				logger.info("User registration success ********************");
				System.out.println("User registration success ********************");
			}else {
				
				resp=new UserRegistrationInitialisationResponse("FAILED",""+user.getUserOTP(),""+user.getUserId());
				logger.info("User registration failed ********************");
				System.out.println("User registration failed ********************");
			}
			
			
		} catch (Exception e) {
			logger.error("[method:addUser] ERROR:",e);
		}
		
		 return resp;
	}

	@Transactional
	public UserRegistrationResponse registerUser(UserEntity user) {
		
		UserRegistrationResponse resp=null;
		try {
			UserEntity user1= userRepository.registerUser(user);
			
			if(user1!=null && user1.getUserName()!=null) {
				resp=new UserRegistrationResponse("SUCCESS");
				logger.info("registerUser was success *********************");
				System.out.println("registerUser was success *********************");
			}else {
				resp=new UserRegistrationResponse("FAILED");
				logger.info("registerUser was failed *********************");
				System.out.println("registerUser was success *********************");
				
			}
			
		} catch (Exception e) {
			logger.error("[method:registerUser] ERROR:",e);
		}
		
		 return resp;
	}
}
