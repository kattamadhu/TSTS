package com.echallan.reports;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnforcementRepository extends JpaRepository<EnforcementEntity, String>{

}
