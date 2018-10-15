package com.echallan.officerRegistration;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MALoginIDRepository extends JpaRepository <MALoginIDEntity, Integer>{

	MALoginIDEntity findByempIDAndPwd(String empID, String Pwd);

	Optional<MALoginIDEntity> findByPwd(String Pwd);

	Optional<MALoginIDEntity> findByempID(String empID);

}
