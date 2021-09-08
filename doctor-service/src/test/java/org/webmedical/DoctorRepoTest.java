package org.webmedical;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.webmedical.model.Doctor;
import org.webmedical.repository.DoctorRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class DoctorRepoTest {
	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	DoctorRepository docRepo;
	
	@Test
	public void ajouterDoctor() {
		Doctor doc = new Doctor((long)12,"Saad","jaber","0612325468","addresse 1","ville 1","spec","description 1","1");
		entityManager.persistAndFlush(doc);
		assertThat(doc.getId()).isNotNull();
	}
	
	@Test
	public void getDoctorBySpecialite(){
		entityManager.persistAndFlush(new Doctor((long)12,"Saad","jaber","0612325468","addresse 1","ville 1","spec","description 1","1"));
		entityManager.persistAndFlush(new Doctor((long)13,"ahmed","jaber","0625318498","addresse 2","ville 2","spec2","description12","2"));
		entityManager.persistAndFlush(new Doctor((long)14,"ali","oumlal","0625389521","addresse 3","ville 1","spec2","description 8","1"));
		
		List<Doctor> listDoc = docRepo.findBySpecialite("spec2");
		
		assertThat(listDoc.size()).isEqualTo(2);
		
	}
	
	@Test
	public void getDoctorBySpecialiteAndVille(){
		entityManager.persistAndFlush(new Doctor((long)12,"Saad","jaber","0612325468","addresse 1","ville 1","spec2","description 1","1"));
		entityManager.persistAndFlush(new Doctor((long)13,"ahmed","jaber","0625318498","addresse 2","ville 1","spec1","description12","2"));
		entityManager.persistAndFlush(new Doctor((long)14,"ali","oumlal","0625389521","addresse 3","ville 1","spec2","description 8","1"));
		
		List<Doctor> listDoc = docRepo.findBySpecialiteAndVille("spec2","ville 1");
		
		assertThat(listDoc.size()).isEqualTo(2);
	}
	
	
	@Test
	public void supprimerDoctor() {
		entityManager.persistAndFlush(new Doctor((long)12,"Saad","jaber","0612325468","addresse 1","ville 1","spec","description 1","1"));
		entityManager.persistAndFlush(new Doctor((long)13,"ahmed","jaber","0625318498","addresse 2","ville 2","spec2","description12","2"));
		docRepo.deleteAll();
		assertThat(docRepo.findAll()).isEmpty();
	
	}
}
