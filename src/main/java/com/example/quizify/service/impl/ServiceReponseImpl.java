package com.example.quizify.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quizify.model.Question;
import com.example.quizify.model.Reponse;
import com.example.quizify.repository.QuestionRepository;
import com.example.quizify.repository.ReponseRepository;
import com.example.quizify.service.ServiceReponse;
import com.example.quizify.service.dto.ReponseDto;

@Service
public class ServiceReponseImpl implements ServiceReponse {

	@Autowired
	private ReponseRepository repRepo;
	
	@Autowired
	private QuestionRepository questionRepo;
	
	@Autowired
	private ModelMapper modelMap;
	
	@Override
	public List<ReponseDto> getAll() {
		List<Reponse> rep = repRepo.findAll();
		List<ReponseDto> listRep = rep.stream().map(r -> modelMap.map(r, ReponseDto.class))
				.collect(Collectors.toList());
		return listRep;
	}
	
	@Override
	public ReponseDto getById(Integer repId) {
		return modelMap.map(repRepo.findById(repId), ReponseDto.class);
	}
	
	@Override
	public List<ReponseDto> getByQuestion(Integer questionId) {
		List<Reponse> listReponse = repRepo.findByQuestion(questionRepo.findById(questionId).orElseThrow());
		List<ReponseDto> allRep = listReponse.stream().map(r -> modelMap.map(r, ReponseDto.class)).collect(Collectors.toList());
		return allRep;
	}

	@Override
	public ReponseDto ajouterReponse(ReponseDto repDTO) {
		Question question = questionRepo.findById(repDTO.getQuestionId());
		Reponse rep = modelMap.map(repDTO, Reponse.class);
		rep.setQuestion(question);
		return modelMap.map(repRepo.save(rep), ReponseDto.class);
	}

	@Override
	public ReponseDto modifierReponse(ReponseDto repDTO, Integer repId) {
		Question q = questionRepo.findById(repDTO.getQuestionId());
		Reponse rep = repRepo.findById(repId).orElseThrow();
		
		rep = modelMap.map(repDTO, Reponse.class);
		rep.setQuestion(q);
		
		return modelMap.map(repRepo.save(rep), ReponseDto.class);
	}

	@Override
	public void supprimerReponse(Integer repId) {
		repRepo.deleteById(repId);
	}
}
