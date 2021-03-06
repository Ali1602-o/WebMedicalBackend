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
import org.webmedical.model.Doctor;
import org.webmedical.repository.DoctorRepository;

@RestController
@CrossOrigin(origins ="http://localhost:3000")
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	DoctorRepository docRepo;
	
	
	@PostMapping("/add")
	public void addDoctor(@RequestBody Doctor d) {
		docRepo.save(d);
	}
	
	@GetMapping("/all")
	public List<Doctor> getAllDoctors(){
		return docRepo.findAll();
	}
	
	
	@GetMapping("/{id}")
	public Optional<Doctor> getDoctorById(@PathVariable Long id){
		return docRepo.findById(id);
	}

	
	@GetMapping("Specialite/{specialite}")
	public List<Doctor> getDoctorsBySpecialite(@PathVariable String specialite){
		return docRepo.findBySpecialite(specialite);
	}
	
	
	@GetMapping("Specialite&Ville/{specialite}/{ville}")
	public List<Doctor> getDoctorsBySpecialiteAndVille(@PathVariable String specialite,@PathVariable String ville){
		return docRepo.findBySpecialiteAndVille(specialite,ville);
	}
	
}
