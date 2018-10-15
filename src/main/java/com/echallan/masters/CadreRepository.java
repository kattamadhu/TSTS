package com.echallan.masters;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


	@Repository
	public interface CadreRepository  extends JpaRepository<CadreEntity_MA, Integer> {
	
	}
