package com.echallan.userRegistration;

public class UserRegistrationResponse {
	private String status;

	public UserRegistrationResponse(String status) {
		super();
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
