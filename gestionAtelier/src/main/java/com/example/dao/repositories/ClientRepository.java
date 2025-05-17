package com.example.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dao.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
	
}

