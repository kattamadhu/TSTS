package com.echallan.masters;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ma_ps")
public class PsEntity_MA {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ps_cd")
	private int ps_cd;
	
	@Column(name = "zone_cd")
	private int zoneCode;
	
	private String ps_name;
	private String ps_sf;
	private int contact_no;
	private String email_id;
	
	public int getPs_cd() {
		return ps_cd;
	}
	public void setPs_cd(int ps_cd) {
		this.ps_cd = ps_cd;
	}
	public int getZoneCode() {
		return zoneCode;
	}
	public void setZoneCode(int zoneCode) {
		this.zoneCode = zoneCode;
	}
	public String getPs_name() {
		return ps_name;
	}
	public void setPs_name(String ps_name) {
		this.ps_name = ps_name;
	}
	public String getPs_sf() {
		return ps_sf;
	}
	public void setPs_sf(String ps_sf) {
		this.ps_sf = ps_sf;
	}
	
	public int getContact_no() {
		return contact_no;
	}
	public void setContact_no(int contact_no) {
		this.contact_no = contact_no;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	
	
	
	
	
}
