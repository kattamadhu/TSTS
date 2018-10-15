package com.echallan.masters;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


	@Repository
	public interface WheelerRepository  extends JpaRepository<WheelerEntity_MA, String> {
	}
