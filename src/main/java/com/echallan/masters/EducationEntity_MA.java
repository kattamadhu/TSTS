package com.echallan.masters;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ma_education")
public class EducationEntity_MA {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "education_cd")
	private int education_cd;
	private String education_det;
	
	public int getEducation_cd() {
		return education_cd;
	}
	public void setEducation_cd(int education_cd) {
		this.education_cd = education_cd;
	}
	public String getEducation_det() {
		return education_det;
	}
	public void setEducation_det(String education_det) {
		this.education_det = education_det;
	}
	
	
	}
