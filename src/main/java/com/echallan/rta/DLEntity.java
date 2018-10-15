package com.echallan.rta;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ma_rta_dl")
public class DLEntity {

	@Id
	@Column(name="LDC_DL_NO")
	private String ldcDlNO;
	
	@Column(name="ldc_DOB")
	private Date ldcDob;
	
	private Date new_HAZARDOUS_VALID_UPTO;
	private Date ldc_VISA_VLD;
	private Date ldc_VLD_TO;
	private Date new_NON_TRANSPORT_VALIDTO;
	private Date new_SUSPENSION_FROM;
	private Date ldc_BVLD_TO;
	private Date ldc_HVLD_TO;
	private Date rta_MWALLET_REGN_DT;
	private Date ldc_BDG_DT;
	private Date new_SUSPENSION_TO;
	
	private Date ldc_ISS_DT;
	
	private Date updated_DT;
	private Date ldc_ENTRY_DATETIME;
	private Date created_DT;
	
	
	private Integer ldc_BDG_NO;
	private Integer ldc_DL_YR;
	private Integer ldc_TPINCD;
	private Integer ldc_PPINCD;
	private Integer traffic_POINTS;
	private Integer mwallet_CONTACT_NO;
	private Integer webservice_IMPORT;
	private Integer webservice_UPDATETIME;
	private Integer ldc_HT;
	
	private String ldc_SEX;
	private String oldNEWFLAG;
	private String ldc_ENTRY_FG;
	private String new_SLNO;
	private String ldc_FAC_NO;
	private String ldc_APPR_CD;
	private String ldc_TPHNO;
	private String ldc_PPHNO;
	private String new_TRANSPORT_COV;
	private String ldc_TADDR1;
	private String new_NONTRANSPORT_COV;
	private String ldc_PADDR1;
	private String ldc_LIC_ST;
	private String ldc_PG_TYP;
	private String ldc_PAN_NO;
	private String ldc_ELEC_NO;
	private String ldc_PHGRPH;
	private String ldc_EDR_NO;
	private String ldc_BDG_LNO;
	
	private String ldc_COA_NO;
	private String ldc_PCITY;
	private String ldc_PSTATE;
	private String ldc_QUAL;
	private String ldc_TSTATE;
	private String ldc_TCITY;
	private String ldc_BLD_GRP;
	private String ldc_DL_TYP;
	private String term;
	private String ldc_PADDR2;
	private String ldc_TADDR2;
	private String ldc_M_NM;
	private String ldc_PADDR3;
	private String ldc_OL_NM;
	private String ldc_TADDR3;
	private String ldc_OF_NM;
	private String ldc_BDG_PLC;
	private String ldc_LIC_OWN;
	private String ldc_MOV_TO;
	private String ldc_OFF_CD;
	private String ldc_F_NM;
	private String ldc_L_NM;
	private String ldc_HCP_DET;
	private String ldc_ID2;
	private String ldc_ID1;
	private String ldc_PG_NM;
	private String ldc_DL_SNO;
	
	public String getLdcDlNO() {
		return ldcDlNO;
	}
	public void setLdcDlNO(String ldcDlNO) {
		this.ldcDlNO = ldcDlNO;
	}
	public Date getLdcDob() {
		return ldcDob;
	}
	public void setLdcDob(Date ldcDob) {
		this.ldcDob = ldcDob;
	}
	public Date getNew_HAZARDOUS_VALID_UPTO() {
		return new_HAZARDOUS_VALID_UPTO;
	}
	public void setNew_HAZARDOUS_VALID_UPTO(Date new_HAZARDOUS_VALID_UPTO) {
		this.new_HAZARDOUS_VALID_UPTO = new_HAZARDOUS_VALID_UPTO;
	}
	public Date getLdc_VISA_VLD() {
		return ldc_VISA_VLD;
	}
	public void setLdc_VISA_VLD(Date ldc_VISA_VLD) {
		this.ldc_VISA_VLD = ldc_VISA_VLD;
	}
	public Date getLdc_VLD_TO() {
		return ldc_VLD_TO;
	}
	public void setLdc_VLD_TO(Date ldc_VLD_TO) {
		this.ldc_VLD_TO = ldc_VLD_TO;
	}
	public Date getNew_NON_TRANSPORT_VALIDTO() {
		return new_NON_TRANSPORT_VALIDTO;
	}
	public void setNew_NON_TRANSPORT_VALIDTO(Date new_NON_TRANSPORT_VALIDTO) {
		this.new_NON_TRANSPORT_VALIDTO = new_NON_TRANSPORT_VALIDTO;
	}
	public Date getNew_SUSPENSION_FROM() {
		return new_SUSPENSION_FROM;
	}
	public void setNew_SUSPENSION_FROM(Date new_SUSPENSION_FROM) {
		this.new_SUSPENSION_FROM = new_SUSPENSION_FROM;
	}
	public Date getLdc_BVLD_TO() {
		return ldc_BVLD_TO;
	}
	public void setLdc_BVLD_TO(Date ldc_BVLD_TO) {
		this.ldc_BVLD_TO = ldc_BVLD_TO;
	}
	public Date getLdc_HVLD_TO() {
		return ldc_HVLD_TO;
	}
	public void setLdc_HVLD_TO(Date ldc_HVLD_TO) {
		this.ldc_HVLD_TO = ldc_HVLD_TO;
	}
	public Date getRta_MWALLET_REGN_DT() {
		return rta_MWALLET_REGN_DT;
	}
	public void setRta_MWALLET_REGN_DT(Date rta_MWALLET_REGN_DT) {
		this.rta_MWALLET_REGN_DT = rta_MWALLET_REGN_DT;
	}
	public Date getLdc_BDG_DT() {
		return ldc_BDG_DT;
	}
	public void setLdc_BDG_DT(Date ldc_BDG_DT) {
		this.ldc_BDG_DT = ldc_BDG_DT;
	}
	public Date getNew_SUSPENSION_TO() {
		return new_SUSPENSION_TO;
	}
	public void setNew_SUSPENSION_TO(Date new_SUSPENSION_TO) {
		this.new_SUSPENSION_TO = new_SUSPENSION_TO;
	}
	public Date getLdc_ISS_DT() {
		return ldc_ISS_DT;
	}
	public void setLdc_ISS_DT(Date ldc_ISS_DT) {
		this.ldc_ISS_DT = ldc_ISS_DT;
	}
	
