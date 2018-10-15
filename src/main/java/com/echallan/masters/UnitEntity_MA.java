package com.echallan.masters;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ma_unit")
public class UnitEntity_MA {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Unit_cd")
	private int Unit_cd;
	@Column(name = "state_cd")
	private int stateCode;
	private String unit_name;
	private String unit_sf;
	
	public int getUnit_cd() {
		return Unit_cd;
	}
	public void setUnit_cd(int unit_cd) {
		Unit_cd = unit_cd;
	}
	public int getStateCode() {
		return stateCode;
	}
	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}
	public String getUnit_name() {
		return unit_name;
	}
	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}
	public String getUnit_sf() {
		return unit_sf;
	}
	public void setUnit_sf(String unit_sf) {
		this.unit_sf = unit_sf;
	}
	
	
	
}
