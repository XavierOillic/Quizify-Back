package com.example.quizify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizify.model.Creation;
import com.example.quizify.model.Stats;

public interface CreationRepository extends JpaRepository<Creation, Integer>{
	Stats findById(int id);
	Stats findByNbCategorie(int nbCategorie);
	Stats findByNbQuestion(int nbQuestion);
}
