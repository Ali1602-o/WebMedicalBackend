package org.webmedical.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webmedical.model.Book;
import org.webmedical.repository.BookRepository;


@RestController
@CrossOrigin(origins ="http://localhost:3000", maxAge = 3600)
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookRepository bookRepo;
	
	
	@PostMapping("/add")
	public ResponseEntity<?> addBook(@RequestBody Book b) {
		bookRepo.save(b);
		return ResponseEntity.ok("Reservation est confirmé !");
	}
	
	@GetMapping("/all")
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	
	
	@GetMapping("/{id}")
	public Optional<Book> getBookById(@PathVariable Long id){
		return bookRepo.findById(id);
	}
	
}
