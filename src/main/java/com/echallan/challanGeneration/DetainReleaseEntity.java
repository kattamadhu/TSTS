package com.echallan.challanGeneration;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="t_detain_release_items")
@Table(name="t_detain_release_items")
public class DetainReleaseEntity {
	
	@Id
	@GeneratedValue(
	    strategy= GenerationType.AUTO, 
	    generator="native"
	)
	@GenericGenerator(
	    name = "native", 
	    strategy = "native"
	)
	private int auto_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "eticket_no", referencedColumnName = "eticket_no", insertable = false, updatable = false)
    private EticketEntity etktDetainEntity;
	
	private String dt_By_Login_ID;
	private Date dt_Date;
	private int dt_Item_CD;
	private int dt_Status;
	private String eticket_no;
	private String regn_no;
	private String rl_By_Login_ID;
	private Date rl_Date;
	private int rl_Item_CD;
	private int rl_Status;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + auto_id;
		result = prime * result + ((dt_By_Login_ID == null) ? 0 : dt_By_Login_ID.hashCode());
		result = prime * result + ((dt_Date == null) ? 0 : dt_Date.hashCode());
		result = prime * result + dt_Item_CD;
		result = prime * result + dt_Status;
		result = prime * result + ((eticket_no == null) ? 0 : eticket_no.hashCode());
		result = prime * result + ((etktDetainEntity == null) ? 0 : etktDetainEntity.hashCode());
		result = prime * result + ((regn_no == null) ? 0 : regn_no.hashCode());
		result = prime * result + ((rl_By_Login_ID == null) ? 0 : rl_By_Login_ID.hashCode());
		result = prime * result + ((rl_Date == null) ? 0 : rl_Date.hashCode());
		result = prime * result + rl_Item_CD;
		result = prime * result + rl_Status;
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
		DetainReleaseEntity other = (DetainReleaseEntity) obj;
		if (auto_id != other.auto_id)
			return false;
		if (dt_By_Login_ID == null) {
			if (other.dt_By_Login_ID != null)
				return false;
		} else if (!dt_By_Login_ID.equals(other.dt_By_Login_ID))
			return false;
		if (dt_Date == null) {
			if (other.dt_Date != null)
				return false;
		} else if (!dt_Date.equals(other.dt_Date))
			return false;
		if (dt_Item_CD != other.dt_Item_CD)
			return false;
		if (dt_Status != other.dt_Status)
			return false;
		if (eticket_no == null) {
			if (other.eticket_no != null)
				return false;
		} else if (!eticket_no.equals(other.eticket_no))
			return false;
		if (etktDetainEntity == null) {
			if (other.etktDetainEntity != null)
				return false;
		} else if (!etktDetainEntity.equals(other.etktDetainEntity))
			return false;
		if (regn_no == null) {
			if (other.regn_no != null)
				return false;
		} else if (!regn_no.equals(other.regn_no))
			return false;
		if (rl_By_Login_ID == null) {
			if (other.rl_By_Login_ID != null)
				return false;
		} else if (!rl_By_Login_ID.equals(other.rl_By_Login_ID))
			return false;
		if (rl_Date == null) {
			if (other.rl_Date != null)
				return false;
		} else if (!rl_Date.equals(other.rl_Date))
			return false;
		if (rl_Item_CD != other.rl_Item_CD)
			return false;
		if (rl_Status != other.rl_Status)
			return false;
		return true;
	}


	public EticketEntity getEtktDetainEntity() {
		return etktDetainEntity;
	}

	public void setEtktDetainEntity(EticketEntity etktDetainEntity) {
		this.etktDetainEntity = etktDetainEntity;
	}

	@PrePersist
	protected void onCreate() {
		dt_Date = new Date();
	}

public int getAuto_id() {
		return auto_id;
	}
	public void setAuto_id(int auto_id) {
		this.auto_id = auto_id;
	}
	public String getDt_By_Login_ID() {
		return dt_By_Login_ID;
	}
	public void setDt_By_Login_ID(String dt_By_Login_ID) {
		this.dt_By_Login_ID = dt_By_Login_ID;
	}
	public Date getDt_Date() {
		return dt_Date;
	}
	public void setDt_Date(Date dt_Date) {
		this.dt_Date = dt_Date;
	}
	public int getDt_Item_CD() {
		return dt_Item_CD;
	}
	public void setDt_Item_CD(int dt_Item_CD) {
		this.dt_Item_CD = dt_Item_CD;
	}
	public int getDt_Status() {
		return dt_Status;
	}
	public void setDt_Status(int dt_Status) {
		this.dt_Status = dt_Status;
	}
	public String getEticket_no() {
		return eticket_no;
	}
	public void setEticket_no(String eticket_no) {
		this.eticket_no = eticket_no;
	}
	public String getRegn_no() {
		return regn_no;
	}
	public void setRegn_no(String regn_no) {
		this.regn_no = regn_no;
	}
	public String getRl_By_Login_ID() {
		return rl_By_Login_ID;
	}
	public void setRl_By_Login_ID(String rl_By_Login_ID) {
		this.rl_By_Login_ID = rl_By_Login_ID;
	}
	public Date getRl_Date() {
		return rl_Date;
	}
	public void setRl_Date(Date rl_Date) {
		this.rl_Date = rl_Date;
	}
	public int getRl_Item_CD() {
		return rl_Item_CD;
	}
	public void setRl_Item_CD(int rl_Item_CD) {
		this.rl_Item_CD = rl_Item_CD;
	}
	public int getRl_Status() {
		return rl_Status;
	}
	public void setRl_Status(int rl_Status) {
		this.rl_Status = rl_Status;
	}




}
