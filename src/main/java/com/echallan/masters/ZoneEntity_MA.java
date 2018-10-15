package com.echallan.masters;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ma_zone")
public class ZoneEntity_MA {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "zone_cd")
	private int zone_cd;
	@Column(name = "division_cd")
	private int divisionCode;
	private int unit_cd;
	private String zone_name;
	
	public int getZone_cd() {
		return zone_cd;
	}
	public void setZone_cd(int zone_cd) {
		this.zone_cd = zone_cd;
	}
	public int getDivisionCode() {
		return divisionCode;
	}
	public void setDivisionCode(int divisionCode) {
		this.divisionCode = divisionCode;
	}
	public int getUnit_cd() {
		return unit_cd;
	}
	public void setUnit_cd(int unit_cd) {
		this.unit_cd = unit_cd;
	}
	public String getZone_name() {
		return zone_name;
	}
	public void setZone_name(String zone_name) {
		this.zone_name = zone_name;
	}
	
	
}
