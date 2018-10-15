package com.echallan.reports;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="enforce_officer_v")
public class EnforcementEntity {
	
	private int 	state_cd;
	private String 	state_name;
	private int 	unit_cd;
	private String 	unit_name;
	private int 	division_cd;
	private String 	division_name;
	private int 	zone_cd;
	private String 	zone_name;
	private int 	ps_cd;
	private String 	ps_name;
	
	private String 	emp_id;
	@Id
	@Column(name="login_id")
	private String 	userID;
	private String 	emp_name;
	private int 	cadre_cd;
	private String 	cadre_sf;
	private long	contact_no;

	private java.util.Date 	created_dt;
	
	private int 	cAMERA;
	private BigInteger 	cAMERA_AMT;
	private int 	rEDLIGHT;
	private BigInteger 	rEDLIGHT_AMT;
	private int 	lASERGUN;
	private BigInteger 	lASERGUN_Amt;
	private int 	sCMC;
	private BigInteger 	sCMC_Amt;
	private int 	sOCIALNETWORK;
	private BigInteger 	sOCIALNETWORK_Amt;
	private int 	cRANE;
	private BigInteger 	cRANE_Amt;
	private int 	sPOT;
	public int getState_cd() {
		return state_cd;
	}
	public void setState_cd(int state_cd) {
		this.state_cd = state_cd;
	}
	public String getState_name() {
		return state_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	public int getUnit_cd() {
		return unit_cd;
	}
	public void setUnit_cd(int unit_cd) {
		this.unit_cd = unit_cd;
	}
	public String getUnit_name() {
		return unit_name;
	}
	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}
	public int getDivision_cd() {
		return division_cd;
	}
	public void setDivision_cd(int division_cd) {
		this.division_cd = division_cd;
	}
	public String getDivision_name() {
		return division_name;
	}
	public void setDivision_name(String division_name) {
		this.division_name = division_name;
	}
	public int getZone_cd() {
		return zone_cd;
	}
	public void setZone_cd(int zone_cd) {
		this.zone_cd = zone_cd;
	}
	public String getZone_name() {
		return zone_name;
	}
	public void setZone_name(String zone_name) {
		this.zone_name = zone_name;
	}
	public int getPs_cd() {
		return ps_cd;
	}
	public void setPs_cd(int ps_cd) {
		this.ps_cd = ps_cd;
	}
	public String getPs_name() {
		return ps_name;
	}
	public void setPs_name(String ps_name) {
		this.ps_name = ps_name;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public int getCadre_cd() {
		return cadre_cd;
	}
	public void setCadre_cd(int cadre_cd) {
		this.cadre_cd = cadre_cd;
	}
	public String getCadre_sf() {
		return cadre_sf;
	}
	public void setCadre_sf(String cadre_sf) {
		this.cadre_sf = cadre_sf;
	}
	public long getContact_no() {
		return contact_no;
	}
	public void setContact_no(long contact_no) {
		this.contact_no = contact_no;
	}
	public java.util.Date getCreated_dt() {
		return created_dt;
	}
	public void setCreated_dt(java.util.Date created_dt) {
		this.created_dt = created_dt;
	}
	public int getcAMERA() {
		return cAMERA;
	}
	public void setcAMERA(int cAMERA) {
		this.cAMERA = cAMERA;
	}
	public BigInteger getcAMERA_AMT() {
		return cAMERA_AMT;
	}
	public void setcAMERA_AMT(BigInteger cAMERA_AMT) {
		this.cAMERA_AMT = cAMERA_AMT;
	}
	public int getrEDLIGHT() {
		return rEDLIGHT;
	}
	public void setrEDLIGHT(int rEDLIGHT) {
		this.rEDLIGHT = rEDLIGHT;
	}
	public BigInteger getrEDLIGHT_AMT() {
		return rEDLIGHT_AMT;
	}
	public void setrEDLIGHT_AMT(BigInteger rEDLIGHT_AMT) {
		this.rEDLIGHT_AMT = rEDLIGHT_AMT;
	}
	public int getlASERGUN() {
		return lASERGUN;
	}
	public void setlASERGUN(int lASERGUN) {
		this.lASERGUN = lASERGUN;
	}
	public BigInteger getlASERGUN_Amt() {
		return lASERGUN_Amt;
	}
	public void setlASERGUN_Amt(BigInteger lASERGUN_Amt) {
		this.lASERGUN_Amt = lASERGUN_Amt;
	}
	public int getsCMC() {
		return sCMC;
	}
	public void setsCMC(int sCMC) {
		this.sCMC = sCMC;
	}
	public BigInteger getsCMC_Amt() {
		return sCMC_Amt;
	}
	public void setsCMC_Amt(BigInteger sCMC_Amt) {
		this.sCMC_Amt = sCMC_Amt;
	}
	public int getsOCIALNETWORK() {
		return sOCIALNETWORK;
	}
	public void setsOCIALNETWORK(int sOCIALNETWORK) {
		this.sOCIALNETWORK = sOCIALNETWORK;
	}
	public BigInteger getsOCIALNETWORK_Amt() {
		return sOCIALNETWORK_Amt;
	}
	public void setsOCIALNETWORK_Amt(BigInteger sOCIALNETWORK_Amt) {
		this.sOCIALNETWORK_Amt = sOCIALNETWORK_Amt;
	}
	public int getcRANE() {
		return cRANE;
	}
	public void setcRANE(int cRANE) {
		this.cRANE = cRANE;
	}
	public BigInteger getcRANE_Amt() {
		return cRANE_Amt;
	}
	public void setcRANE_Amt(BigInteger cRANE_Amt) {
		this.cRANE_Amt = cRANE_Amt;
	}
	public int getsPOT() {
		return sPOT;
	}
	public void setsPOT(int sPOT) {
		this.sPOT = sPOT;
	}
	public BigInteger getsPOT_Amt() {
		return sPOT_Amt;
	}
	public void setsPOT_Amt(BigInteger sPOT_Amt) {
		this.sPOT_Amt = sPOT_Amt;
	}
	public int getsPOT_CHARGESHEET() {
		return sPOT_CHARGESHEET;
	}
	public void setsPOT_CHARGESHEET(int sPOT_CHARGESHEET) {
		this.sPOT_CHARGESHEET = sPOT_CHARGESHEET;
	}
	public int getdD() {
		return dD;
	}
	public void setdD(int dD) {
		this.dD = dD;
	}
	public int getoTHERS() {
		return oTHERS;
	}
	public void setoTHERS(int oTHERS) {
		this.oTHERS = oTHERS;
	}
	public BigInteger getoTHERS_Amt() {
		return oTHERS_Amt;
	}
	public void setoTHERS_Amt(BigInteger oTHERS_Amt) {
		this.oTHERS_Amt = oTHERS_Amt;
	}
	private BigInteger 	sPOT_Amt;
	private int 	sPOT_CHARGESHEET;
	private int 	dD;
	private int 	oTHERS;
	private BigInteger 	oTHERS_Amt;
	
	



}
