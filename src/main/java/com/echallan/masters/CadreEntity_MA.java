package com.echallan.masters;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ma_cadre")
public class CadreEntity_MA {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cadre_cd")
	private int cadre_cd;
	private String Cadre_name;
	private String cadre_sf;
	
	
	public int getCadre_cd() {
		return cadre_cd;
	}
	public void setCadre_cd(int cadre_cd) {
		this.cadre_cd = cadre_cd; 
	}
	public String getCadre_name() {
		return Cadre_name;
	}
	public void setCadre_name(String cadre_name) {
		Cadre_name = cadre_name;
	}
	public String getCadre_sf() {
		return cadre_sf;
	}
	public void setCadre_sf(String cadre_sf) {
		this.cadre_sf = cadre_sf;
	}	
	
	
	}
