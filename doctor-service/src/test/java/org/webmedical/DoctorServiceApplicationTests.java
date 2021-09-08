package org.webmedical;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.webmedical.controller.DoctorController;

@SpringBootTest
class DoctorServiceApplicationTests {

	
	@Autowired
	DoctorController doctorController;
	
	@Test
	void contextLoads() {
		assertThat(doctorController).isNotNull();
		
	}

}
