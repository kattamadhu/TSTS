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

@Entity(name="t_driver_info")
@Table(name="t_driver_info")
public class DriverDetailsEntity {
	
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
    private EticketEntity etktDriverEntity;
	
	public EticketEntity getEtktDriverEntity() {
		return etktDriverEntity;
	}
	public void setEtktDriverEntity(EticketEntity etktDriverEntity) {
		this.etktDriverEntity = etktDriverEntity;
	}
	private String eticket_no;
	private String name;
	private String parent_name;
	private String address;
	private String id_det;
	
	private Date created_dt;
	private Date dob;
	
	private int age;
	private int gender;
	private int id_proof_cd;
	private long contact_no;
	private int occupation_cd;
	private int education_cd;
	private int penalty_points; 
	
	@PrePersist
	protected void onCreate() {
		created_dt = new Date();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + age;
		result = prime * result + auto_id;
		result = prime * result + (int) (contact_no ^ (contact_no >>> 32));
		result = prime * result + ((created_dt == null) ? 0 : created_dt.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + education_cd;
		result = prime * result + ((eticket_no == null) ? 0 : eticket_no.hashCode());
		result = prime * result + ((etktDriverEntity == null) ? 0 : etktDriverEntity.hashCode());
		result = prime * result + gender;
		result = prime * result + ((id_det == null) ? 0 : id_det.hashCode());
		result = prime * result + id_proof_cd;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + occupation_cd;
		result = prime * result + ((parent_name == null) ? 0 : parent_name.hashCode());
		result = prime * result + penalty_points;
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
		DriverDetailsEntity other = (DriverDetailsEntity) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (age != other.age)
			return false;
		if (auto_id != other.auto_id)
			return false;
		if (contact_no != other.contact_no)
			return false;
		if (created_dt == null) {
			if (other.created_dt != null)
				return false;
		} else if (!created_dt.equals(other.created_dt))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (education_cd != other.education_cd)
			return false;
		if (eticket_no == null) {
			if (other.eticket_no != null)
				return false;
		} else if (!eticket_no.equals(other.eticket_no))
			return false;
		if (etktDriverEntity == null) {
			if (other.etktDriverEntity != null)
				return false;
		} else if (!etktDriverEntity.equals(other.etktDriverEntity))
			return false;
		if (gender != other.gender)
			return false;
		if (id_det == null) {
			if (other.id_det != null)
				return false;
		} else if (!id_det.equals(other.id_det))
			return false;
		if (id_proof_cd != other.id_proof_cd)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (occupation_cd != other.occupation_cd)
			return false;
		if (parent_name == null) {
			if (other.parent_name != null)
				return false;
		} else if (!parent_name.equals(other.parent_name))
			return false;
		if (penalty_points != other.penalty_points)
			return false;
		return true;
	}

	
	public int getAuto_id() {
		return auto_id;
	}
	public void setAuto_id(int auto_id) {
		this.auto_id = auto_id;
	}
	public String getEticket_no() {
		return eticket_no;
	}
	public void setEticket_no(String eticket_no) {
		this.eticket_no = eticket_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParent_name() {
		return parent_name;
	}
	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getId_det() {
		return id_det;
	}
	public void setId_det(String id_det) {
		this.id_det = id_det;
	}
	public Date getCreated_dt() {
		return created_dt;
	}
	public void setCreated_dt(Date created_dt) {
		this.created_dt = created_dt;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getId_proof_cd() {
		return id_proof_cd;
	}
	public void setId_proof_cd(int id_proof_cd) {
		this.id_proof_cd = id_proof_cd;
	}


	public long getContact_no() {
		return contact_no;
	}
	public void setContact_no(long contact_no) {
		this.contact_no = contact_no;
	}
	public int getOccupation_cd() {
		return occupation_cd;
	}
	public void setOccupation_cd(int occupation_cd) {
		this.occupation_cd = occupation_cd;
	}
	public int getEducation_cd() {
		return education_cd;
	}
	public void setEducation_cd(int education_cd) {
		this.education_cd = education_cd;
	}
	public int getPenalty_points() {
		return penalty_points;
	}
	public void setPenalty_points(int penalty_points) {
		this.penalty_points = penalty_points;
	}
	

}
