package com.example.gestionatelier.metier;

import java.util.List;

import org.hibernate.query.Page;

import com.example.dao.entities.Facture;
import com.example.dao.entities.Proprietaire;

public interface IGestionProprietaire {
	Proprietaire ajouterProprietaire(Proprietaire p);
    Proprietaire modifierProprietaire(Proprietaire p);
    void supprimerProprietaire(Proprietaire p);
    void supprimerProprietaire(Integer idProprietaire);
    Proprietaire rechercherProprietaire(Integer idProprietaire);
    Page listerProprietaires(int numPage);
    
    List<Facture> ListerFactures();

}
