
package com.example.gestionatelier.presentation;

import com.example.dao.entities.Facture;
import com.example.dao.entities.Proprietaire;
import com.example.gestionatelier.metier.IGestionProprietaire;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proprietaires")
@AllArgsConstructor
public class ProprietaireController {

    private final IGestionProprietaire gestionProprietaire;

    // ➡️ Ajouter un nouveau propriétaire
    @PostMapping
    public ResponseEntity<Proprietaire> ajouterProprietaire(@RequestBody Proprietaire proprietaire) {
        try {
            Proprietaire savedProprietaire = gestionProprietaire.ajouterProprietaire(proprietaire);
            return ResponseEntity.ok(savedProprietaire);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    // ➡️ Modifier un propriétaire existant
    @PutMapping("/{id}")
    public ResponseEntity<Proprietaire> modifierProprietaire(@PathVariable Integer id, @RequestBody Proprietaire proprietaire) {
        try {
            proprietaire.setId(id); // On fixe l'ID pour être sûr de modifier le bon propriétaire
            Proprietaire updatedProprietaire = gestionProprietaire.modifierProprietaire(proprietaire);
            return ResponseEntity.ok(updatedProprietaire);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    // ➡️ Supprimer un propriétaire par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerProprietaire(@PathVariable Integer id) {
        try {
            gestionProprietaire.supprimerProprietaire(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    // ➡️ Rechercher un propriétaire par ID
    @GetMapping("/{id}")
    public ResponseEntity<Proprietaire> rechercherProprietaire(@PathVariable Integer id) {
        try {
            Proprietaire proprietaire = gestionProprietaire.rechercherProprietaire(id);
            return ResponseEntity.ok(proprietaire);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // ➡️ Lister les propriétaires avec pagination
    @GetMapping
    public ResponseEntity<Page<Proprietaire>> listerProprietaires(@RequestParam(defaultValue = "0") int page) {
        Page<Proprietaire> proprietaires = gestionProprietaire.listerProprietaires(page);
        return ResponseEntity.ok(proprietaires);
    }

    // ➡️ Lister toutes les factures
    @GetMapping("/factures")
    public ResponseEntity<List<Facture>> listerFactures() {
        List<Facture> factures = gestionProprietaire.ListerFactures();
        return ResponseEntity.ok(factures);
    }

    // ➡️ Rechercher un propriétaire par nom et prénom
    @GetMapping("/search")
    public ResponseEntity<List<Proprietaire>> rechercherProprietaires(@RequestParam String nom, @RequestParam String prenom) {
        try {
            List<Proprietaire> proprietaires = gestionProprietaire.rechercherProprietaires(nom, prenom);
            return ResponseEntity.ok(proprietaires);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
