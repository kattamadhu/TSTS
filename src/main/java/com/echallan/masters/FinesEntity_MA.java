package com.echallan.masters;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ma_fines")
public class FinesEntity_MA {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "offence_cd")
	private int offence_cd;
	private int unit_cd;
	private String wheeler_cd;
	private int fine_min;
	private int fine_avg;
	private int fine_max;
	private int penalty_points;
	
	public int getOffence_cd() {
		return offence_cd;
	}
	public void setOffence_cd(int offence_cd) {
		this.offence_cd = offence_cd;
	}
	public int getUnit_cd() {
		return unit_cd;
	}
	public void setUnit_cd(int unit_cd) {
		this.unit_cd = unit_cd;
	}
	public String getWheeler_cd() {
		return wheeler_cd;
	}
	public void setWheeler_cd(String wheeler_cd) {
		this.wheeler_cd = wheeler_cd;
	}
	public int getFine_min() {
		return fine_min;
	}
	public void setFine_min(int fine_min) {
		this.fine_min = fine_min;
	}
	public int getFine_avg() {
		return fine_avg;
	}
	public void setFine_avg(int fine_avg) {
		this.fine_avg = fine_avg;
	}
	public int getFine_max() {
		return fine_max;
	}
	public void setFine_max(int fine_max) {
		this.fine_max = fine_max;
	}
	public int getPenalty_points() {
		return penalty_points;
	}
	public void setPenalty_points(int penalty_points) {
		this.penalty_points = penalty_points;
	}
	
}
