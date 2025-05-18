package com.example.gestionatelier.metier;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.dao.entities.Proprietaire;
import com.example.dao.entities.Reparateur;
import com.example.dao.entities.Reparation;
import com.example.dao.repositories.AppareilRepository;
import com.example.dao.repositories.ReparateurRepository;
import com.example.dao.repositories.ReparationRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class GestionReparateur implements IGestionReparateur{
	
	private ReparateurRepository reparateurRepo;
	private final ReparationRepository reparationRepo;

	@Override
	@Transactional
	public Reparateur ajouterReparateur(Reparateur r) {
		return reparateurRepo.save(r);
	}

	@Override
	@Transactional
	public Reparateur modifierReparateur(Reparateur r) {
		return reparateurRepo.save(r);
	}

	@Override
	@Transactional
	public void supprimerReparateur(Reparateur r) {
		 reparateurRepo.delete(r);
		
	}

	@Override
	@Transactional
	public void supprimerReparateur(Integer idReparateur) {
		reparateurRepo.deleteById(idReparateur);
	}

	@Override
	@Transactional
	public Reparateur rechercherReparateur(Integer idReparateur) {
		 Optional<Reparateur> or = reparateurRepo.findById(idReparateur);
		 if(or.isPresent())
			 return or.get();
		 else {
			throw new RuntimeException("Reparateur non trouver");
		}
	}

	@Override
	@Transactional
	public Page<Reparateur> listerReparateurs(int numPage) {
			PageRequest pageable = PageRequest.of(numPage, 10);
			return reparateurRepo.findAll(pageable);
	}

	@Override
	@Transactional
	public List<Reparation> listerReparations() {
		return reparationRepo.findAll();
	}
	@Override
	@Transactional
	public List<Reparateur> rechercherReparateurs(String nom, String prenom) {

		List<Reparateur> liste = reparateurRepo.findByNomAndPrenom(nom, prenom);

		if (liste.isEmpty()) {
			throw new RuntimeException("Aucun réparateur trouvé pour ce nom/prénom.");
		}
		return liste;
	}


}
