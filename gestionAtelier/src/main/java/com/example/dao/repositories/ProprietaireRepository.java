package com.example.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dao.entities.Proprietaire;

@Repository
public interface ProprietaireRepository extends JpaRepository<Proprietaire, Integer> {
	
}

