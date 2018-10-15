package com.echallan.challanGeneration;

import java.io.Serializable;

public class IDProofBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idProofCd;
	private String idProofDetails;
	
	public String getIdProofCd() {
		return idProofCd;
	}
	public void setIdProofCd(String idProofCd) {
		this.idProofCd = idProofCd;
	}
	public String getIdProofDetails() {
		return idProofDetails;
	}
	public void setIdProofDetails(String idProofDetails) {
		this.idProofDetails = idProofDetails;
	}
	public IDProofBean() {}
	public IDProofBean(String idProofCd, String idProofDetails) {
		super();
		this.idProofCd = idProofCd;
		this.idProofDetails = idProofDetails;
	}
	
}
