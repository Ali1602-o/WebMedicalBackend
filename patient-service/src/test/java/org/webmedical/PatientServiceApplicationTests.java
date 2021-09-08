package org.webmedical;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.webmedical.controller.PatientController;

@SpringBootTest
class PatientServiceApplicationTests {

	@Autowired
	PatientController patientController;
	
	@Test
	void contextLoads() {
		assertThat(patientController).isNotNull();
	}

}
