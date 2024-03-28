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

import com.example.quizify.service.ServiceCategorie;
import com.example.quizify.service.dto.CategorieDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorie")

public class CategorieController {
	
	@Autowired(required = true)
	private ServiceCategorie serviceCategorie;
	
	//4 verbes HTTP
	@GetMapping
	public List<CategorieDto> getAllByLibelle() { //path variable et trhrows pas nécessaire
		return serviceCategorie.getAll();	
	}
	
	@GetMapping("{id}")
	public CategorieDto getById(@PathVariable Integer id) {
		CategorieDto cat = serviceCategorie.getById(id);
		if (cat == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return cat;
	}
	
	@PostMapping
	public CategorieDto add(@RequestBody @Valid CategorieDto categorieDto) {
		return serviceCategorie.ajouterCategorie(categorieDto);
	}
	
	@PutMapping("{id}")
	public void update(@PathVariable Integer id, @RequestBody @Valid CategorieDto categorieUpdate) {
		serviceCategorie.modifierCategorie(categorieUpdate, id);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id) {
		serviceCategorie.deleteCategorie(id);
	}
	
    @GetMapping("/count")
    public int countCategories() {
        return serviceCategorie.countCategories();
    }
	
}
