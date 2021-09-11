package org.webmedical;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.webmedical.model.Book;
import org.webmedical.repository.BookRepository;

@RunWith(SpringRunner.class)
@DataJpaTest

public class BookRepoTest {
	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	BookRepository BookRepo;
	
	@Test
	public void ajouterReservation() {
		Book book = new Book("Saad","jaber","0612325468","20/08/2021","09:00 AM",(long)12,(long)5);
		entityManager.persistAndFlush(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void supprimerReservation() {
		entityManager.persistAndFlush(new Book("Saad","jaber","0612325468","20/08/2021","09:00 AM",(long)12,(long)5));
		entityManager.persistAndFlush(new Book("Ahmed","berrada","0612325338","22/08/2021","10:00 AM",(long)13,(long)2));
		BookRepo.deleteAll();
		assertThat(BookRepo.findAll()).isEmpty();
	}
}
