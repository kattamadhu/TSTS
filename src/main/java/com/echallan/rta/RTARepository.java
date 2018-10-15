package com.echallan.rta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


	@Repository
	public interface RTARepository  extends JpaRepository<RCEntity, String> {
	
}
