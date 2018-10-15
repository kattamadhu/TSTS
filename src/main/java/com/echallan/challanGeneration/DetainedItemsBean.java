package com.echallan.challanGeneration;

import java.io.Serializable;

public class DetainedItemsBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String detainedItemCode;
	private String detainedItemName;
	private String detainedStatus;

	public String getDetainedStatus() {
		return detainedStatus;
	}
	public void setDetainedStatus(String detainedStatus) {
		this.detainedStatus = detainedStatus;
	}
	public String getDetainedItemCode() {
		return detainedItemCode;
	}
	public void setDetainedItemCode(String detainedItemCode) {
		this.detainedItemCode = detainedItemCode;
	}
	public String getDetainedItemName() {
		return detainedItemName;
	}
	public void setDetainedItemName(String detainedItemName) {
		this.detainedItemName = detainedItemName;
	}
	public DetainedItemsBean() {}
	public DetainedItemsBean(String detainedItemCode, String detainedItemName, String detainedStatus) {
		super();
		this.detainedItemCode = detainedItemCode;
		this.detainedItemName = detainedItemName;
		this.detainedStatus = detainedStatus;
	}
	
	
}
