package com.echallan.masters;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


	@Repository
	public interface ZoneRepository  extends JpaRepository<ZoneEntity_MA, Integer> {
		public List<ZoneEntity_MA> findByDivisionCode(int divisionCode);
	}
