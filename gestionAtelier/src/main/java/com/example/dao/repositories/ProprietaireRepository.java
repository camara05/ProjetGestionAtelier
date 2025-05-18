package com.example.dao.repositories;      // <-- même package que l’import dans le service ?
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dao.entities.Proprietaire;

import java.util.List;
@Repository
public interface ProprietaireRepository extends JpaRepository<Proprietaire, Integer> {
	List<Proprietaire> findByNomAndPrenom(String nom, String prenom);
	
}

