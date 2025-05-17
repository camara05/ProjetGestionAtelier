package com.example.dao.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reparation {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrémentation
	private Integer idReparation;

	private float coutTotal; 
	private Date dateDebut; 
	private Date dateFinEstimee; 
	private String statut; 
	private String description; 

	// --- Relations ---

	@OneToOne
	@JoinColumn(name = "appareil_id") 
	private Appareil appareil;

	@OneToMany(mappedBy = "reparation") 
	private List<SousReparation> sousReparations;

	@ManyToOne
	@JoinColumn(name = "reparateur_id")
	private Reparateur reparateur;
}

