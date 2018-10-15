package com.echallan.officerRegistration;

public class ServiceResponse {private int respCode;
private String respDesc;
private Object respRemark;

public int getRespCode() {
	return respCode;
}
public void setRespCode(int respCode) {
	this.respCode = respCode;
}
public String getRespDesc() {
	return respDesc;
}
public void setRespDesc(String respDesc) {
	this.respDesc = respDesc;
}
public Object getRespRemark() {
	return respRemark;
}
public void setRespRemark(Object respRemark) {
	this.respRemark = respRemark;
}
}