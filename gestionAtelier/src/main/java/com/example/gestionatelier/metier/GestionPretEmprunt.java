package com.example.gestionatelier.metier;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.dao.entities.Appareil;
import com.example.dao.entities.Facture;
import com.example.dao.entities.PretEmprunt;
import com.example.dao.repositories.AppareilRepository;
import com.example.dao.repositories.PretEmpruntRepository;
import com.example.dao.repositories.ReparateurRepository;
import com.example.dao.repositories.ReparationRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class GestionPretEmprunt implements IGestionPretEmprunt {
	
	private PretEmpruntRepository pretEmpruntRepo;

	@Override
	@Transactional
	public PretEmprunt ajouterPretEmprunt(PretEmprunt pe) {
		return pretEmpruntRepo.save(pe);
	}

	@Override
	@Transactional
	public PretEmprunt modifierPretEmprunt(PretEmprunt pe) {
		return pretEmpruntRepo.save(pe);
	}

	@Override
	@Transactional
	public void supprimerPretEmprunt(PretEmprunt pe) {
		pretEmpruntRepo.delete(pe);
		
	}

	@Override
	@Transactional
	public void supprimerPretEmprunt(Integer idPretEmprunt) {
		pretEmpruntRepo.deleteById(idPretEmprunt);
		
	}

	@Override
	@Transactional
	public PretEmprunt rechercherPretEmprunt(Integer idPretEmprunt) {
		Optional<PretEmprunt> pretEmpruntOpt = pretEmpruntRepo.findById(idPretEmprunt);
		if (pretEmpruntOpt.isPresent()) {
			return pretEmpruntOpt.get();
		} else {
			throw new RuntimeException("Facture introuvable.");
		}
	}

	@Override
	@Transactional
	public Page<PretEmprunt> listerPretEmprunts(int numPage) {
		PageRequest pageable = PageRequest.of(numPage, 10);
		return pretEmpruntRepo.findAll(pageable);

	}

}
