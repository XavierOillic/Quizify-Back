package com.example.quizify.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class QuestionDto {
	private Integer id;
	@JsonProperty("libelleQuestion")
	private String libelle;
	
	//Traduction de ce que j'ai ici en BACK en celui que j'ai dans le FRONT.
	@JsonProperty("categorie")
	private String categorieLibelle; //Parce que la question contient une categorie
	
}
