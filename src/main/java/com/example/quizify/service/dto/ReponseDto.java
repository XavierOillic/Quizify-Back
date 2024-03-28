package com.example.quizify.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ReponseDto {
	private Integer id;
	
	@JsonProperty("libelleReponse")
	private String libelle;
	
	private int questionId;
	
	private Boolean isCorrect;
}
