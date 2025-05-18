package com.example.gestionatelier.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.dao.entities.Appareil;
import com.example.dao.entities.Client;
import com.example.dao.entities.Reparation;
import com.example.dao.repositories.AppareilRepository;
import com.example.dao.repositories.ClientRepository;
import com.example.dao.repositories.ReparationRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class GestionAppareil implements IGestionAppareil {
	
	private AppareilRepository appareilRepo;
	private final ClientRepository clientRepo;
	private final ReparationRepository reparationRepo;
	
    

    @Override
    @Transactional
    public Appareil ajouterAppareil1(Appareil a) {
    	return appareilRepo.save(a);
    }

	@Override
	@Transactional
	public Appareil modifierAppareil(Appareil a) {
		return appareilRepo.save(a);
	}

	@Override
	@Transactional
	public void supprimerAppareil(Appareil a) {
		appareilRepo.delete(a);
		
	}

	@Override
	@Transactional
	public void supprimerAppareil(Integer idAppareil) {
		appareilRepo.deleteById(idAppareil);
		
	}

	@Override
	@Transactional
	public Appareil rechercherAppareil(Integer idAppareil) {
		 Optional<Appareil> or = appareilRepo.findById(idAppareil);
		 if(or.isPresent())
			 return or.get();
		 else {
			throw new RuntimeException("Appareil non Trouver");
		}
	}

	@Override
	@Transactional
	public Page<Appareil> listerAppareils(int numPage) {

		PageRequest pageable = PageRequest.of(numPage, 10);
		return appareilRepo.findAll(pageable);

	}

	@Override
	@Transactional
	public List<Client> listerClients() {
		return clientRepo.findAll();

	}

	@Override
	@Transactional
	public List<Reparation> listerReparations() {
		return reparationRepo.findAll();	
	}
	
	@Override
	@Transactional
	public List<Appareil> rechercherAppareils(String marque, String model) {

	    // Cas (marque ET modèle)
	    if (marque != null && !marque.isBlank() &&
	        model  != null && !model.isBlank()) {
	        List<Appareil> res = appareilRepo.findByMarqueAndModel(marque, model);
	        if (res.isEmpty())
	            throw new RuntimeException("Aucun appareil trouvé pour cette marque et ce modèle.");
	        return res;
	    	}
	    throw new IllegalArgumentException("Veuillez fournir au moins une marque ou un modèle.");
	    }
}
