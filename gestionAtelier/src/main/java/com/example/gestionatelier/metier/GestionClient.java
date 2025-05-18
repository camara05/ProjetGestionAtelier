package com.example.gestionatelier.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.dao.entities.Appareil;
import com.example.dao.entities.Client;
import com.example.dao.repositories.AppareilRepository;
import com.example.dao.repositories.ClientRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class GestionClient implements IGestionClient{
	
	private ClientRepository clientRepo;
	private final AppareilRepository appareilRepo;

	@Override
	@Transactional
	public Client ajouterClient(Client c) {
		return clientRepo.save(c);
    }

	@Override
	@Transactional
	public Client modifierClient(Client c) {
        return clientRepo.save(c);
    }

	@Override
	@Transactional
	public void supprimerClient(Client c) {
		clientRepo.delete(c);
	}

	@Override
	@Transactional
	public void supprimerClient(Integer idClient) {
		clientRepo.deleteById(idClient);

	}

	@Override
	@Transactional
	public Client rechercherClient(Integer idClient) {
		Optional<Client> clientOpt = clientRepo.findById(idClient);
		if (clientOpt.isPresent()) {
			return clientOpt.get();
		} else {
			throw new RuntimeException("Client introuvable.");
		}
	}

	@Override
	@Transactional
	public Page<Client> listerClients(int numPage) {
        PageRequest pageable = PageRequest.of(numPage, 10);
        return clientRepo.findAll(pageable);
	}
	

	
	@Override
	@Transactional
	public List<Appareil> listerAppareils() {
		return appareilRepo.findAll();
	}

	@Override
	@Transactional
	public List<Client> rechercherClients(String nom, String prenom) {
		List<Client> clients = clientRepo.findByNomAndPrenom(nom, prenom);
		if (clients.isEmpty()) {
			throw new RuntimeException("Aucun client trouvé.");
		}
		return clients;
	}
	



}
