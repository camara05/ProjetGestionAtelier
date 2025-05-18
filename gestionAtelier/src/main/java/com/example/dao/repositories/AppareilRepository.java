package com.example.dao.repositories;      // <-- même package que l’import dans le service ?
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dao.entities.Appareil;

@Repository
public interface AppareilRepository extends JpaRepository<Appareil, Integer> {
	List<Appareil> findByMarqueAndModel(String marque, String model);

}
