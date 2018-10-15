package com.echallan.masters;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ma_id_proof")
public class IdproofEntity_MA {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_proof_cd")
	private int id_proof_cd;
	private String id_proof_det;
	private String id_category;
	
	public int getId_proof_cd() {
		return id_proof_cd;
	}
	public void setId_proof_cd(int id_proof_cd) {
		this.id_proof_cd = id_proof_cd;
	}
	public String getId_proof_det() {
		return id_proof_det;
	}
	public void setId_proof_det(String id_proof_det) {
		this.id_proof_det = id_proof_det;
	}
	public String getId_category() {
		return id_category;
	}
	public void setId_category(String id_category) {
		this.id_category = id_category;
	}
	 
	
	
}
