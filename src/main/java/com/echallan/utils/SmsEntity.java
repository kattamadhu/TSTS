package com.echallan.utils;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_sms")
public class SmsEntity {
	
	@Id
	private int auto_id;
	
	private int unit_cd;
	private String eticket_no;
	private int sms_mode_cd;
	private String sent_status;
	private String regn_no;
	private String otp_verify;
	
	@Column(name="contact_no")
	private long contactNo;
	
	@Column(name="otp_no")
	private int otpNo;
	
	@Column(name="sms_sent_dt" , insertable=false)
	private Date smsDT; 

	public int getAuto_id() {
		return auto_id;
	}
	public void setAuto_id(int auto_id) {
		this.auto_id = auto_id;
	}
	public int getUnit_cd() {
		return unit_cd;
	}
	public void setUnit_cd(int unit_cd) {
		this.unit_cd = unit_cd;
	}
	public String getEticket_no() {
		return eticket_no;
	}
	public void setEticket_no(String eticket_no) {
		this.eticket_no = eticket_no;
	}
	public int getSms_mode_cd() {
		return sms_mode_cd;
	}
	public void setSms_mode_cd(int sms_mode_cd) {
		this.sms_mode_cd = sms_mode_cd;
	}
	
	public String getSent_status() {
		return sent_status;
	}
	public void setSent_status(String sent_status) {
		this.sent_status = sent_status;
	}
	public String getRegn_no() {
		return regn_no;
	}
	public void setRegn_no(String regn_no) {
		this.regn_no = regn_no;
	}

	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	public int getOtpNo() {
		return otpNo;
	}
	public void setOtpNo(int otpNo) {
		this.otpNo = otpNo;
	}
	public String getOtp_verify() {
		return otp_verify;
	}
	public void setOtp_verify(String otp_verify) {
		this.otp_verify = otp_verify;
	}
	public Date getSmsDT() {
		return smsDT;
	}
	public void setSmsDT(Date smsDT) {
		this.smsDT = smsDT;
	}
	
	
	
}
