package com.example.quizify.service;

import java.util.List;

import com.example.quizify.model.Question;
import com.example.quizify.service.dto.QuestionDto;

public interface ServiceQuestion {
	//tout
	List<QuestionDto> recupererTout();
	//Get One
	QuestionDto getOneById(Integer questionId);
	//ajouter
	QuestionDto ajouterQuestion (QuestionDto questionDto);
	//modifier
	QuestionDto modifierQuestion (QuestionDto questionDto, Integer questionId);
	//supprimer
	void supprimerQuestion (Integer questionId);
}
