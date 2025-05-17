package com.example.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dao.entities.PretEmprunt;

@Repository
public interface PretEmpruntRepository extends JpaRepository<PretEmprunt, Integer> {
	
}
