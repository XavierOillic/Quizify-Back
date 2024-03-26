package com.example.quizify.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizify.service.ServiceReponse;
import com.example.quizify.service.dto.ReponseDto;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/reponses")
public class ReponseController {
	
	@Autowired
	private ServiceReponse serviceRep;
	
	//4 verbes HTTP
	@GetMapping
	public List<ReponseDto> getAll() {
		return serviceRep.getAll();
	}
	
	@PostMapping
	public void add(@RequestBody @Valid ReponseDto repDTO) {
		serviceRep.ajouterReponse(repDTO);
	}
	
	@PutMapping("{id}")
	public void update(@PathVariable Integer id, @RequestBody @Valid ReponseDto rep) {
		serviceRep.modifierReponse(rep, id);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id) {
		serviceRep.supprimerReponse(id);
	}
}
