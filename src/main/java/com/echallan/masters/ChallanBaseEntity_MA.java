package com.echallan.masters;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ma_challan_base")
public class ChallanBaseEntity_MA {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "challan_base")
	private int challan_base;
	
	public int getChallan_base() {
		return challan_base;
	} 
	public void setChallan_base(int challan_base) {
		this.challan_base = challan_base;
	}
	public String getChallan_base_desc() {
		return challan_base_desc;
	}
	public void setChallan_base_desc(String challan_base_desc) {
		this.challan_base_desc = challan_base_desc;
	}
	private String challan_base_desc;
	
	}
