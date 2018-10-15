package com.echallan.masters;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


	@Repository
	public interface DutiesRepository  extends JpaRepository<DutiesEntity_MA, Integer> {
	
	}
