package com.echallan.masters;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


	@Repository
	public interface UnitRepository  extends JpaRepository<UnitEntity_MA, Integer> {
		public List<UnitEntity_MA> findByStateCode(int stateCode);
	}
