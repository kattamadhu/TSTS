package com.echallan.challanGeneration;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class t_hotlistId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int remark_cd;
	private String regn_no;
	private int remark_status;
	

	public t_hotlistId() {
		
	}


	public t_hotlistId(int remark_cd, String regn_no, int remark_status) {
		super();
		this.remark_cd = remark_cd;
		this.regn_no = regn_no;
		this.remark_status = remark_status;
	}
	
	public int getRemark_cd() {
		return remark_cd;
	}


	public String getRegn_no() {
		return regn_no;
	}


	public int getRemark_status() {
		return remark_status;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((regn_no == null) ? 0 : regn_no.hashCode());
		result = prime * result + remark_cd;
		result = prime * result + remark_status;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		t_hotlistId other = (t_hotlistId) obj;
		if (regn_no == null) {
			if (other.regn_no != null)
				return false;
		} else if (!regn_no.equals(other.regn_no))
			return false;
		if (remark_cd != other.remark_cd)
			return false;
		if (remark_status != other.remark_status)
			return false;
		return true;
	}
	
	
}
