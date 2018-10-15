package com.echallan.masters;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ma_sections")
public class SectionsEntity_MA {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "offence_cd")
	private int offence_cd;
	private String section;
	private String offence_desc;
	
	public int getOffence_cd() {
		return offence_cd;
	}
	public void setOffence_cd(int offence_cd) {
		this.offence_cd = offence_cd;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getOffence_desc() {
		return offence_desc;
	}
	public void setOffence_desc(String offence_desc) {
		this.offence_desc = offence_desc;
	}
	
	
	
	}
