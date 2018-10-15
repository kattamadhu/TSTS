package com.echallan.challanGeneration;

import java.io.Serializable;
import java.util.List;

public class RequestParams implements Serializable{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private List<ViolationsBean> violations;
	private List<DetainedItemsBean> dt_items;
	private List<IDProofBean> id_proof;
	
	private String unit_cd;
	private String unitName;
	private String unitShortForm;
	private String stateCode;
	private String challan_type;
	private String enforcementType;
	private String chargeSheetStatus;
	private String baclevel;
	private String paymentStatus;
	private String gatewayCode;
	private String dept_cd;
	private String ps_juris_cd;
	private String responsible_ps_cd;
	private String point_cd;
	private String regn_no;
	private String offence_dt;
	private String pid_cd;
	private String d_of_pay;
	private String paid_amt;
	private String remark_cd;
	private String imageStatus;
	private String challan_base_cd;
	private String dob;
	private String age;
	private String gender;
	private String name;
	private String parent_name;
	private String address;
	private String contact_no;
	private String occupation_cd;
	private String education_cd;
	private String penalty_points;
	private String gps_lat;
	private String gps_long;
	
	public RequestParams() {
		
	}
	
	
	public RequestParams(List<ViolationsBean> violations, List<DetainedItemsBean> dt_items, List<IDProofBean> id_proof,
			String unit_cd, String unitName, String unitShortForm, String stateCode, String challan_type,
			String enforcementType, String chargeSheetStatus, String baclevel, String paymentStatus, String gatewayCode,
			String dept_cd, String ps_juris_cd, String responsible_ps_cd, String point_cd, String regn_no,
			String offence_dt, String pid_cd, String d_of_pay, String paid_amt, String remark_cd, String imageStatus,
			String challan_base_cd, String dob, String age, String gender, String name, String parent_name,
			String address, String contact_no, String occupation_cd, String education_cd, String penalty_points,
			String gps_lat, String gps_long) {
		super();
		this.violations = violations;
		this.dt_items = dt_items;
		this.id_proof = id_proof;
		this.unit_cd = unit_cd;
		this.unitName = unitName;
		this.unitShortForm = unitShortForm;
		this.stateCode = stateCode;
		this.challan_type = challan_type;
		this.enforcementType = enforcementType;
		this.chargeSheetStatus = chargeSheetStatus;
		this.baclevel = baclevel;
		this.paymentStatus = paymentStatus;
		this.gatewayCode = gatewayCode;
		this.dept_cd = dept_cd;
		this.ps_juris_cd = ps_juris_cd;
		this.responsible_ps_cd = responsible_ps_cd;
		this.point_cd = point_cd;
		this.regn_no = regn_no;
		this.offence_dt = offence_dt;
		this.pid_cd = pid_cd;
		this.d_of_pay = d_of_pay;
		this.paid_amt = paid_amt;
		this.remark_cd = remark_cd;
		this.imageStatus = imageStatus;
		this.challan_base_cd = challan_base_cd;
		this.dob = dob;
		this.age = age;
		this.gender = gender;
		this.name = name;
		this.parent_name = parent_name;
		this.address = address;
		this.contact_no = contact_no;
		this.occupation_cd = occupation_cd;
		this.education_cd = education_cd;
		this.penalty_points = penalty_points;
		this.gps_lat = gps_lat;
		this.gps_long = gps_long;
	}


