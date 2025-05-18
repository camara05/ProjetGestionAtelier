package com.example.gestionatelier.metier;



import java.util.List;

import org.springframework.data.domain.Page;

import com.example.dao.entities.Client;
import com.example.dao.entities.Facture;
import com.example.dao.entities.Proprietaire;
import com.example.dao.entities.Reparation;

public interface IGestionFacture {
	Facture ajouterFacture(Facture f);
	Facture modifierFacture(Facture f);
	void supprimerFacture(Facture f);
	void supprimerFacture(Integer idFacture);
	Facture rechercherFacture(Integer idFacture);
	Page<Facture> listerFactures(int numPage);
	
	List<Reparation> listerReparations();

}
