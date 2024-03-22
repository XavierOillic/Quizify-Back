package com.example.quizify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizify.model.Stats;

public interface StatsRepository extends JpaRepository<Stats, Integer> {
	Stats findByEquals(Integer Id);
	Stats findByLibelle(String Libelle);
}
