package com.example.dao.repositories;      // <-- même package que l’import dans le service ?
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dao.entities.Reparateur;
import java.util.List;
@Repository
public interface ReparateurRepository extends JpaRepository<Reparateur, Integer> {
	

	List<Reparateur> findByNomAndPrenom(String nom, String prenom);

}

