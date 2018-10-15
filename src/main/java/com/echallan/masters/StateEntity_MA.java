package com.echallan.masters;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ma_state")
public class StateEntity_MA {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "state_cd")
	private int state_cd;
	private String state_name;
	private String state_sf;
	
	
	public int getState_cd() {
		return state_cd;
	}
	public void setState_cd(int state_cd) {
		this.state_cd = state_cd;
	}
	public String getState_name() {
		return state_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	public String getState_sf() {
		return state_sf;
	}
	public void setState_sf(String state_sf) {
		this.state_sf = state_sf;
	}
	
	
}
