package com.example.gestionatelier.metier;

import java.util.List;

import org.hibernate.query.Page;

import com.example.dao.entities.Appareil;
import com.example.dao.entities.Client;

public class GestionClient implements IGestionClient{

	@Override
	public Client ajouterClient(Client c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client modifierClient(Client c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimerClient(Client c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerClient(Integer idClient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Client rechercherClient(Integer idClient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page listerClients(int numPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Appareil> listerAppareils() {
		// TODO Auto-generated method stub
		return null;
	}

}
