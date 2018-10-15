package com.echallan.masters;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ma_gateway")
public class GatewayEntity_MA {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "gtwy_cd")
	private int gtwy_cd;
	private String gtwy_name;
	private String gtwy_sf;
	private String bank_cd;
	private String bank_name;
	public int getGtwy_cd() {
		return gtwy_cd;
	}
	public void setGtwy_cd(int gtwy_cd) {
		this.gtwy_cd = gtwy_cd;
	}
	public String getGtwy_name() {
		return gtwy_name;
	}
	public void setGtwy_name(String gtwy_name) {
		this.gtwy_name = gtwy_name;
	}
	public String getGtwy_sf() {
		return gtwy_sf;
	}
	public void setGtwy_sf(String gtwy_sf) {
		this.gtwy_sf = gtwy_sf;
	}
	public String getBank_cd() {
		return bank_cd;
	}
	public void setBank_cd(String bank_cd) {
		this.bank_cd = bank_cd;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	
	
	
	
	
	
	}
