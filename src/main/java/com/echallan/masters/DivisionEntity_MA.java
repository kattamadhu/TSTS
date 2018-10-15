package com.echallan.masters;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ma_division")
public class DivisionEntity_MA {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "division_cd")
	private int division_cd;
	
	@Column(name = "unit_cd")
	private int unitCode;
	private String division_name;
	
	public int getDivision_cd() {
		return division_cd;
	}
	public void setDivision_cd(int division_cd) {
		this.division_cd = division_cd;
	}
	
	public int getUnitCode() {
		return unitCode;
	}
	public void setUnitCode(int unitCode) {
		this.unitCode = unitCode;
	}
	public String getDivision_name() {
		return division_name;
	}
	public void setDivision_name(String division_name) {
		this.division_name = division_name;
	}
	
	
	}
