package com.example.quizify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizify.model.Stats;

public interface StatsRepository extends JpaRepository<Stats, Integer> {
	<Stats> void findById(Integer id);
	Stats findByLibelle(String libelle);
}
