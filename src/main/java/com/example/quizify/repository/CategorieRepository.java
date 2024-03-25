package com.example.quizify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizify.model.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
	Categorie findByIdEquals(Integer id);
	Categorie findByLibelle(String categorieLibelle);
}
