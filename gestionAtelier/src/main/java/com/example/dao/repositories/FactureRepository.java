package com.example.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dao.entities.facture;

@Repository
public interface FactureRepository extends JpaRepository<facture, Integer> {
	
}

