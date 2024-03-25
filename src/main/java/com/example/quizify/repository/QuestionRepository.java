package com.example.quizify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizify.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
	Question findById(int id);
	Question findByLibelle(String libelle);
}
