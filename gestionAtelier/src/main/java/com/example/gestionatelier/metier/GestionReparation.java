package com.example.gestionatelier.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.dao.entities.Appareil;
import com.example.dao.entities.Reparateur;
import com.example.dao.entities.Reparation;
import com.example.dao.repositories.AppareilRepository;
import com.example.dao.repositories.ReparateurRepository;
import com.example.dao.repositories.ReparationRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;



@Service
@AllArgsConstructor

public class GestionReparation implements IGestionReparation{

	private ReparationRepository reparationRepo;
	private final AppareilRepository appareilRepo;
	private final ReparateurRepository reparateurRepo;
	
	@Override
	@Transactional
	public Reparation ajouterReparation(Reparation r) {
		// TODO Auto-generated method stub
		return reparationRepo.save(r);
	}

	@Override
	@Transactional
	public Reparation modifierReparation(Reparation r) {
		// TODO Auto-generated method stub
		return reparationRepo.save(r);
	}

	@Override
	@Transactional
	public void supprimerReparation(Reparation r) {
		// TODO Auto-generated method stub
		reparationRepo.delete(r);
	}

	@Override
	@Transactional
	public void supprimerReparation(Integer idReparation) {
		// TODO Auto-generated method stub
		reparationRepo.deleteById(idReparation);
	}

	@Override
	@Transactional
	public Reparation rechercherReparation(Integer idReparation) {
		// TODO Auto-generated method stub
		 Optional<Reparation> or = reparationRepo.findById(idReparation);
		 if(or.isPresent())
			 return or.get();
		 else {
			throw new RuntimeException("Reparation Introuvable.");
		}
	}

	@Override
	@Transactional
	public Page<Reparation> listerReparations(int numPage) {
		// TODO Auto-generated method stub
		PageRequest pageable = PageRequest.of(numPage, 10);
		return reparationRepo.findAll(pageable);
	}


	@Override
	@Transactional
	public List<Appareil> listerAppareils() {
		return appareilRepo.findAll();
	}

	@Override
	@Transactional
	public List<Reparateur> listerReparateurs() {
		return reparateurRepo.findAll();
	}


}
