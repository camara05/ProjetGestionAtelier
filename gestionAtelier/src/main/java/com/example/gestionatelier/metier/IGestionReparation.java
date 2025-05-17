package com.example.gestionatelier.metier;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.dao.entities.Appareil;
import com.example.dao.entities.Reparateur;
import com.example.dao.entities.Reparation;

public interface IGestionReparation {
	
	    Reparation ajouterReparation(Reparation r);
	    Reparation modifierReparation(Reparation r);
	    void supprimerReparation(Reparation r);
	    void supprimerReparation(Integer idReparation);
	    Reparation rechercherReparation(Integer idReparation);
	    Page<Reparation> listerReparations(int numPage);
	    
	    List<Appareil> listerAppareils();
	    List<Reparateur> listerReparateurs();



}
