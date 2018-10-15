package com.echallan.masters;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ma_point")
public class PointsEntity_MA {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "point_cd")
	private int point_cd;
	@Column(name = "ps_cd")
	private int psCode;
	private String point_name;
	
	
	public int getPoint_cd() {
		return point_cd;
	}
	public void setPoint_cd(int point_cd) {
		this.point_cd = point_cd;
	}
	
	public int getPsCode() {
		return psCode;
	}
	public void setPsCode(int psCode) {
		this.psCode = psCode;
	}
	public String getPoint_name() {
		return point_name;
	}
	public void setPoint_name(String point_name) {
		this.point_name = point_name;
	}
	
	
	
	
	
	
	
}
