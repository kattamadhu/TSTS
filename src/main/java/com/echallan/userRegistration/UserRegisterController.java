package com.echallan.userRegistration;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserRegisterController {

private static final Logger logger = LoggerFactory.getLogger(UserRegisterController.class);

@Autowired
private UserRegisterService userRegisterService;

@GetMapping("/Test")
public String getResponse() {
	return "Hello wrold";
}

@RequestMapping(value = "/user/userOTP", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST)
public UserRegistrationInitialisationResponse userRegistrationInitialization(@Valid @RequestBody UserEntity user) {
	UserRegistrationInitialisationResponse response= userRegisterService.addUser(user);
	logger.info("UserRegistrationInitialisationResponse:"+response);
	return response;
	
}


@RequestMapping(value = "/user/registerUser", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST)
public UserRegistrationResponse UserRegisterCommit(@Valid @RequestBody UserEntity user) {
	UserRegistrationResponse  response= userRegisterService.registerUser(user);
	return response;
	
}

}