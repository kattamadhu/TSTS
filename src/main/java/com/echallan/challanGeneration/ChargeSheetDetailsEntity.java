package com.echallan.challanGeneration;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="t_chargesheet_info")
@Table(name="t_chargesheet_info")
public class ChargeSheetDetailsEntity {
	
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
	private int eticket_no;
	private Date cs_issue_dt;
	private int cs_status;
	private int bac_level;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "eticket_no", referencedColumnName = "eticket_no", insertable = false, updatable = false)
    private EticketEntity etktChargeSheetEntity;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + auto_id;
		result = prime * result + bac_level;
		result = prime * result + ((cs_issue_dt == null) ? 0 : cs_issue_dt.hashCode());
		result = prime * result + cs_status;
		result = prime * result + eticket_no;
		result = prime * result + ((etktChargeSheetEntity == null) ? 0 : etktChargeSheetEntity.hashCode());
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
		ChargeSheetDetailsEntity other = (ChargeSheetDetailsEntity) obj;
		if (auto_id != other.auto_id)
			return false;
		if (bac_level != other.bac_level)
			return false;
		if (cs_issue_dt == null) {
			if (other.cs_issue_dt != null)
				return false;
		} else if (!cs_issue_dt.equals(other.cs_issue_dt))
			return false;
		if (cs_status != other.cs_status)
			return false;
		if (eticket_no != other.eticket_no)
			return false;
		if (etktChargeSheetEntity == null) {
			if (other.etktChargeSheetEntity != null)
				return false;
		} else if (!etktChargeSheetEntity.equals(other.etktChargeSheetEntity))
			return false;
		return true;
	}

	public int getEticket_no() {
		return eticket_no;
	}

	public void setEticket_no(int eticket_no) {
		this.eticket_no = eticket_no;
	}

	public Date getCs_issue_dt() {
		return cs_issue_dt;
	}

	public void setCs_issue_dt(Date cs_issue_dt) {
		this.cs_issue_dt = cs_issue_dt;
	}

	public int getCs_status() {
		return cs_status;
	}

	public void setCs_status(int cs_status) {
		this.cs_status = cs_status;
	}

	public int getBac_level() {
		return bac_level;
	}

	public void setBac_level(int bac_level) {
		this.bac_level = bac_level;
	}

	public EticketEntity getEtktChargeSheetEntity() {
		return etktChargeSheetEntity;
	}

	public void setEtktChargeSheetEntity(EticketEntity etktChargeSheetEntity) {
		this.etktChargeSheetEntity = etktChargeSheetEntity;
	}

	public int getAuto_id() {
		return auto_id;
	}

	public void setAuto_id(int auto_id) {
		this.auto_id = auto_id;
	}

	
	


}
