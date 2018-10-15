package com.echallan.masters;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


	@Repository
	public interface DetainItemRepository  extends JpaRepository<DetainItemEntity_MA, Integer> {
	
	}
