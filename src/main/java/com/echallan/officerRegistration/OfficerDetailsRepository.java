package com.echallan.officerRegistration;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


	@Repository
	public interface OfficerDetailsRepository  extends JpaRepository<Officer_v, String> {
		
		
		public Officer_v findByEmpId(String empId);
		
		public Officer_v findByUserID(String userID);
		
		public  List<Officer_v> findByUnitcd(int Unitcd);
		
		public Officer_v findByUserIDAndPwd(String userID,String pwd);
		
		
		
	}
