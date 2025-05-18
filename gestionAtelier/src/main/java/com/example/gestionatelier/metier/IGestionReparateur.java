package com.example.gestionatelier.metier;


import java.util.List;

import org.springframework.data.domain.Page;

import com.example.dao.entities.Reparateur;
import com.example.dao.entities.Reparation;
public interface IGestionReparateur {
	Reparateur ajouterReparateur(Reparateur r);
    Reparateur modifierReparateur(Reparateur r);
    void supprimerReparateur(Reparateur r);
    void supprimerReparateur(Integer idReparateur);
    Reparateur rechercherReparateur(Integer idReparateur);
    Page<Reparateur> listerReparateurs(int numPage);
    List<Reparateur> rechercherReparateurs(String nom, String prenom);
    
    List<Reparation> listerReparations();

}
