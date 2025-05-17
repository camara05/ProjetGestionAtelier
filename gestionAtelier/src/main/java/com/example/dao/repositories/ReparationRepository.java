package com.example.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dao.entities.Reparation;

@Repository
public interface ReparationRepository extends JpaRepository<Reparation, Integer> {
	
}

