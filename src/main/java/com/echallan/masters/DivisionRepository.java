package com.echallan.masters;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


	@Repository
	public interface DivisionRepository  extends JpaRepository<DivisionEntity_MA, Integer> {

		public List<DivisionEntity_MA> findByUnitCode(int unit_cd);
	
	}
