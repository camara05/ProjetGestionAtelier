package com.example.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dao.entities.appareil;

@Repository
public interface AppareilRepository extends JpaRepository<appareil, Integer> {}
