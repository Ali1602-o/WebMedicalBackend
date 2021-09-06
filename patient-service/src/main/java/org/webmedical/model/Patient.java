package org.webmedical.model;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor

@Table(	name = "patients", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "telephone") 
		})
public class Patient {
	
	@Id
	@NonNull
	private Long id;
	
	@NonNull
	private String prenom;
	
	@NonNull
	private String nom;
	
	@NonNull
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date dtNaissance;
	
	@NonNull
	private String telephone;

}
