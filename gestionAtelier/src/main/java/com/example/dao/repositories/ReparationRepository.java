package com.example.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dao.entities.reparation;

@Repository
public interface ReparationRepository extends JpaRepository<reparation, Integer> {
	
}

