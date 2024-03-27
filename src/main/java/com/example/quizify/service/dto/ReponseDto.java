package com.example.quizify.service.dto;

import lombok.Data;

@Data
public class ReponseDto {
	private Integer id;
	
	private String libelle;
	
	private int questionId;
	
	private Boolean isCorrect;
}
