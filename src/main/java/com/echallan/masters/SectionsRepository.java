package com.echallan.masters;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


	@Repository
	public interface SectionsRepository  extends JpaRepository<SectionsEntity_MA, Integer> {
		
	}
