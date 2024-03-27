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

import com.example.quizify.service.ServiceReponse;
import com.example.quizify.service.dto.ReponseDto;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/reponse")
public class ReponseController {
	
	@Autowired
	private ServiceReponse serviceRep;
	
	@GetMapping
	public List<ReponseDto> getAll() {
		return serviceRep.getAll();
	}
	
	@GetMapping("{id}")
	public ReponseDto getById(@PathVariable Integer id) {
		ReponseDto rep = serviceRep.getById(id);
		if (rep == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return rep;
	}
	
	@PostMapping
	public void add(@RequestBody ReponseDto repDTO) {
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
