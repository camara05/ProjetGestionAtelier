
package com.example.gestionatelier.presentation;

import com.example.dao.entities.Facture;
import com.example.dao.entities.Reparation;
import com.example.gestionatelier.metier.IGestionFacture;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/factures")
@AllArgsConstructor
public class FactureController {

    private final IGestionFacture gestionFacture;

    // ➡️ Ajouter une nouvelle facture
    @PostMapping
    public ResponseEntity<Facture> ajouterFacture(@RequestBody Facture facture) {
        try {
            Facture savedFacture = gestionFacture.ajouterFacture(facture);
            return ResponseEntity.ok(savedFacture);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    // ➡️ Modifier une facture existante
    @PutMapping("/{id}")
    public ResponseEntity<Facture> modifierFacture(@PathVariable Integer id, @RequestBody Facture facture) {
        try {
            facture.setIdFacture(id); // On fixe l'ID pour être sûr de modifier la bonne facture
            Facture updatedFacture = gestionFacture.modifierFacture(facture);
            return ResponseEntity.ok(updatedFacture);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    // ➡️ Supprimer une facture par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerFacture(@PathVariable Integer id) {
        try {
            gestionFacture.supprimerFacture(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    // ➡️ Rechercher une facture par ID
    @GetMapping("/{id}")
    public ResponseEntity<Facture> rechercherFacture(@PathVariable Integer id) {
        try {
            Facture facture = gestionFacture.rechercherFacture(id);
            return ResponseEntity.ok(facture);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // ➡️ Lister les factures avec pagination
    @GetMapping
    public ResponseEntity<Page<Facture>> listerFactures(@RequestParam(defaultValue = "0") int page) {
        Page<Facture> factures = gestionFacture.listerFactures(page);
        return ResponseEntity.ok(factures);
    }

    // ➡️ Lister toutes les réparations
    @GetMapping("/reparations")
    public ResponseEntity<List<Reparation>> listerReparations() {
        List<Reparation> reparations = gestionFacture.listerReparations();
        return ResponseEntity.ok(reparations);
    }
}