	public Date getUpdated_DT() {
		return updated_DT;
	}
	public void setUpdated_DT(Date updated_DT) {
		this.updated_DT = updated_DT;
	}
	public Date getLdc_ENTRY_DATETIME() {
		return ldc_ENTRY_DATETIME;
	}
	public void setLdc_ENTRY_DATETIME(Date ldc_ENTRY_DATETIME) {
		this.ldc_ENTRY_DATETIME = ldc_ENTRY_DATETIME;
	}
	public Date getCreated_DT() {
		return created_DT;
	}
	public void setCreated_DT(Date created_DT) {
		this.created_DT = created_DT;
	}
	public Integer getLdc_BDG_NO() {
		return ldc_BDG_NO;
	}
	public void setLdc_BDG_NO(Integer ldc_BDG_NO) {
		this.ldc_BDG_NO = ldc_BDG_NO;
	}
	public Integer getLdc_DL_YR() {
		return ldc_DL_YR;
	}
	public void setLdc_DL_YR(Integer ldc_DL_YR) {
		this.ldc_DL_YR = ldc_DL_YR;
	}
	public Integer getLdc_TPINCD() {
		return ldc_TPINCD;
	}
	public void setLdc_TPINCD(Integer ldc_TPINCD) {
		this.ldc_TPINCD = ldc_TPINCD;
	}
	public Integer getLdc_PPINCD() {
		return ldc_PPINCD;
	}
	public void setLdc_PPINCD(Integer ldc_PPINCD) {
		this.ldc_PPINCD = ldc_PPINCD;
	}
	public Integer getTraffic_POINTS() {
		return traffic_POINTS;
	}
	public void setTraffic_POINTS(Integer traffic_POINTS) {
		this.traffic_POINTS = traffic_POINTS;
	}
	public Integer getMwallet_CONTACT_NO() {
		return mwallet_CONTACT_NO;
	}
	public void setMwallet_CONTACT_NO(Integer mwallet_CONTACT_NO) {
		this.mwallet_CONTACT_NO = mwallet_CONTACT_NO;
	}
	public Integer getWebservice_IMPORT() {
		return webservice_IMPORT;
	}
	public void setWebservice_IMPORT(Integer webservice_IMPORT) {
		this.webservice_IMPORT = webservice_IMPORT;
	}
	public Integer getWebservice_UPDATETIME() {
		return webservice_UPDATETIME;
	}
	public void setWebservice_UPDATETIME(Integer webservice_UPDATETIME) {
		this.webservice_UPDATETIME = webservice_UPDATETIME;
	}
	public Integer getLdc_HT() {
		return ldc_HT;
	}
	public void setLdc_HT(Integer ldc_HT) {
		this.ldc_HT = ldc_HT;
	}
	public String getLdc_SEX() {
		return ldc_SEX;
	}
	public void setLdc_SEX(String ldc_SEX) {
		this.ldc_SEX = ldc_SEX;
	}
	public String getOldNEWFLAG() {
		return oldNEWFLAG;
	}
	public void setOldNEWFLAG(String oldNEWFLAG) {
		this.oldNEWFLAG = oldNEWFLAG;
	}
	public String getLdc_ENTRY_FG() {
		return ldc_ENTRY_FG;
	}
	public void setLdc_ENTRY_FG(String ldc_ENTRY_FG) {
		this.ldc_ENTRY_FG = ldc_ENTRY_FG;
	}
	public String getNew_SLNO() {
		return new_SLNO;
	}
	public void setNew_SLNO(String new_SLNO) {
		this.new_SLNO = new_SLNO;
	}
	public String getLdc_FAC_NO() {
		return ldc_FAC_NO;
	}
	public void setLdc_FAC_NO(String ldc_FAC_NO) {
		this.ldc_FAC_NO = ldc_FAC_NO;
	}
	public String getLdc_APPR_CD() {
		return ldc_APPR_CD;
	}
	public void setLdc_APPR_CD(String ldc_APPR_CD) {
		this.ldc_APPR_CD = ldc_APPR_CD;
	}
	public String getLdc_TPHNO() {
		return ldc_TPHNO;
	}
	public void setLdc_TPHNO(String ldc_TPHNO) {
		this.ldc_TPHNO = ldc_TPHNO;
	}
	public String getLdc_PPHNO() {
		return ldc_PPHNO;
	}
	public void setLdc_PPHNO(String ldc_PPHNO) {
		this.ldc_PPHNO = ldc_PPHNO;
	}
	public String getNew_TRANSPORT_COV() {
		return new_TRANSPORT_COV;
	}
	public void setNew_TRANSPORT_COV(String new_TRANSPORT_COV) {
		this.new_TRANSPORT_COV = new_TRANSPORT_COV;
	}
	public String getLdc_TADDR1() {
		return ldc_TADDR1;
	}
	public void setLdc_TADDR1(String ldc_TADDR1) {
		this.ldc_TADDR1 = ldc_TADDR1;
	}
	public String getNew_NONTRANSPORT_COV() {
		return new_NONTRANSPORT_COV;
	}
	public void setNew_NONTRANSPORT_COV(String new_NONTRANSPORT_COV) {
		this.new_NONTRANSPORT_COV = new_NONTRANSPORT_COV;
	}
	public String getLdc_PADDR1() {
		return ldc_PADDR1;
	}
	public void setLdc_PADDR1(String ldc_PADDR1) {
		this.ldc_PADDR1 = ldc_PADDR1;
	}
	public String getLdc_LIC_ST() {
		return ldc_LIC_ST;
	}
	public void setLdc_LIC_ST(String ldc_LIC_ST) {
		this.ldc_LIC_ST = ldc_LIC_ST;
	}
	public String getLdc_PG_TYP() {
		return ldc_PG_TYP;
	}
	public void setLdc_PG_TYP(String ldc_PG_TYP) {
		this.ldc_PG_TYP = ldc_PG_TYP;
	}
	public String getLdc_PAN_NO() {
		return ldc_PAN_NO;
	}
	public void setLdc_PAN_NO(String ldc_PAN_NO) {
		this.ldc_PAN_NO = ldc_PAN_NO;
	}
	public String getLdc_ELEC_NO() {
		return ldc_ELEC_NO;
	}
	public void setLdc_ELEC_NO(String ldc_ELEC_NO) {
		this.ldc_ELEC_NO = ldc_ELEC_NO;
	}
	public String getLdc_PHGRPH() {
		return ldc_PHGRPH;
	}
	public void setLdc_PHGRPH(String ldc_PHGRPH) {
		this.ldc_PHGRPH = ldc_PHGRPH;
	}
	public String getLdc_EDR_NO() {
		return ldc_EDR_NO;
	}
	public void setLdc_EDR_NO(String ldc_EDR_NO) {
		this.ldc_EDR_NO = ldc_EDR_NO;
	}
	public String getLdc_BDG_LNO() {
		return ldc_BDG_LNO;
	}
	public void setLdc_BDG_LNO(String ldc_BDG_LNO) {
		this.ldc_BDG_LNO = ldc_BDG_LNO;
	}
	public String getLdc_COA_NO() {
		return ldc_COA_NO;
	}
	public void setLdc_COA_NO(String ldc_COA_NO) {
		this.ldc_COA_NO = ldc_COA_NO;
	}
	public String getLdc_PCITY() {
		return ldc_PCITY;
	}
	public void setLdc_PCITY(String ldc_PCITY) {
		this.ldc_PCITY = ldc_PCITY;
	}
	public String getLdc_PSTATE() {
		return ldc_PSTATE;
	}
	public void setLdc_PSTATE(String ldc_PSTATE) {
		this.ldc_PSTATE = ldc_PSTATE;
	}
	public String getLdc_QUAL() {
		return ldc_QUAL;
	}
	public void setLdc_QUAL(String ldc_QUAL) {
		this.ldc_QUAL = ldc_QUAL;
	}
	public String getLdc_TSTATE() {
		return ldc_TSTATE;
	}
	public void setLdc_TSTATE(String ldc_TSTATE) {
		this.ldc_TSTATE = ldc_TSTATE;
	}
	public String getLdc_TCITY() {
		return ldc_TCITY;
	}
	public void setLdc_TCITY(String ldc_TCITY) {
		this.ldc_TCITY = ldc_TCITY;
	}
	public String getLdc_BLD_GRP() {
		return ldc_BLD_GRP;
	}
	public void setLdc_BLD_GRP(String ldc_BLD_GRP) {
		this.ldc_BLD_GRP = ldc_BLD_GRP;
	}
	public String getLdc_DL_TYP() {
		return ldc_DL_TYP;
	}
	public void setLdc_DL_TYP(String ldc_DL_TYP) {
		this.ldc_DL_TYP = ldc_DL_TYP;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getLdc_PADDR2() {
		return ldc_PADDR2;
	}
	public void setLdc_PADDR2(String ldc_PADDR2) {
		this.ldc_PADDR2 = ldc_PADDR2;
	}
	public String getLdc_TADDR2() {
		return ldc_TADDR2;
	}
	public void setLdc_TADDR2(String ldc_TADDR2) {
		this.ldc_TADDR2 = ldc_TADDR2;
	}
	public String getLdc_M_NM() {
		return ldc_M_NM;
	}
	public void setLdc_M_NM(String ldc_M_NM) {
		this.ldc_M_NM = ldc_M_NM;
	}
	public String getLdc_PADDR3() {
		return ldc_PADDR3;
	}
	public void setLdc_PADDR3(String ldc_PADDR3) {
		this.ldc_PADDR3 = ldc_PADDR3;
	}
	public String getLdc_OL_NM() {
		return ldc_OL_NM;
	}
	public void setLdc_OL_NM(String ldc_OL_NM) {
		this.ldc_OL_NM = ldc_OL_NM;
	}
	public String getLdc_TADDR3() {
		return ldc_TADDR3;
	}
	public void setLdc_TADDR3(String ldc_TADDR3) {
		this.ldc_TADDR3 = ldc_TADDR3;
	}
	public String getLdc_OF_NM() {
		return ldc_OF_NM;
	}
	public void setLdc_OF_NM(String ldc_OF_NM) {
		this.ldc_OF_NM = ldc_OF_NM;
	}
	public String getLdc_BDG_PLC() {
		return ldc_BDG_PLC;
	}
	public void setLdc_BDG_PLC(String ldc_BDG_PLC) {
		this.ldc_BDG_PLC = ldc_BDG_PLC;
	}
	public String getLdc_LIC_OWN() {
		return ldc_LIC_OWN;
	}
	public void setLdc_LIC_OWN(String ldc_LIC_OWN) {
		this.ldc_LIC_OWN = ldc_LIC_OWN;
	}
	public String getLdc_MOV_TO() {
		return ldc_MOV_TO;
	}
	public void setLdc_MOV_TO(String ldc_MOV_TO) {
		this.ldc_MOV_TO = ldc_MOV_TO;
	}
	public String getLdc_OFF_CD() {
		return ldc_OFF_CD;
	}
	public void setLdc_OFF_CD(String ldc_OFF_CD) {
		this.ldc_OFF_CD = ldc_OFF_CD;
	}
	public String getLdc_F_NM() {
		return ldc_F_NM;
	}
	public void setLdc_F_NM(String ldc_F_NM) {
		this.ldc_F_NM = ldc_F_NM;
	}
	public String getLdc_L_NM() {
		return ldc_L_NM;
	}
	public void setLdc_L_NM(String ldc_L_NM) {
		this.ldc_L_NM = ldc_L_NM;
	}
	public String getLdc_HCP_DET() {
		return ldc_HCP_DET;
	}
	public void setLdc_HCP_DET(String ldc_HCP_DET) {
		this.ldc_HCP_DET = ldc_HCP_DET;
	}
	public String getLdc_ID2() {
		return ldc_ID2;
	}
	public void setLdc_ID2(String ldc_ID2) {
		this.ldc_ID2 = ldc_ID2;
	}
	public String getLdc_ID1() {
		return ldc_ID1;
	}
	public void setLdc_ID1(String ldc_ID1) {
		this.ldc_ID1 = ldc_ID1;
	}
	public String getLdc_PG_NM() {
		return ldc_PG_NM;
	}
	public void setLdc_PG_NM(String ldc_PG_NM) {
		this.ldc_PG_NM = ldc_PG_NM;
	}
	public String getLdc_DL_SNO() {
		return ldc_DL_SNO;
	}
	public void setLdc_DL_SNO(String ldc_DL_SNO) {
		this.ldc_DL_SNO = ldc_DL_SNO;
	}
	
	
	
	
}
