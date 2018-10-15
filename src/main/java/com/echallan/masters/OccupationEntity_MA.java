package com.echallan.masters;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ma_occupation")
public class OccupationEntity_MA {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ocp_cd")
	private int ocp_cd;
	private String ocp_det;
	
	
	public int getOcp_cd() {
		return ocp_cd;
	}
	public void setOcp_cd(int ocp_cd) {
		this.ocp_cd = ocp_cd;
	}
	public String getOcp_det() {
		return ocp_det;
	}
	public void setOcp_det(String ocp_det) {
		this.ocp_det = ocp_det;
	}
	
	
	
	
}
