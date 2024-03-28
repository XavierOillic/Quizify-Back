package com.example.quizify.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)//proteger constructeur mais accessible jp
@RequiredArgsConstructor
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
	
	@NonNull
		private String libelle;
	
	@NonNull
	@ManyToOne
		private Categorie categorie;	
		
	@OneToMany
		private List<Reponse> reponses;//le tableau qui s'ajoute en plus dans mon get par id de question	 
		
}
	