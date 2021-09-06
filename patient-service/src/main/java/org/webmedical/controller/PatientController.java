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
import org.webmedical.model.Patient;
import org.webmedical.repository.PatientRepository;


@RestController
@CrossOrigin(origins ="http://localhost:3000", maxAge = 3600)
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	PatientRepository patientRepo;
	
	
	@PostMapping("/add")
	public ResponseEntity<?> addPatient(@RequestBody Patient p) {
		patientRepo.save(p);
		return ResponseEntity.ok("Votre Profil a mis à jour !");
	}
	
	@GetMapping("/all")
	public List<Patient> getAllPatients(){
		return patientRepo.findAll();
	}
	
	
	@GetMapping("/{id}")
	public Optional<Patient> getAllPatients(@PathVariable Long id){
		return patientRepo.findById(id);
	}
	
}
