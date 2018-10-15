package com.echallan.rta;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DLRepository extends JpaRepository<DLEntity,String> {

	public DLEntity findByLdcDlNOAndLdcDob(String ldcDlNO,Date ldcDob);
}
