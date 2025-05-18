package com.example.gestionatelier.metier;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.dao.entities.Appareil;
import com.example.dao.entities.Client;
public interface IGestionClient {
	Client ajouterClient(Client c);
    Client modifierClient(Client c);
    void supprimerClient(Client c);
    void supprimerClient(Integer idClient);
    Client rechercherClient(Integer idClient);
    Page<Client> listerClients(int numPage);
    List<Client> rechercherClients(String nom, String prenom);

     
    List<Appareil> listerAppareils();

}
