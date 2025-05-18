package com.example.gestionatelier.metier;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.dao.entities.Facture;
import com.example.dao.entities.Proprietaire;
public interface IGestionProprietaire {
	Proprietaire ajouterProprietaire(Proprietaire p);
    Proprietaire modifierProprietaire(Proprietaire p);
    void supprimerProprietaire(Proprietaire p);
    void supprimerProprietaire(Integer idProprietaire);
    Proprietaire rechercherProprietaire(Integer idProprietaire);
    Page<Proprietaire> listerProprietaires(int numPage);
    List<Proprietaire> rechercherProprietaires(String nom, String prenom);
    
    List<Facture> ListerFactures();

}
