package com.example.quizify.service;

import java.util.List;

import com.example.quizify.model.Question;
import com.example.quizify.service.dto.CategorieDto;
import com.example.quizify.service.dto.QuestionDto;
import com.example.quizify.service.dto.ReponseDto;

public interface ServiceQuestion {
	//tout
	List<QuestionDto> recupererTout();
	//Get One
	QuestionDto getOneById(Integer questionId);
	//par categorie
	List<QuestionDto> getByCategorie(Integer catId);
	//ajouter
	QuestionDto ajouterQuestion (QuestionDto questionDto);
	//modifier
	QuestionDto modifierQuestion (QuestionDto questionDto, Integer questionId);
	//supprimer
	void supprimerQuestion (Integer questionId);
	
	/*//ajouterQuestionReponse
	DtoQuestionReponse ajouterQuestionReponse (DtoQuestionReponse dtoQuestionReponse, QuestionDto quesDto, CategorieDto catDto, ReponseDto repDto);
}*/
	
	int countQuestions();
}
