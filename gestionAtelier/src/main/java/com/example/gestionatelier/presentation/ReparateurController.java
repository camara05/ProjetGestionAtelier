
package com.example.gestionatelier.presentation;

import com.example.dao.entities.Reparateur;
import com.example.dao.entities.Reparation;
import com.example.gestionatelier.metier.IGestionReparateur;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reparateurs")
@AllArgsConstructor
public class ReparateurController {

    private final IGestionReparateur gestionReparateur;

    // ➡️ Ajouter un nouveau réparateur
    @PostMapping
    public ResponseEntity<Reparateur> ajouterReparateur(@RequestBody Reparateur reparateur) {
        try {
            Reparateur savedReparateur = gestionReparateur.ajouterReparateur(reparateur);
            return ResponseEntity.ok(savedReparateur);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    // ➡️ Modifier un réparateur existant
    @PutMapping("/{id}")
    public ResponseEntity<Reparateur> modifierReparateur(@PathVariable Integer id, @RequestBody Reparateur reparateur) {
        try {
            reparateur.setId(id); // On fixe l'ID pour être sûr de modifier le bon réparateur
            Reparateur updatedReparateur = gestionReparateur.modifierReparateur(reparateur);
            return ResponseEntity.ok(updatedReparateur);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    // ➡️ Supprimer un réparateur par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerReparateur(@PathVariable Integer id) {
        try {
            gestionReparateur.supprimerReparateur(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    // ➡️ Rechercher un réparateur par ID
    @GetMapping("/{id}")
    public ResponseEntity<Reparateur> rechercherReparateur(@PathVariable Integer id) {
        try {
            Reparateur reparateur = gestionReparateur.rechercherReparateur(id);
            return ResponseEntity.ok(reparateur);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // ➡️ Lister les réparateurs avec pagination
    @GetMapping
    public ResponseEntity<Page<Reparateur>> listerReparateurs(@RequestParam(defaultValue = "0") int page) {
        Page<Reparateur> reparateurs = gestionReparateur.listerReparateurs(page);
        return ResponseEntity.ok(reparateurs);
    }

    // ➡️ Lister toutes les réparations
    @GetMapping("/reparations")
    public ResponseEntity<List<Reparation>> listerReparations() {
        List<Reparation> reparations = gestionReparateur.listerReparations();
        return ResponseEntity.ok(reparations);
    }

    // ➡️ Rechercher un réparateur par nom et prénom
    @GetMapping("/search")
    public ResponseEntity<List<Reparateur>> rechercherReparateurs(@RequestParam String nom, @RequestParam String prenom) {
        try {
            List<Reparateur> reparateurs = gestionReparateur.rechercherReparateurs(nom, prenom);
            return ResponseEntity.ok(reparateurs);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
