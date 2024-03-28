package com.example.quizify.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizify.model.Question;
import com.example.quizify.model.Reponse;

public interface ReponseRepository extends JpaRepository<Reponse, Integer> {
	Reponse findById(int id);
	Reponse findByLibelle(String libelle);
	List<Reponse> findByQuestionId(Integer questionId);
}
