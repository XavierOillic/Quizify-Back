package com.example.quizify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizify.model.Reponse;

public interface ReponseRepository extends JpaRepository<Reponse, Integer> {
	Reponse findByEquals(Integer Id);
	Reponse findByLibelle(String Libelle);
}
