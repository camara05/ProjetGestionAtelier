package com.example.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dao.entities.SousReparation;

@Repository
public interface SousReparationRepository extends JpaRepository<SousReparation, Integer> {}
