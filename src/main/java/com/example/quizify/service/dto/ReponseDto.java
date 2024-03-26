package com.example.quizify.service.dto;

import com.example.quizify.model.Question;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ReponseDto {
	private Integer id;
	private String libelle;
	private Question question;
	private Boolean isCorrect;
}

