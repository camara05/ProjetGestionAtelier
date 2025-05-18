
package com.example.gestionatelier.presentation;

import com.example.dao.entities.Admin;
import com.example.gestionatelier.metier.IGestionAdmin;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/admins")
@AllArgsConstructor
public class AdminController {

    private final IGestionAdmin gestionAdmin;

    // ➡️ Ajouter un nouvel admin
    @PostMapping
    public ResponseEntity<Admin> ajouterAdmin(@RequestBody Admin admin) {
        try {
            Admin savedAdmin = gestionAdmin.ajouterAdmin(admin);
            return ResponseEntity.ok(savedAdmin);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    // ➡️ Modifier un admin existant
    @PutMapping("/{id}")
    public ResponseEntity<Admin> modifierAdmin(@PathVariable Integer id, @RequestBody Admin admin) {
        try {
            admin.setId(id); // On fixe l'ID
            Admin updatedAdmin = gestionAdmin.modifierAdmin(admin);
            return ResponseEntity.ok(updatedAdmin);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    // ➡️ Supprimer un admin par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerAdmin(@PathVariable Integer id) {
        try {
            gestionAdmin.supprimerAdmin(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    // ➡️ Rechercher un admin par ID
    @GetMapping("/{id}")
    public ResponseEntity<Admin> rechercherAdmin(@PathVariable Integer id) {
        Admin admin = gestionAdmin.rechercherAdmin(id);
        if (admin == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(admin);
    }

    // ➡️ Lister les admins avec pagination
    @GetMapping
    public ResponseEntity<Page<Admin>> listerAdmins(@RequestParam(defaultValue = "0") int page) {
        Page<Admin> admins = gestionAdmin.listerAdmins(page);
        return ResponseEntity.ok(admins);
    }
}

