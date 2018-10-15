package com.echallan.utils;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SmsRepository extends JpaRepository<SmsEntity, Integer>{

	
	SmsEntity  findByContactNoAndOtpNo(long contactNo,int otpNo);


}
