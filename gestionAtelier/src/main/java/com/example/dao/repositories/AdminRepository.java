package com.example.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dao.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
}
