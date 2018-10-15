package com.echallan.challanGeneration;

import java.io.Serializable;

public class ViolationsBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String offenceCode;
	private String offenceDesc;
	private String section;
	private String fineAmount;
	
	public String getFineAmount() {
		return fineAmount;
	}
	public void setFineAmount(String fineAmount) {
		this.fineAmount = fineAmount;
	}
	public String getOffenceCode() {
		return offenceCode;
	}
	public void setOffenceCode(String offenceCode) {
		this.offenceCode = offenceCode;
	}
	public String getOffenceDesc() {
		return offenceDesc;
	}
	public void setOffenceDesc(String offenceDesc) {
		this.offenceDesc = offenceDesc;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public ViolationsBean() {}
	public ViolationsBean(String offenceCode, String offenceDesc, String section,String fineAmount) {
		super();
		this.offenceCode = offenceCode;
		this.offenceDesc = offenceDesc;
		this.section = section;
		this.fineAmount=fineAmount;
	}
	
	
}
