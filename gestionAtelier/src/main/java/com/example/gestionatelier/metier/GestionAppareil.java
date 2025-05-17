package com.example.gestionatelier.metier;

import java.util.List;

import org.hibernate.query.Page;

import com.example.dao.entities.Appareil;
import com.example.dao.entities.Client;
import com.example.dao.entities.Reparation;
import com.example.dao.repositories.AppareilRepository;

import jakarta.transaction.Transactional;

public class GestionAppareil implements IGestionAppareil {
    

    @Override
    @Transactional
    public Appareil ajouterAppareil1(Appareil a) {
        return null;
    }

	@Override
	public Appareil modifierAppareil(Appareil a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimerAppareil(Appareil a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerAppareil(Integer idAppareil) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Appareil rechercherAppareil(Integer idAppareil) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page listerAppareils(int numPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> listerClients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reparation> listerReparations() {
		// TODO Auto-generated method stub
		return null;
	}
}
