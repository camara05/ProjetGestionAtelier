package com.example.gestionatelier.metier;

import org.hibernate.query.Page;

import com.example.dao.entities.Admin;

public interface IGestionAdmin {
	Admin ajouterAdmin(Admin a);
    Admin modifierAdmin(Admin a);
    void supprimerAdmin(Admin a);
    void supprimerAdmin(Integer idAdmin);
    Admin rechercherAdmin(Integer idAdmin);
    Page listerAdmins(int numPage);
    
    

}
