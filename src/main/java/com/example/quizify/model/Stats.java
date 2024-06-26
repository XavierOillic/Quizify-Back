package com.example.quizify.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)//proteger constructeur mais accessible jp
@RequiredArgsConstructor
public class Stats {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
	
	@NonNull
		private String libelle;
	
	@NonNull
		private float score;
	
}
