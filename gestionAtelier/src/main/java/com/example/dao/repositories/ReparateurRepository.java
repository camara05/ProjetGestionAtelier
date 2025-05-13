package com.example.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dao.entities.reparateur;

@Repository
public interface ReparateurRepository extends JpaRepository<reparateur, Integer> {
	
}

