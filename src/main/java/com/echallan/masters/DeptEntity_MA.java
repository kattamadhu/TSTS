package com.echallan.masters;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ma_dept")
public class DeptEntity_MA {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dept_cd")
	private int dept_cd;
	private String dept_name;
	public int getDept_cd() {
		return dept_cd;
	}
	public void setDept_cd(int dept_cd) {
		this.dept_cd = dept_cd;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	
	
	
	}
