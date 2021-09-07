package org.webmedical.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.webmedical.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	
	
	@Query("select d from Doctor d where d.specialite = :specialite")
	List<Doctor> findBySpecialite(@Param("specialite") String specialite);

	@Query("select d from Doctor d where d.specialite = :specialite and d.ville = :ville")
	List<Doctor> findBySpecialiteAndVille(@Param("specialite") String specialite, @Param("ville") String ville);

}
