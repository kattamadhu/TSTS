package com.echallan.officerRegistration;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ma_login_id")
public class OfficerRegistrationEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "emp_id")
	private String emp_id;
	
	@Column(name = "login_id")
	private String loginId;
	
	private String pwd;
	private String  emp_name;
	private String email_id;
	private long contact_no;
	private java.util.Date last_login;
	private int role_cd;
	private int cadre_cd;
	private int ps_cd;
	private int active_status;
	private int otp_no;
	
	
	public String getEmp_id() {
		return emp_id; 
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id; 
	}
	
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public long getContact_no() {
		return contact_no;
	}
	public void setContact_no(long contact_no) {
		this.contact_no = contact_no;
	}
	public java.util.Date getLast_login() {
		return last_login;
	}
	public void setLast_login(java.util.Date last_login) {
		this.last_login = last_login;
	}
	public int getRole_cd() {
		return role_cd;
	}
	public void setRole_cd(int role_cd) {
		this.role_cd = role_cd;
	}
	public int getCadre_cd() {
		return cadre_cd;
	}
	public void setCadre_cd(int cadre_cd) {
		this.cadre_cd = cadre_cd;
	}
	public int getPs_cd() {
		return ps_cd;
	}
	public void setPs_cd(int ps_cd) {
		this.ps_cd = ps_cd;
	}
	public int getOtp_no() {
		return otp_no;
	}
	public void setOtp_no(int otp_no) {
		this.otp_no = otp_no;
	}
	public int getActive_status() {
		return active_status;
	}
	public void setActive_status(int active_status) {
		this.active_status = active_status;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String toString() {
		return 
				"emp_id :"+emp_id+" login_id:"+loginId+" pwd:"+pwd+"emp_name"+emp_name+" email_id:"+email_id+" contact_no:"+contact_no
				+" role_cd:"+role_cd+"cadre_cd"+cadre_cd+" ps_cd:"+ps_cd+" active_status:"+active_status+" otp_no"+otp_no;
	}
}
