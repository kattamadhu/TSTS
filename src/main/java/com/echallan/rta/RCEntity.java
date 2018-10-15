package com.echallan.rta;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ma_rta_regn")
public class RCEntity {

	@Id
	@Column(name = "REGN_NO")
	private String regnNo;
	
	private	Date iss_dt     ;
	private	Date valid_upto ;
	private	Date ownfr_dt   ;
	private	Date dob        ;
	private	Date fc_validity;
	private	Date permit_validity ;
	private	Date insurance_validity 	;
	private	Date tax_validity    ;
	private	Date ownto_dt   ;
	private	Date created_dt ;	
	private	BigDecimal	rvd_cc     ;
	private	BigDecimal	cylinder   ;
	private	BigDecimal	hp         ;	
	private Integer pin_code;
	private	int	seat_capacity   ;
	private String city;
	private	String	mandal;
	private	String	rvc_vcl_id ;
	private	String	o_name     ;
	private	String	f_name     ;
	private	String	aadhar_no  ;
	private	String	address    ;
	private	String	district_cd;
	private	String	pan_no     ;
	private	String	district   ;
	private	String	off_cd     ;
	private	String	state_cd   ;
	private	String	iss_pls    ;
	private	String	o_status   ;
	private	String	contact_no ;
	private	String	insurance_no;
	private	String	eng_no     ;
	private	String	email_id   ;
	private	String	fuel       ;
	private	String	colour     ;
	private	String	permit_no  ;
	private	String	fc_no      ;
	private	String	vclass_id  ;
	private	String	veh_type   ;
	private	String	veh_class  ;
	private	String	chas_no    ;
	private	String	bdy_type   ;
	private	String	mkr_name   ;
	private	String	mkr_clas   ;
	public String getRegnNo() {
		return regnNo;
	}
	public void setRegnNo(String regnNo) {
		this.regnNo = regnNo;
	}
	
	
	public Integer getPin_code() {
		return pin_code;
	}
	public void setPin_code(Integer pin_code) {
		this.pin_code = pin_code;
	}
	public Date getIss_dt() {
		return iss_dt;
	}
	public void setIss_dt(Date iss_dt) {
		this.iss_dt = iss_dt;
	}
	public Date getValid_upto() {
		return valid_upto;
	}
	public void setValid_upto(Date valid_upto) {
		this.valid_upto = valid_upto;
	}
	public Date getOwnfr_dt() {
		return ownfr_dt;
	}
	public void setOwnfr_dt(Date ownfr_dt) {
		this.ownfr_dt = ownfr_dt;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getFc_validity() {
		return fc_validity;
	}
	public void setFc_validity(Date fc_validity) {
		this.fc_validity = fc_validity;
	}
	public Date getPermit_validity() {
		return permit_validity;
	}
	public void setPermit_validity(Date permit_validity) {
		this.permit_validity = permit_validity;
	}
	public Date getInsurance_validity() {
		return insurance_validity;
	}
	public void setInsurance_validity(Date insurance_validity) {
		this.insurance_validity = insurance_validity;
	}
	public Date getTax_validity() {
		return tax_validity;
	}
	public void setTax_validity(Date tax_validity) {
		this.tax_validity = tax_validity;
	}
	public Date getOwnto_dt() {
		return ownto_dt;
	}
	public void setOwnto_dt(Date ownto_dt) {
		this.ownto_dt = ownto_dt;
	}
	public Date getCreated_dt() {
		return created_dt;
	}
	public void setCreated_dt(Date created_dt) {
		this.created_dt = created_dt;
	}
	public BigDecimal getRvd_cc() {
		return rvd_cc;
	}
	public void setRvd_cc(BigDecimal rvd_cc) {
		this.rvd_cc = rvd_cc;
	}
	public BigDecimal getCylinder() {
		return cylinder;
	}
	public void setCylinder(BigDecimal cylinder) {
		this.cylinder = cylinder;
	}
	public BigDecimal getHp() {
		return hp;
	}
	public void setHp(BigDecimal hp) {
		this.hp = hp;
	}
	public int getSeat_capacity() {
		return seat_capacity;
	}
	public void setSeat_capacity(int seat_capacity) {
		this.seat_capacity = seat_capacity;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMandal() {
		return mandal;
	}
	public void setMandal(String mandal) {
		this.mandal = mandal;
	}
	public String getRvc_vcl_id() {
		return rvc_vcl_id;
	}
	public void setRvc_vcl_id(String rvc_vcl_id) {
		this.rvc_vcl_id = rvc_vcl_id;
	}
	public String getO_name() {
		return o_name;
	}
	public void setO_name(String o_name) {
		this.o_name = o_name;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getAadhar_no() {
		return aadhar_no;
	}
	public void setAadhar_no(String aadhar_no) {
		this.aadhar_no = aadhar_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDistrict_cd() {
		return district_cd;
	}
	public void setDistrict_cd(String district_cd) {
		this.district_cd = district_cd;
	}
	public String getPan_no() {
		return pan_no;
	}
	public void setPan_no(String pan_no) {
		this.pan_no = pan_no;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getOff_cd() {
		return off_cd;
	}
	public void setOff_cd(String off_cd) {
		this.off_cd = off_cd;
	}
	public String getState_cd() {
		return state_cd;
	}
	public void setState_cd(String state_cd) {
		this.state_cd = state_cd;
	}
	public String getIss_pls() {
		return iss_pls;
	}
	public void setIss_pls(String iss_pls) {
		this.iss_pls = iss_pls;
	}
	public String getO_status() {
		return o_status;
	}
	public void setO_status(String o_status) {
		this.o_status = o_status;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public String getInsurance_no() {
		return insurance_no;
	}
	public void setInsurance_no(String insurance_no) {
		this.insurance_no = insurance_no;
	}
	public String getEng_no() {
		return eng_no;
	}
	public void setEng_no(String eng_no) {
		this.eng_no = eng_no;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getPermit_no() {
		return permit_no;
	}
	public void setPermit_no(String permit_no) {
		this.permit_no = permit_no;
	}
	public String getFc_no() {
		return fc_no;
	}
	public void setFc_no(String fc_no) {
		this.fc_no = fc_no;
	}
	public String getVclass_id() {
		return vclass_id;
	}
	public void setVclass_id(String vclass_id) {
		this.vclass_id = vclass_id;
	}
	public String getVeh_type() {
		return veh_type;
	}
	public void setVeh_type(String veh_type) {
		this.veh_type = veh_type;
	}
	public String getVeh_class() {
		return veh_class;
	}
	public void setVeh_class(String veh_class) {
		this.veh_class = veh_class;
	}
	public String getChas_no() {
		return chas_no;
	}
	public void setChas_no(String chas_no) {
		this.chas_no = chas_no;
	}
	public String getBdy_type() {
		return bdy_type;
	}
	public void setBdy_type(String bdy_type) {
		this.bdy_type = bdy_type;
	}
	public String getMkr_name() {
		return mkr_name;
	}
	public void setMkr_name(String mkr_name) {
		this.mkr_name = mkr_name;
	}
	public String getMkr_clas() {
		return mkr_clas;
	}
	public void setMkr_clas(String mkr_clas) {
		this.mkr_clas = mkr_clas;
	}
	

	
	
}
