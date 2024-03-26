package com.example.quizify.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizify.service.ServiceCreation;
import com.example.quizify.service.dto.CreationDto;

@RestController
@RequestMapping("/api/creation")
public class CreationController {
	
@Autowired
private ServiceCreation serviceCreation;

@GetMapping
public List<CreationDto> getStats(){
	return serviceCreation.getAllCreation();
}

}


