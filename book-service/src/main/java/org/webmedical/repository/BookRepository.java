package org.webmedical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.webmedical.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
