package com.echallan.masters;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


	@Repository
	public interface PointsRepository  extends JpaRepository<PointsEntity_MA, Integer> {
		public List<PointsEntity_MA> findByPsCode(int psCode);
	
	}
