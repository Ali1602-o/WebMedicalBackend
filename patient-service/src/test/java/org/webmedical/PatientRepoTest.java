package org.webmedical;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.webmedical.model.Patient;
import org.webmedical.repository.PatientRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PatientRepoTest {
	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	PatientRepository patientRepo;
	
	@Test
	public void ajouterPatient() {
		Patient patient = new Patient((long)12,"Saad","jaber",Date.valueOf("1999-05-12"),"0612325468");
		entityManager.persistAndFlush(patient);
		assertThat(patient.getId()).isNotNull();
	}
	
	@Test
	public void supprimerPatient() {
		entityManager.persistAndFlush(new Patient((long)12,"Saad","jaber",Date.valueOf("1999-05-12"),"0612325468"));
		entityManager.persistAndFlush(new Patient((long)13,"ahmed","jaber",Date.valueOf("1997-03-23"),"0625318498"));
		patientRepo.deleteAll();
		assertThat(patientRepo.findAll()).isEmpty();
	
	}

}
