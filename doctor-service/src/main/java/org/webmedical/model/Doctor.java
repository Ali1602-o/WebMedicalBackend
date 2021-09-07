package org.webmedical.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor

@Table(	name = "doctors", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "telephone") 
		})
public class Doctor {
	
	@Id
	@NonNull
	private Long id;
	
	@NonNull
	private String prenom;
	
	@NonNull
	private String nom;
	
	@NonNull
	private String telephone;
	
	@NonNull
	private String adresse;
	
	@NonNull
	private String ville;
	@NonNull
	private String specialite;
	@NonNull
	private String description;
	
	@NonNull
	private String status;
}
