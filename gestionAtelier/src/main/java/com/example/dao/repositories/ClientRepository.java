package com.example.dao.repositories;      // <-- même package que l’import dans le service ?
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dao.entities.Client;

import java.util.List;
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    List<Client> findByNomAndPrenom(String nom, String prenom);   // <-- exactement ceci
}

