package com.example.gestionatelier.metier;

import org.springframework.data.domain.Page;


import com.example.dao.entities.Admin;
import com.example.dao.entities.Client;

public interface IGestionAdmin {
	Admin ajouterAdmin(Admin a);
    Admin modifierAdmin(Admin a);
    void supprimerAdmin(Admin a);
    void supprimerAdmin(Integer idAdmin);
    Admin rechercherAdmin(Integer idAdmin);
    Page<Admin> listerAdmins(int numPage);
    
    

}
