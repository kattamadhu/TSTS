package com.echallan.masters;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ma_dept")
public class DetainItemEntity_MA {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dt_item_cd")
	private int dt_item_cd;
	private String dt_item_name;
	
	public int getDt_item_cd() {
		return dt_item_cd;
	}
	public void setDt_item_cd(int dt_item_cd) {
		this.dt_item_cd = dt_item_cd;
	}
	public String getDt_item_name() {
		return dt_item_name;
	}
	public void setDt_item_name(String dt_item_name) {
		this.dt_item_name = dt_item_name;
	}
	
	
	
	
	}
