package com.example.gestionatelier.metier;

import java.util.List;

import org.hibernate.query.Page;

import com.example.dao.entities.Facture;
import com.example.dao.entities.Proprietaire;
import com.example.dao.entities.Reparation;

public class GestionFacture implements IGestionFacture{

	@Override
	public Facture ajouterFacture(Facture f) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Facture modifierFacture(Facture f) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimerFacture(Facture f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerFacture(Integer idFacture) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Facture rechercherFacture(Integer idFacture) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page listerFactures(int numPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reparation> listerReparations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proprietaire> listerProprietairs() {
		// TODO Auto-generated method stub
		return null;
	}

}
