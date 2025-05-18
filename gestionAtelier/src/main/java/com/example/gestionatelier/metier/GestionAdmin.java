package com.example.gestionatelier.metier;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.dao.entities.Admin;
import com.example.dao.repositories.AdminRepository;
import com.example.dao.repositories.AppareilRepository;
import com.example.dao.repositories.ReparateurRepository;
import com.example.dao.repositories.ReparationRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GestionAdmin implements IGestionAdmin {

	private  AdminRepository adminRepo;


	@Override
	@Transactional
	public Admin modifierAdmin(Admin a) {
		if (a == null || a.getId() == null) {
			throw new IllegalArgumentException("L'admin ou son identifiant ne peut pas être null.");
		}
		
		Optional<Admin> existingAdmin = adminRepo.findById(a.getId());
		if (existingAdmin.isEmpty()) {
			throw new IllegalArgumentException("L'admin avec cet ID n'existe pas.");
		}
		
		// Mise à jour des informations
		Admin adminToUpdate = existingAdmin.get();
		adminToUpdate.setNom(a.getNom());
		adminToUpdate.setPrenom(a.getPrenom());
		adminToUpdate.setMail(a.getMail());
		adminToUpdate.setMotDePasse(a.getMotDePasse());
		
		return adminRepo.save(adminToUpdate);
	}


	@Override
	public Admin ajouterAdmin(Admin a) {
		return adminRepo.save(a);
	}


	@Override
	public void supprimerAdmin(Admin a) {
		adminRepo.delete(a);

	}


	@Override
	public void supprimerAdmin(Integer idAdmin) {
		adminRepo.deleteById(idAdmin);

	}


	@Override
	public Admin rechercherAdmin(Integer idAdmin) {
		return adminRepo.findById(idAdmin).orElse(null);
		}


	@Override
	public Page<Admin> listerAdmins(int numPage) {
		// TODO Auto-generated method stub
		return null;
	}

}
