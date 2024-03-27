package com.example.quizify.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quizify.model.Categorie;
import com.example.quizify.repository.CategorieRepository;
import com.example.quizify.service.ServiceCategorie;
import com.example.quizify.service.dto.CategorieDto;

@Service
public class ServiceCategorieImpl implements ServiceCategorie{
	
	@Autowired
	private CategorieRepository categorieRepository;
	
	@Autowired
	private ModelMapper modelMapper;	
	
	@Override
	public List<CategorieDto> getAll() {
		List<Categorie> categoriz = categorieRepository.findAll();
		List<CategorieDto> listeCategoriz = categoriz.stream().map(c -> modelMapper.map(c, CategorieDto.class)).collect(Collectors.toList());		
;		return listeCategoriz;
	}
	
	@Override
	public CategorieDto getById(Integer id) {
		return modelMapper.map(categorieRepository.findById(id), CategorieDto.class);
	}

	@Override
	public CategorieDto ajouterCategorie(CategorieDto categorieDto) {
		Categorie categorieModel = modelMapper.map(categorieDto, Categorie.class);
		return modelMapper.map(categorieRepository.save(categorieModel), CategorieDto.class);
	}

	@Override
	public CategorieDto modifierCategorie(CategorieDto categorieUpdate, Integer categorieId) {
		Categorie categorieModel = modelMapper.map(categorieUpdate, Categorie.class);
		categorieModel.setId(categorieId);
		return modelMapper.map(categorieRepository.save(categorieModel), CategorieDto.class);
	}

	@Override
	public void deleteCategorie(Integer categorieId) {
		categorieRepository.deleteById(categorieId);		
	}
	
}
