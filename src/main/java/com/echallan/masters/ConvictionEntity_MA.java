package com.echallan.masters;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ma_conviction")
public class ConvictionEntity_MA {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "convction_cd")
	private int convction_cd;
	private String conviction_det;
	public int getConvction_cd() {
		return convction_cd;
	}
	public void setConvction_cd(int convction_cd) {
		this.convction_cd = convction_cd;
	}
	public String getConviction_det() {
		return conviction_det;
	}
	public void setConviction_det(String conviction_det) {
		this.conviction_det = conviction_det;
	}
	
	
	
	}
