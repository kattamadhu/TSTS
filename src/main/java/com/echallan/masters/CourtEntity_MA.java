package com.echallan.masters;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ma_court")
public class CourtEntity_MA {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "court_cd")
	private int cadre_cd;
	
	@Column(name = "unit_cd")
	private int  unitCode;
	
	private String court_name;
	private String court_address;
	private String court_city;
	
	public int getCadre_cd() {
		return cadre_cd;
	}
	public void setCadre_cd(int cadre_cd) {
		this.cadre_cd = cadre_cd;
	}
	
	public int getUnitCode() {
		return unitCode;
	}
	public void setUnitCode(int unitCode) {
		this.unitCode = unitCode;
	}
	public String getCourt_name() {
		return court_name;
	}
	public void setCourt_name(String court_name) {
		this.court_name = court_name;
	}
	public String getCourt_address() {
		return court_address;
	}
	public void setCourt_address(String court_address) {
		this.court_address = court_address;
	}
	public String getCourt_city() {
		return court_city;
	}
	public void setCourt_city(String court_city) {
		this.court_city = court_city;
	}
	
	
	}