	public List<ViolationsBean> getViolations() {
		return violations;
	}
	public void setViolations(List<ViolationsBean> violations) {
		this.violations = violations;
	}
	public List<DetainedItemsBean> getDt_items() {
		return dt_items;
	}
	public void setDt_items(List<DetainedItemsBean> dt_items) {
		this.dt_items = dt_items;
	}
	public List<IDProofBean> getId_proof() {
		return id_proof;
	}
	public void setId_proof(List<IDProofBean> id_proof) {
		this.id_proof = id_proof;
	}
	public String getUnit_cd() {
		return unit_cd;
	}
	public void setUnit_cd(String unit_cd) {
		this.unit_cd = unit_cd;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getUnitShortForm() {
		return unitShortForm;
	}
	public void setUnitShortForm(String unitShortForm) {
		this.unitShortForm = unitShortForm;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getChallan_type() {
		return challan_type;
	}
	public void setChallan_type(String challan_type) {
		this.challan_type = challan_type;
	}
	public String getEnforcementType() {
		return enforcementType;
	}
	public void setEnforcementType(String enforcementType) {
		this.enforcementType = enforcementType;
	}
	public String getChargeSheetStatus() {
		return chargeSheetStatus;
	}
	public void setChargeSheetStatus(String chargeSheetStatus) {
		this.chargeSheetStatus = chargeSheetStatus;
	}
	public String getBaclevel() {
		return baclevel;
	}
	public void setBaclevel(String baclevel) {
		this.baclevel = baclevel;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getGatewayCode() {
		return gatewayCode;
	}
	public void setGatewayCode(String gatewayCode) {
		this.gatewayCode = gatewayCode;
	}
	public String getDept_cd() {
		return dept_cd;
	}
	public void setDept_cd(String dept_cd) {
		this.dept_cd = dept_cd;
	}
	public String getPs_juris_cd() {
		return ps_juris_cd;
	}
	public void setPs_juris_cd(String ps_juris_cd) {
		this.ps_juris_cd = ps_juris_cd;
	}
	public String getResponsible_ps_cd() {
		return responsible_ps_cd;
	}
	public void setResponsible_ps_cd(String responsible_ps_cd) {
		this.responsible_ps_cd = responsible_ps_cd;
	}
	public String getPoint_cd() {
		return point_cd;
	}
	public void setPoint_cd(String point_cd) {
		this.point_cd = point_cd;
	}
	public String getRegn_no() {
		return regn_no;
	}
	public void setRegn_no(String regn_no) {
		this.regn_no = regn_no;
	}
	public String getOffence_dt() {
		return offence_dt;
	}
	public void setOffence_dt(String offence_dt) {
		this.offence_dt = offence_dt;
	}
	public String getPid_cd() {
		return pid_cd;
	}
	public void setPid_cd(String pid_cd) {
		this.pid_cd = pid_cd;
	}
	public String getD_of_pay() {
		return d_of_pay;
	}
	public void setD_of_pay(String d_of_pay) {
		this.d_of_pay = d_of_pay;
	}
	public String getPaid_amt() {
		return paid_amt;
	}
	public void setPaid_amt(String paid_amt) {
		this.paid_amt = paid_amt;
	}
	public String getRemark_cd() {
		return remark_cd;
	}
	public void setRemark_cd(String remark_cd) {
		this.remark_cd = remark_cd;
	}
	public String getImageStatus() {
		return imageStatus;
	}
	public void setImageStatus(String imageStatus) {
		this.imageStatus = imageStatus;
	}
	public String getChallan_base_cd() {
		return challan_base_cd;
	}
	public void setChallan_base_cd(String challan_base_cd) {
		this.challan_base_cd = challan_base_cd;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public String getOccupation_cd() {
		return occupation_cd;
	}
	public void setOccupation_cd(String occupation_cd) {
		this.occupation_cd = occupation_cd;
	}
	public String getEducation_cd() {
		return education_cd;
	}
	public void setEducation_cd(String education_cd) {
		this.education_cd = education_cd;
	}
	public String getPenalty_points() {
		return penalty_points;
	}
	public void setPenalty_points(String penalty_points) {
		this.penalty_points = penalty_points;
	}
	public String getGps_lat() {
		return gps_lat;
	}
	public void setGps_lat(String gps_lat) {
		this.gps_lat = gps_lat;
	}
	public String getGps_long() {
		return gps_long;
	}
	public void setGps_long(String gps_long) {
		this.gps_long = gps_long;
	}
	
	
}
