package com.echallan.officerRegistration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
public class Officer_v {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_id" ,updatable = false)
	private String empId;
	private int state_cd;
	private String state_name;
	
	@Column(name="unit_cd")
	private int unitcd;
	
	private String unit_name;
	private int DIVISION_CD;
	private String DIVISION_NAME;
	private int ZONE_CD;
	private String ZONE_NAME;
	private int ps_cd;
	private String ps_name;
	
	@Column(name = "login_id")
	private String userID;
	private String emp_name;
	private String pwd;
	private int cadre_cd;
	private String cadre_sf;
	private long contact_no;
	private String email_id;
	private int actvie_status;
	private java.util.Date lost_login;
	private int role_cd;
	private String duties;

	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public int getState_cd() {
		return state_cd;
	}
	public void setState_cd(int state_cd) {
		this.state_cd = state_cd;
	}
	public String getState_name() {
		return state_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	} 
	
	
	public int getUnitcd() {
		return unitcd;
	}
	public void setUnitcd(int unitcd) {
		this.unitcd = unitcd; 
	}
	public String getUnit_name() {
		return unit_name;
	}
	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}
	public int getDIVISION_CD() {
		return DIVISION_CD;
	}
	public void setDIVISION_CD(int dIVISION_CD) {
		DIVISION_CD = dIVISION_CD;
	}
	public String getDIVISION_NAME() {
		return DIVISION_NAME;
	}
	public void setDIVISION_NAME(String dIVISION_NAME) {
		DIVISION_NAME = dIVISION_NAME;
	}
	public int getZONE_CD() {
		return ZONE_CD;
	}
	public void setZONE_CD(int zONE_CD) {
		ZONE_CD = zONE_CD;
	}
	public String getZONE_NAME() {
		return ZONE_NAME;
	}
	public void setZONE_NAME(String zONE_NAME) {
		ZONE_NAME = zONE_NAME;
	}
	public int getPs_cd() {
		return ps_cd;
	}
	public void setPs_cd(int ps_cd) {
		this.ps_cd = ps_cd;
	}
	public String getPs_name() {
		return ps_name;
	}
	public void setPs_name(String ps_name) {
		this.ps_name = ps_name;
	}
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
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
	public String getCadre_sf() {
		return cadre_sf;
	}
	public void setCadre_sf(String cadre_sf) {
		this.cadre_sf = cadre_sf;
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
	public int getActvie_status() {
		return actvie_status;
	}
	public void setActvie_status(int actvie_status) {
		this.actvie_status = actvie_status;
	}
	public java.util.Date getLost_login() {
		return lost_login;
	} 
	public void setLost_login(java.util.Date lost_login) {
		this.lost_login = lost_login;
	}
	public int getRole_cd() {
		return role_cd;
	}
	public void setRole_cd(int role_cd) {
		this.role_cd = role_cd;
	}
	public String getDuties() {
		return duties;
	}
	public void setDuties(String duties) {
		this.duties = duties;
	}
}
