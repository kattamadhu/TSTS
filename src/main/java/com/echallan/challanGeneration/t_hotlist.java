package com.echallan.challanGeneration;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.PrePersist;

@Entity
public class t_hotlist {
		
	@EmbeddedId
	private t_hotlistId id;
	
	    private String login_id;
	    private String fir_no;//FIR_NO;
		private Date fir_booked_dt;//FIR_BOOKED_DT;
		private String event_city;//EVENT_CITY;
		private String complinant_name;//COMPLINANT_NAME;
		private String comp_address;//COMP_ADDRESS;
		private String comp_contact_no;//;COMP_contact_NO;
		private String lo_ps_cd;////LO_PS_CD;
		private int lo_sho_contact_no;//LO_SHO_CONTACT_NO;
		private Date created_dt;//CREATED_DT;
		
		
		@PrePersist
		protected void onCreate() {
			created_dt = new Date();
		}
		public t_hotlistId getId() {
			return id;
		}
		public void setId(t_hotlistId id) {
			this.id = id;
		}
		public String getLogin_id() {
			return login_id;
		}
		public void setLogin_id(String login_id) {
			this.login_id = login_id;
		}
		public String getFir_no() {
			return fir_no;
		}
		public void setFir_no(String fir_no) {
			this.fir_no = fir_no;
		}
		public Date getFir_booked_dt() {
			return fir_booked_dt;
		}
		public void setFir_booked_dt(Date fir_booked_dt) {
			this.fir_booked_dt = fir_booked_dt;
		}
		public String getEvent_city() {
			return event_city;
		}
		public void setEvent_city(String event_city) {
			this.event_city = event_city;
		}
		public String getComplinant_name() {
			return complinant_name;
		}
		public void setComplinant_name(String complinant_name) {
			this.complinant_name = complinant_name;
		}
		public String getComp_address() {
			return comp_address;
		}
		public void setComp_address(String comp_address) {
			this.comp_address = comp_address;
		}
		public String getComp_contact_no() {
			return comp_contact_no;
		}
		public void setComp_contact_no(String comp_contact_no) {
			this.comp_contact_no = comp_contact_no;
		}
		public String getLo_ps_cd() {
			return lo_ps_cd;
		}
		public void setLo_ps_cd(String lo_ps_cd) {
			this.lo_ps_cd = lo_ps_cd;
		}
		public int getLo_sho_contact_no() {
			return lo_sho_contact_no;
		}
		public void setLo_sho_contact_no(int lo_sho_contact_no) {
			this.lo_sho_contact_no = lo_sho_contact_no;
		}
		public Date getCreated_dt() {
			return created_dt;
		}
		public void setCreated_dt(Date created_dt) {
			this.created_dt = created_dt;
		}
		
		
	
	
}
