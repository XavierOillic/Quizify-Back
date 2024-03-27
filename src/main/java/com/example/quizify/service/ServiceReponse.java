package com.example.quizify.service;

import java.util.List;

import com.example.quizify.service.dto.ReponseDto;

public interface ServiceReponse {
	//tout
	List<ReponseDto> getAll();
	//une seule
	ReponseDto getById(Integer repId);
	//ajouter
	ReponseDto ajouterReponse(ReponseDto repDTO);
	//modifier
	ReponseDto modifierReponse(ReponseDto repDTO, Integer repId);
	//supprimer
	void supprimerReponse(Integer repId);
}
