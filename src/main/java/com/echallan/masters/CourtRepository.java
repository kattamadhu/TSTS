package com.echallan.masters;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


	@Repository
	public interface CourtRepository  extends JpaRepository<CourtEntity_MA, Integer> {
		
		public List<CourtEntity_MA> findByUnitCode(int unitCode);
	
	}
