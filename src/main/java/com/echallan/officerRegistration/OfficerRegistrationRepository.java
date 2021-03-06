package com.echallan.officerRegistration;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficerRegistrationRepository extends JpaRepository <OfficerRegistrationEntity, String> {

	Optional<OfficerRegistrationEntity> findByLoginId(String loginId);

}
