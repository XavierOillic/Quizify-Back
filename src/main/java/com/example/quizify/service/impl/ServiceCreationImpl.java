package com.example.quizify.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quizify.model.Creation;
import com.example.quizify.repository.CreationRepository;
import com.example.quizify.service.ServiceCreation;
import com.example.quizify.service.dto.CreationDto;

@Service
public class ServiceCreationImpl implements ServiceCreation {
	
	@Autowired
	private CreationRepository creationRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<CreationDto> getAllCreation(){
		List<Creation> creation = creationRepository.findAll();
		List<CreationDto> creationDto = creation.stream().map(c -> modelMapper.map(c, CreationDto.class)).collect(Collectors.toList());	
return creationDto;
}

}
