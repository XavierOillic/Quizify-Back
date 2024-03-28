package com.example.quizify.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)//proteger constructeur mais accessible jp
@RequiredArgsConstructor
public class Reponse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
	
	@NonNull
		private String libelle;
	
	@NonNull
		private Boolean isCorrect;
	
	@NonNull
	@ManyToOne
		private Question question;
}
