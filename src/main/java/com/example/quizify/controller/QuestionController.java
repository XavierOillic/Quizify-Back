package com.example.quizify.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.quizify.repository.CategorieRepository;
import com.example.quizify.repository.QuestionRepository;
import com.example.quizify.service.ServiceCategorie;
import com.example.quizify.service.ServiceQuestion;
import com.example.quizify.service.dto.QuestionDto;

@RequestMapping("/question")
@RestController

public class QuestionController {
	
	@Autowired private QuestionRepository questionRepo;
	@Autowired private CategorieRepository categorieRepo;
	
	@Autowired (required = true)
	private ServiceQuestion serviceQuestion;
	@Autowired private 
	ServiceCategorie serviceCategorie;
	
	//GET ONE
	@GetMapping("/{questionId}")
	public QuestionDto getOne( @PathVariable Integer questionId) {
		QuestionDto result = serviceQuestion.getOneById(questionId);
		if (result == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return result;
	}
	
	//GET ALL.
	@GetMapping
	public List<QuestionDto> getAll(){
		return serviceQuestion.recupererTout();
	}
	
	//ADD
	@PostMapping
	public void addOne(@RequestBody QuestionDto questionAdded) {
		serviceQuestion.ajouterQuestion(questionAdded);
	}
	
	//UpDATE
	@PutMapping("/{questionId}")
	public void updateOne (@RequestBody QuestionDto questionUpdate, @PathVariable Integer questionId){
		if(serviceQuestion.getOneById(questionId) == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
				serviceQuestion.modifierQuestion(questionUpdate, questionId);
	}
	
	//DELETE
	@DeleteMapping("/{questionId}")
	public void deleteOne(@PathVariable Integer questionId) {
		if(serviceQuestion.getOneById(questionId)== null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
				serviceQuestion.supprimerQuestion(questionId);
	}
	
    @GetMapping("/count")
    public int countQuestions() {
        return serviceQuestion.countQuestions();
    }
	
	
}
