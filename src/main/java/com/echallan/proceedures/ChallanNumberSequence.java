package com.echallan.proceedures;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name="seq_challan")
@NamedStoredProcedureQueries({
	  @NamedStoredProcedureQuery(
			    name = "findByChallanTypeProcedure", 
			    procedureName = "p_seq_test", 
			    resultClasses = { ChallanNumberSequence.class }, 
			    parameters = { 
			        @StoredProcedureParameter(name = "challan_type",type = Integer.class,mode = ParameterMode.IN)
			    
			    }) 
			})  
public class ChallanNumberSequence {

	@Id
	private Integer challan_type;
	private String challan_sf;
	private Integer seq_no;
	
	public ChallanNumberSequence() {
		
	}
	
	
	public ChallanNumberSequence(Integer challan_type, String challan_sf, Integer seq_no) {
		super();
		this.challan_type = challan_type;
		this.challan_sf = challan_sf;
		this.seq_no = seq_no;
	}


	public Integer getChallan_type() {
		return challan_type;
	}


	public void setChallan_type(Integer challan_type) {
		this.challan_type = challan_type;
	}


	public String getChallan_sf() {
		return challan_sf;
	}


	public void setChallan_sf(String challan_sf) {
		this.challan_sf = challan_sf;
	}


	public Integer getSeq_no() {
		return seq_no;
	}


	public void setSeq_no(Integer seq_no) {
		this.seq_no = seq_no;
	}


}
