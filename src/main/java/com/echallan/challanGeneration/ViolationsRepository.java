package com.echallan.challanGeneration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViolationsRepository  extends JpaRepository<ViolationsEntity, Integer> {

}
