package com.example.quizify.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quizify.model.Stats;
import com.example.quizify.repository.StatsRepository;
import com.example.quizify.service.ServiceStats;
import com.example.quizify.service.dto.StatsDto;

@Service
public class ServiceStatsImpl implements ServiceStats{
	
	@Autowired
	private StatsRepository statsRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
		

	@Override
	public List<StatsDto> getAllStats() {
List<Stats> stats = statsRepository.findAll();
List<StatsDto> statsDto = stats.stream().map(s -> modelMapper.map(s, StatsDto.class)).collect(Collectors.toList());
return statsDto;
	}
    


    
}
