package com.example.gestionatelier.metier;

import org.springframework.data.domain.Page;

import com.example.dao.entities.Client;
import com.example.dao.entities.PretEmprunt;

public interface IGestionPretEmprunt {
	PretEmprunt ajouterPretEmprunt(PretEmprunt pe);
    PretEmprunt modifierPretEmprunt(PretEmprunt pe);
    void supprimerPretEmprunt(PretEmprunt pe);
    void supprimerPretEmprunt(Integer idPretEmprunt);
    PretEmprunt rechercherPretEmprunt(Integer idPretEmprunt);
    Page<PretEmprunt> listerPretEmprunts(int numPage);

}
