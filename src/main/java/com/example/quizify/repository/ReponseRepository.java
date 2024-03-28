package com.example.quizify.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizify.model.Question;
import com.example.quizify.model.Reponse;

public interface ReponseRepository extends JpaRepository<Reponse, Integer> {
	Reponse findById(int id);
	Reponse findByLibelle(String libelle);
	List<Reponse> findByQuestion(Question question);
}
