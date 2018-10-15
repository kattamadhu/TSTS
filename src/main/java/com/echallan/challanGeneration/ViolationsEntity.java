package com.echallan.challanGeneration;

import java.io.Serializable;
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

@Entity(name="t_violations")
@Table(name="t_violations")
public class ViolationsEntity implements Serializable {
	private static final long serialVersionUID = 1L;	
	
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
    private EticketEntity etktVioEntity;
	

	public EticketEntity getEtktVioEntity() {
		return etktVioEntity;
	}
	public void setEtktVioEntity(EticketEntity etktVioEntity) {
		this.etktVioEntity = etktVioEntity;
	}
	private int eticket_no;
    private int offence_cd;
	private int AFine_Amt;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + AFine_Amt;
		result = prime * result + auto_id;
		result = prime * result + ((created_dt == null) ? 0 : created_dt.hashCode());
		result = prime * result + eticket_no;
		result = prime * result + ((etktVioEntity == null) ? 0 : etktVioEntity.hashCode());
		result = prime * result + offence_cd;
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
		ViolationsEntity other = (ViolationsEntity) obj;
		if (AFine_Amt != other.AFine_Amt)
			return false;
		if (auto_id != other.auto_id)
			return false;
		if (created_dt == null) {
			if (other.created_dt != null)
				return false;
		} else if (!created_dt.equals(other.created_dt))
			return false;
		if (eticket_no != other.eticket_no)
			return false;
		if (etktVioEntity == null) {
			if (other.etktVioEntity != null)
				return false;
		} else if (!etktVioEntity.equals(other.etktVioEntity))
			return false;
		if (offence_cd != other.offence_cd)
			return false;
		return true;
	}
	public int getAuto_id() {
		return auto_id;
	}
	public void setAuto_id(int auto_id) {
		this.auto_id = auto_id;
	}
	
	@PrePersist
	protected void onCreate() {
		created_dt = new Date();
	}
	private Date created_dt;
	
	public int getEticket_no() {
		return eticket_no;
	}
	public void setEticket_no(int eticket_no) {
		this.eticket_no = eticket_no;
	}
	public int getOffence_cd() {
		return offence_cd;
	}
	public void setOffence_cd(int offence_cd) {
		this.offence_cd = offence_cd;
	}
	public int getAFine_Amt() {
		return AFine_Amt;
	}
	public void setAFine_Amt(int aFine_Amt) {
		AFine_Amt = aFine_Amt;
	}
	public Date getCreated_dt() {
		return created_dt;
	}
	public void setCreated_dt(Date created_dt) {
		this.created_dt = created_dt;
	}
	
	
	




}
