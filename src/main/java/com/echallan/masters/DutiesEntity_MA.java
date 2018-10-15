package com.echallan.masters;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ma_duty")
public class DutiesEntity_MA {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "duty_cd")
	private int duty_cd;
	private String duty_name;
	
	public int getDuty_cd() {
		return duty_cd;
	}
	public void setDuty_cd(int duty_cd) {
		this.duty_cd = duty_cd;
	}
	public String getDuty_name() {
		return duty_name;
	}
	public void setDuty_name(String duty_name) {
		this.duty_name = duty_name;
	}
	
	
	
	
	
	
}
