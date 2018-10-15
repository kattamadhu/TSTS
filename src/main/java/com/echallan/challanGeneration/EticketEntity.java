package com.echallan.challanGeneration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity(name="t_eticket")
@Table(name = "t_eticket")
public class EticketEntity {

	@Id
	@Column(name = "eticket_no")
	private int eticket_no;
	
	private int transaction_id;
	
	@OneToMany(mappedBy = "etktVioEntity",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<ViolationsEntity> violationsEntity = new ArrayList<>();
	
	@OneToMany(mappedBy = "etktDetainEntity",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<DetainReleaseEntity> detainEntity = new ArrayList<>();
	
	@OneToMany(mappedBy = "etktDriverEntity",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<DriverDetailsEntity> driverDetailsEntity = new ArrayList<>();

	@OneToMany(mappedBy = "etktChargeSheetEntity",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<ChargeSheetDetailsEntity> chargeSheetDetailsEntity = new ArrayList<>();

	@PrePersist
	protected void onCreate() {
		created_dt = new Date();
	}

	private String regn_no;
	private String challan_no;
	private String payment_status;	
	private String amt_collect_by_login_id; 
	private String login_ID;
	
	private Date offence_dt;
	private Date date_of_pay;
	private Date created_dt;

	private long gps_lat;
	private long gps_long;
	
	public long getGps_lat() {
		return gps_lat;
	}
	public void setGps_lat(long gps_lat) {
		this.gps_lat = gps_lat;
	}
	public long getGps_long() {
		return gps_long;
	}
	public void setGps_long(long gps_long) {
		this.gps_long = gps_long;
	}

	private int state_cd;
	private int unit_cd;
	private int dept_cd;
	private int ps_juris_cd;
	private int booked_ps_cd;
	private int responsible_ps_cd;
	
	@Column(name="point_cd")
	private int point_cd;
	
	private int challan_base;
	private int challan_type;
	
	private int cadre_cd;
	
	private int Fine_Amt;
	private int UCh_Amt;
	private int TFine_Amt;
	
	private int paid_amt;
	private int gtwy_cd;
	
	
	private int remark_cd;
	private int reduction_amt;
	private int image;
	private int detain_no_of_items;

	
	
	public List<ViolationsEntity> getViolationsEntity() {
		return violationsEntity;
	}
	public void setViolationsEntity(List<ViolationsEntity> violationsEntity) {
		this.violationsEntity = violationsEntity;
	}
	public List<DriverDetailsEntity> getDriverDetailsEntity() {
		return driverDetailsEntity;
	}
	public void setDriverDetailsEntity(List<DriverDetailsEntity> driverDetailsEntity) {
		this.driverDetailsEntity = driverDetailsEntity;
	}
	public List<DetainReleaseEntity> getDetainEntity() {
		return detainEntity;
	}
	public void setDetainEntity(List<DetainReleaseEntity> detainEntity) {
		this.detainEntity = detainEntity;
	}
	
	public List<ViolationsEntity> getViolations() {
		return violationsEntity;
	}
	public void setViolations(List<ViolationsEntity> violations) {
		this.violationsEntity = violations;
	}
	
	
	public List<ChargeSheetDetailsEntity> getChargeSheetDetailsEntity() {
		return chargeSheetDetailsEntity;
	}
	public void setChargeSheetDetailsEntity(List<ChargeSheetDetailsEntity> chargeSheetDetailsEntity) {
		this.chargeSheetDetailsEntity = chargeSheetDetailsEntity;
	}
	
	public int getEticket_no() {
		return eticket_no;
	}
	public void setEticket_no(int eticket_no) {
		this.eticket_no = eticket_no;
	}
	
	public String getRegn_no() {
		return regn_no;
	}
	public void setRegn_no(String regn_no) {
		this.regn_no = regn_no;
	}
	public String getChallan_no() {
		return challan_no;
	}
	public void setChallan_no(String challan_no) {
		this.challan_no = challan_no;
	}
	public String getPayment_status() {
		return payment_status;
	}
	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}
	public String getAmt_collect_by_login_id() {
		return amt_collect_by_login_id;
	}
	public void setAmt_collect_by_login_id(String amt_collect_by_login_id) {
		this.amt_collect_by_login_id = amt_collect_by_login_id;
	}
	public Date getOffence_dt() {
		return offence_dt;
	}
	public void setOffence_dt(Date offence_dt) {
		this.offence_dt = offence_dt;
	}
	public Date getDate_of_pay() {
		return date_of_pay;
	}
	public void setDate_of_pay(Date date_of_pay) {
		this.date_of_pay = date_of_pay;
	}
	public Date getCreated_dt() {
		return created_dt;
	}
	public void setCreated_dt(Date created_dt) {
		this.created_dt = created_dt;
	}

	public int getState_cd() {
		return state_cd;
	}
	public void setState_cd(int state_cd) {
		this.state_cd = state_cd;
	}
	public int getUnit_cd() {
		return unit_cd;
	}
	public void setUnit_cd(int unit_cd) {
		this.unit_cd = unit_cd;
	}
	public int getDept_cd() {
		return dept_cd;
	}
	public void setDept_cd(int dept_cd) {
		this.dept_cd = dept_cd;
	}
	public int getPs_juris_cd() {
		return ps_juris_cd;
	}
	public void setPs_juris_cd(int ps_juris_cd) {
		this.ps_juris_cd = ps_juris_cd;
	}
	public int getBooked_ps_cd() {
		return booked_ps_cd;
	}
	public void setBooked_ps_cd(int booked_ps_cd) {
		this.booked_ps_cd = booked_ps_cd;
	}
	public int getResponsible_ps_cd() {
		return responsible_ps_cd;
	}
	public void setResponsible_ps_cd(int responsible_ps_cd) {
		this.responsible_ps_cd = responsible_ps_cd;
	}
	
	public int getPoint_cd() {
		return point_cd;
	}
	public void setPoint_cd(int point_cd) {
		this.point_cd = point_cd;
	}
	public int getChallan_base() {
		return challan_base;
	}
	public void setChallan_base(int challan_base) {
		this.challan_base = challan_base;
	}
	public int getChallan_type() {
		return challan_type;
	}
	public void setChallan_type(int challan_type) {
		this.challan_type = challan_type;
	}
	
	public String getLogin_ID() {
		return login_ID;
	}
	public void setLogin_ID(String login_ID) {
		this.login_ID = login_ID;
	}
	public int getCadre_cd() {
		return cadre_cd;
	}
	public void setCadre_cd(int cadre_cd) {
		this.cadre_cd = cadre_cd;
	}
	public int getFine_Amt() {
		return Fine_Amt;
	}
	public void setFine_Amt(int fine_Amt) {
		Fine_Amt = fine_Amt;
	}
	public int getUCh_Amt() {
		return UCh_Amt;
	}
	public void setUCh_Amt(int uCh_Amt) {
		UCh_Amt = uCh_Amt;
	}
	public int getTFine_Amt() {
		return TFine_Amt;
	}
	public void setTFine_Amt(int tFine_Amt) {
		TFine_Amt = tFine_Amt;
	}
	public int getPaid_amt() {
		return paid_amt;
	}
	public void setPaid_amt(int paid_amt) {
		this.paid_amt = paid_amt;
	}
	public int getGtwy_cd() {
		return gtwy_cd;
	}
	public void setGtwy_cd(int gtwy_cd) {
		this.gtwy_cd = gtwy_cd;
	}
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public int getRemark_cd() {
		return remark_cd;
	}
	public void setRemark_cd(int remark_cd) {
		this.remark_cd = remark_cd;
	}
	public int getReduction_amt() {
		return reduction_amt;
	}
	public void setReduction_amt(int reduction_amt) {
		this.reduction_amt = reduction_amt;
	}
	public int getImage() {
		return image;
	}
	public void setImage(int image) {
		this.image = image;
	}
	public int getDetain_no_of_items() {
		return detain_no_of_items;
	}
	public void setDetain_no_of_items(int detain_no_of_items) {
		this.detain_no_of_items = detain_no_of_items;
	}
	
	
	
	
	
	}
