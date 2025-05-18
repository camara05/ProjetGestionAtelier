package com.example.gestionatelier.metier;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.dao.entities.Facture;
import com.example.dao.entities.PretEmprunt;
import com.example.dao.entities.Proprietaire;
import com.example.dao.entities.Reparateur;
import com.example.dao.repositories.AppareilRepository;
import com.example.dao.repositories.FactureRepository;
import com.example.dao.repositories.ProprietaireRepository;
import com.example.dao.repositories.ReparateurRepository;
import com.example.dao.repositories.ReparationRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class GestionProprietaire implements IGestionProprietaire {
	
	private ProprietaireRepository proprietaireRepo;
	private final FactureRepository factureRepo;

	@Override
	@Transactional
	public Proprietaire ajouterProprietaire(Proprietaire p) {
		return proprietaireRepo.save(p);
	}

	@Override
	@Transactional
	public Proprietaire modifierProprietaire(Proprietaire p) {
		return proprietaireRepo.save(p);
	}

	@Override
	@Transactional
	public void supprimerProprietaire(Proprietaire p) {
		proprietaireRepo.delete(p);
		
	}

	@Override
	@Transactional
	public void supprimerProprietaire(Integer idProprietaire) {
		proprietaireRepo.deleteById(idProprietaire);
	}

	@Override
	@Transactional
	public Proprietaire rechercherProprietaire(Integer idProprietaire) {
		 Optional<Proprietaire> or = proprietaireRepo.findById(idProprietaire);
		 if(or.isPresent())
			 return or.get();
		 else {
			throw new RuntimeException("Reparateur non trouver");
		 }
	}

	@Override
	@Transactional
	public Page<Proprietaire> listerProprietaires(int numPage) {
			PageRequest pageable = PageRequest.of(numPage, 10);
			return proprietaireRepo.findAll(pageable);
	}

	@Override
	@Transactional
	public List<Facture> ListerFactures() {
		return factureRepo.findAll();
	}
	@Override
	@Transactional
	public List<Proprietaire> rechercherProprietaires(String nom, String prenom) {
		List<Proprietaire> liste = proprietaireRepo.findByNomAndPrenom(nom, prenom);
		if (liste.isEmpty()) {
			throw new RuntimeException("Aucun propriétaire trouvé pour ce nom/prénom.");
		}
		return liste;
	}

}
