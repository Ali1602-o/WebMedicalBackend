package org.webmedical.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor

@Table(	name = "Books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	private String prenom;
	
	@NonNull
	private String nom;
	
	@NonNull
	private String telephone;
	
	@NonNull
	private String date;
	
	@NonNull
	private String heure;
	
	@NonNull
	private Long userId;
	
	@NonNull
	private Long doctorId;
	
	
}
