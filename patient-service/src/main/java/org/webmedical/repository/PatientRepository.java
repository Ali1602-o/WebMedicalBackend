package org.webmedical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.webmedical.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
	
}
