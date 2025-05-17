package com.example.gestionatelier.metier;

import org.hibernate.query.Page;

import com.example.dao.entities.PretEmprunt;

public interface IGestionPretEmprunt {
	PretEmprunt ajouterPretEmprunt(PretEmprunt pe);
    PretEmprunt modifierPretEmprunt(PretEmprunt pe);
    void supprimerPretEmprunt(PretEmprunt pe);
    void supprimerPretEmprunt(Integer idPretEmprunt);
    PretEmprunt rechercherPretEmprunt(Integer idPretEmprunt);
    Page listerPretEmprunts(int numPage);

}
