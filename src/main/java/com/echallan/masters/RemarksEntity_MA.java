package com.echallan.masters;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ma_remarks")
public class RemarksEntity_MA {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "remark_cd")
	private int remark_cd;
	private String remark_desc;
	
	public int getRemark_cd() {
		return remark_cd;
	}
	public void setRemark_cd(int remark_cd) {
		this.remark_cd = remark_cd;
	}
	public String getRemark_desc() {
		return remark_desc;
	}
	public void setRemark_desc(String remark_desc) {
		this.remark_desc = remark_desc;
	}
	
	
	
	
	
}
