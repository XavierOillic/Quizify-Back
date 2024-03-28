package com.example.quizify.service;

import java.util.List;

import com.example.quizify.service.dto.CategorieDto;

public interface ServiceCategorie {
	//tout
	List<CategorieDto> getAll();
	//ajouter
	CategorieDto ajouterCategorie(CategorieDto categorieDto);
	//modifier
	CategorieDto modifierCategorie(CategorieDto categorieUpdate, Integer categorieId);
	//supprimer
	void deleteCategorie(Integer categorieId);
	
	int countCategories();
	
}
