package com.echallan.masters;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ma_challan_type")
public class ChallanTypeEntity_MA {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "challan_type")
	private int challan_type;
	
	private String challan_desc;
	private String challan_sf;
	
	
	public int getChallan_type() {
		return challan_type;
	}
	public void setChallan_type(int challan_type) {
		this.challan_type = challan_type;
	}
	public String getChallan_desc() {
		return challan_desc;
	}
	public void setChallan_desc(String challan_desc) {
		this.challan_desc = challan_desc;
	}
	public String getChallan_sf() {
		return challan_sf;
	}
	public void setChallan_sf(String challan_sf) {
		this.challan_sf = challan_sf;
	}
	
	
	
	

	}
