package com.example.gestionatelier.metier;

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
		return adminRepo.save(a);
	}


	@Override
	public Admin ajouterAdmin(Admin a) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void supprimerAdmin(Admin a) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void supprimerAdmin(Integer idAdmin) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Admin rechercherAdmin(Integer idAdmin) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Page<Admin> listerAdmins(int numPage) {
		// TODO Auto-generated method stub
		return null;
	}
/*
	@Override
	@Transactional
	public void supprimerAdmin(Admin a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void supprimerAdmin(Integer idAdmin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public Admin rechercherAdmin(Integer idAdmin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Page listerAdmins(int numPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Admin ajouterAdmin(Admin a) {
		// TODO Auto-generated method stub
		return null;
	}
*/
}
