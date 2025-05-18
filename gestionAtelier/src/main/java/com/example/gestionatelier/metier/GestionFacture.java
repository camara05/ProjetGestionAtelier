package com.example.gestionatelier.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.dao.entities.Appareil;
import com.example.dao.entities.Facture;
import com.example.dao.entities.Reparation;
import com.example.dao.repositories.FactureRepository;
import com.example.dao.repositories.ReparationRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class GestionFacture implements IGestionFacture{
	
	private FactureRepository factureRepo;
	private final ReparationRepository reparationRepo;

	@Override
	@Transactional
	public Facture ajouterFacture(Facture f) {
		return factureRepo.save(f);
	}

	@Override
	@Transactional
	public Facture modifierFacture(Facture f) {
		return factureRepo.save(f);
	}

	@Override
	@Transactional
	public void supprimerFacture(Facture f) {
		factureRepo.delete(f);
	}

	@Override
	@Transactional
	public void supprimerFacture(Integer idFacture) {
		factureRepo.deleteById(idFacture);
		
	}

	@Override
	@Transactional
	public Facture rechercherFacture(Integer idFacture) {
		Optional<Facture> factureOpt = factureRepo.findById(idFacture);
		if (factureOpt.isPresent()) {
			return factureOpt.get();
		} else {
			throw new RuntimeException("Facture introuvable.");
		}

	}

	@Override
	@Transactional
	public Page<Facture> listerFactures(int numPage) {
		PageRequest pageable = PageRequest.of(numPage, 10);
		return factureRepo.findAll(pageable);

	}

	@Override
	@Transactional
	public List<Reparation> listerReparations() {
		return reparationRepo.findAll();
	}


}
