package com.echallan.masters;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


	@Repository
	public interface ComplaintsRepository  extends JpaRepository<ComplaintsEntity_MA, Integer> {
	
	}
