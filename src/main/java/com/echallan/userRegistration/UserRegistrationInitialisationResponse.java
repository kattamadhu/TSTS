package com.echallan.userRegistration;

public class UserRegistrationInitialisationResponse {
	private String status,user_otp,user_id;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUser_otp() {
		return user_otp;
	}

	public void setUser_otp(String user_otp) {
		this.user_otp = user_otp;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public UserRegistrationInitialisationResponse(String status, String user_otp, String user_id) {
		super();
		this.status = status;
		this.user_otp = user_otp;
		this.user_id = user_id;
	}
	
	
}
