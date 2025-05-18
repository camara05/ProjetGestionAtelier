
package com.example.gestionatelier.presentation;

import com.example.dao.entities.PretEmprunt;
import com.example.gestionatelier.metier.IGestionPretEmprunt;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pretsemprunts")
@AllArgsConstructor
public class PretEmpruntController {

    private final IGestionPretEmprunt gestionPretEmprunt;

    // ➡️ Ajouter un nouveau prêt/emprunt
    @PostMapping
    public ResponseEntity<PretEmprunt> ajouterPretEmprunt(@RequestBody PretEmprunt pretEmprunt) {
        try {
            PretEmprunt savedPretEmprunt = gestionPretEmprunt.ajouterPretEmprunt(pretEmprunt);
            return ResponseEntity.ok(savedPretEmprunt);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    // ➡️ Modifier un prêt/emprunt existant
    @PutMapping("/{id}")
    public ResponseEntity<PretEmprunt> modifierPretEmprunt(@PathVariable Integer id, @RequestBody PretEmprunt pretEmprunt) {
        try {
            pretEmprunt.setIdTransaction(id); // On fixe l'ID pour être sûr de modifier le bon prêt/emprunt
            PretEmprunt updatedPretEmprunt = gestionPretEmprunt.modifierPretEmprunt(pretEmprunt);
            return ResponseEntity.ok(updatedPretEmprunt);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    // ➡️ Supprimer un prêt/emprunt par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerPretEmprunt(@PathVariable Integer id) {
        try {
            gestionPretEmprunt.supprimerPretEmprunt(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    // ➡️ Rechercher un prêt/emprunt par ID
    @GetMapping("/{id}")
    public ResponseEntity<PretEmprunt> rechercherPretEmprunt(@PathVariable Integer id) {
        try {
            PretEmprunt pretEmprunt = gestionPretEmprunt.rechercherPretEmprunt(id);
            return ResponseEntity.ok(pretEmprunt);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // ➡️ Lister les prêts/emprunts avec pagination
    @GetMapping
    public ResponseEntity<Page<PretEmprunt>> listerPretEmprunts(@RequestParam(defaultValue = "0") int page) {
        Page<PretEmprunt> pretEmprunts = gestionPretEmprunt.listerPretEmprunts(page);
        return ResponseEntity.ok(pretEmprunts);
    }
}

