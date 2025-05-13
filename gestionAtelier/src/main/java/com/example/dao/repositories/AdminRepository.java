package com.example.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dao.entities.admin;

@Repository
public interface AdminRepository extends JpaRepository<admin, Integer> {
	
}
