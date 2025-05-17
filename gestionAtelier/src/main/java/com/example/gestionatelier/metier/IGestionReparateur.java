package com.example.gestionatelier.metier;


import java.util.List;

import org.hibernate.query.Page;

import com.example.dao.entities.Reparateur;
import com.example.dao.entities.Reparation;

public interface IGestionReparateur {
	Reparateur ajouterReparateur(Reparateur r);
    Reparateur modifierReparateur(Reparateur r);
    void supprimerReparateur(Reparateur r);
    void supprimerReparateur(Integer idReparateur);
    Reparateur rechercherReparateur(Integer idReparateur);
    Page listerReparateurs(int numPage);
    
    List<Reparation> listerReparations();

}
