package com.example.quizify.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quizify.model.Categorie;
import com.example.quizify.model.Question;
import com.example.quizify.model.Reponse;
import com.example.quizify.repository.CategorieRepository;
import com.example.quizify.repository.QuestionRepository;
import com.example.quizify.repository.ReponseRepository;
import com.example.quizify.service.ServiceQuestion;
import com.example.quizify.service.dto.CategorieDto;
import com.example.quizify.service.dto.QuestionDto;
import com.example.quizify.service.dto.ReponseDto;

import jakarta.transaction.Transactional;

@Service
public class ServiceQuestionImpl implements ServiceQuestion {
	
	@Autowired QuestionRepository questionRepo;
	@Autowired CategorieRepository categorieRepo;
	@Autowired ReponseRepository reponseRepo;
	@Autowired ModelMapper modelMapper;

	@Override
	public List<QuestionDto> recupererTout() {
		List<Question>question = questionRepo.findAll();
		List<QuestionDto>allQuestion = question.stream().map(q -> modelMapper.map(q, QuestionDto.class)).collect(Collectors.toList());
		return allQuestion;
	}
	//impl 4 methodes
	
	@Override
	public QuestionDto getOneById(Integer questionId) {

		// get question by id 
		Question questionUpdated = questionRepo.findById(questionId).orElseThrow();
		// get reponses by question id 
		List<Reponse> repUpdated = reponseRepo.findByQuestion(questionRepo.findById(questionId).orElseThrow());// recup 4 rep associée à cette q°
		// on rassemble les objets 
		QuestionDto questionDto = modelMapper.map(questionUpdated, QuestionDto.class);
		
		questionDto.setReponses(repUpdated);
		
		return questionDto;		
		/*
		 * return modelMapper.map(questionRepo.findById(questionId), QuestionDto.class);
		 */
		/*
		 * return modelMapper.map(questionRepo.findById(questionId), QuestionDto.class);
		 */
	}
	
	@Override
	public List<QuestionDto> getByCategorie(Integer catId) {
		List<Question> listQuestion = questionRepo.findByCategorie(categorieRepo.findById(catId).orElseThrow());
		List<QuestionDto>allQuestion = listQuestion.stream().map(q -> modelMapper.map(q, QuestionDto.class)).collect(Collectors.toList());
		return allQuestion;
	}

	@Override
	@Transactional
	public QuestionDto ajouterQuestion(QuestionDto questionDto) {
		Categorie category = categorieRepo.findByLibelle(questionDto.getCategorieLibelle());
		//Je récupère la categorie via le Repo et son libelle présent dans le DTOPLANTE en String "categorieLibelle"
		Question questionAdded = modelMapper.map(questionDto, Question.class);
		//Je mappe la plante normale sur la dto
		questionAdded.setCategorie(category);
		List<Reponse> reponseAdded = questionAdded.getReponses();
		Question questSave = questionRepo.save(questionAdded);			
		
		 for (Reponse reponse : reponseAdded) { 
			 Reponse modelReponse = modelMapper.map(reponse, Reponse.class);
			 modelReponse.setQuestion(questSave);
			 reponseRepo.save(modelReponse);
			 }	  
		
		return modelMapper.map(questionRepo.findById(questSave.getId()), QuestionDto.class);
		
	}

	@Override
	public QuestionDto modifierQuestion(QuestionDto questionDto, Integer questionId) {
		Categorie category = categorieRepo.findByLibelle(questionDto.getCategorieLibelle()); // Je récupère la categorie (CATEGORY) via son Repo 
		Question questionUpdated = questionRepo.findById(questionId).orElseThrow();
		
		questionUpdated = modelMapper.map(questionDto, Question.class);
		questionUpdated.setCategorie(category);
		
		return modelMapper.map(questionRepo.save(questionUpdated), QuestionDto.class);
	}

	@Override
	public void supprimerQuestion(Integer questionId) {
		List<Reponse> listReponses = reponseRepo.findByQuestion(questionRepo.findById(questionId).orElseThrow());
		for (Reponse rep : listReponses) {
			reponseRepo.deleteById(rep.getId());
		}
		questionRepo.deleteById(questionId);
	}
	

	/*
	 * @Override public DtoQuestionReponse ajouterQuestionReponse(DtoQuestionReponse
	 * dtoQuestionReponse) { Categorie cat =
	 * categorieRepo.findByLibelle(c.getCategorieLibelle()); Question questionAdd =
	 * modelMapper.map(dtoQuestionReponse, Question.class); List<Reponse> repAdd =
	 * modelMapper.map(dtoQuestionReponse, Reponse.class);
	 * 
	 * questionAdd.setCategorie(cat); questionAdd.setReponse(repAdd);
	 * 
	 * return modelMapper.map(questionRepo.save(questionAdd),
	 * DtoQuestionReponse.class); }
	 * 
	 * @Override public DtoQuestionReponse ajouterQuestionReponse(DtoQuestionReponse
	 * dtoQuestionReponse, QuestionDto quesDto, CategorieDto catDto, ReponseDto
	 * repDto) { // TODO Auto-generated method stub return null; }
	 */
    @Override
    public int countQuestions() {
        return (int) questionRepo.count();
    }
}
