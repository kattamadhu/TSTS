package com.echallan.officerRegistration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ma_login_id")
public class MALoginIDEntity {
	
	
	private int ps_cd;
	
	@Id
	@Column(name="emp_id")
	private String empID;
	
	private String emp_name;
	private String login_id;
	private String pwd;
	private int cadre_cd;
	private long contact_no;
	private String email_id;
	private int active_status;
	private java.util.Date last_login;
	private int role_cd;
	private int otp_no;
	public int getPs_cd() {
		return ps_cd;
	}
	public void setPs_cd(int ps_cd) {
		this.ps_cd = ps_cd;
	}
	
	public String getEmpID() {
		return empID;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getCadre_cd() {
		return cadre_cd;
	}
	public void setCadre_cd(int cadre_cd) {
		this.cadre_cd = cadre_cd;
	}
	public long getContact_no() {
		return contact_no;
	}
	public void setContact_no(long contact_no) {
		this.contact_no = contact_no;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public int getActive_status() {
		return active_status;
	}
	public void setActive_status(int active_status) {
		this.active_status = active_status;
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
	public int getOtp_no() {
		return otp_no;
	}
	public void setOtp_no(int otp_no) {
		this.otp_no = otp_no;
	}
	
	

}
