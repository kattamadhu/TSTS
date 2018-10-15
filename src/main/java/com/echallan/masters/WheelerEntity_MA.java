package com.echallan.masters;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ma_wheeler")
public class WheelerEntity_MA {

	
	private String wheeler_cd;
	
	@Id
	@Column(name = "rta_vclass_id")
	private String rta_vclass_id;
	private String veh_class;
	
	public String getWheeler_cd() {
		return wheeler_cd;
	}
	public void setWheeler_cd(String wheeler_cd) {
		this.wheeler_cd = wheeler_cd;
	}
	public String getRta_vclass_id() {
		return rta_vclass_id;
	}
	public void setRta_vclass_id(String rta_vclass_id) {
		this.rta_vclass_id = rta_vclass_id;
	}
	public String getVeh_class() {
		return veh_class;
	}
	public void setVeh_class(String veh_class) {
		this.veh_class = veh_class;
	}
	
	
}
