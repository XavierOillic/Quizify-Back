package com.example.quizify.service.dto;

import com.example.quizify.model.Categorie;

import lombok.Data;

@Data
public class QuestionDto {
	private Integer id;
	private String libelle;
	private Categorie categorie;
}
