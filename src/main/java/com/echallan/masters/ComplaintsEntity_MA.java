package com.echallan.masters;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ma_complaints")
public class ComplaintsEntity_MA {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cplnt_cd")
	private int cplnt_cd;
	private String cplnt_type;
	private String cplnt_module;
	private String cplnt_desc;
	public int getCplnt_cd() {
		return cplnt_cd;
	}
	public void setCplnt_cd(int cplnt_cd) {
		this.cplnt_cd = cplnt_cd;
	}
	public String getCplnt_type() {
		return cplnt_type;
	}
	public void setCplnt_type(String cplnt_type) {
		this.cplnt_type = cplnt_type;
	}
	public String getCplnt_module() {
		return cplnt_module;
	}
	public void setCplnt_module(String cplnt_module) {
		this.cplnt_module = cplnt_module;
	}
	public String getCplnt_desc() {
		return cplnt_desc;
	}
	public void setCplnt_desc(String cplnt_desc) {
		this.cplnt_desc = cplnt_desc;
	}

	
	}
