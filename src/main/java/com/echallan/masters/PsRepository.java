package com.echallan.masters;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


	@Repository
	public interface PsRepository  extends JpaRepository<PsEntity_MA, Integer> {
		public List<PsEntity_MA> findByZoneCode(int zoneCode);
	
	}
