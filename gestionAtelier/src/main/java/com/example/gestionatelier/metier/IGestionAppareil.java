package com.example.gestionatelier.metier;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.dao.entities.Appareil;
import com.example.dao.entities.Client;
import com.example.dao.entities.Reparation;


public interface IGestionAppareil {
	Appareil ajouterAppareil1(Appareil a);
    Appareil modifierAppareil(Appareil a);
    void supprimerAppareil(Appareil a);
    void supprimerAppareil(Integer idAppareil);
    Appareil rechercherAppareil(Integer idAppareil);
    Page<Appareil> listerAppareils(int numPage);
    List<Appareil> rechercherAppareils(String marque, String model);
    
    List<Client> listerClients();
    List<Reparation> listerReparations();
	
	
	
    

}
