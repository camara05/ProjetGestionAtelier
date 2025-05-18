
package com.example.gestionatelier.presentation;

import com.example.dao.entities.Appareil;
import com.example.dao.entities.Client;
import com.example.dao.entities.Reparation;
import com.example.gestionatelier.metier.IGestionAppareil;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appareils")
@AllArgsConstructor
public class AppareilController {

    private final IGestionAppareil gestionAppareil;

    // ➡️ Ajouter un nouvel appareil
    @PostMapping
    public ResponseEntity<Appareil> ajouterAppareil(@RequestBody Appareil appareil) {
        try {
            Appareil savedAppareil = gestionAppareil.ajouterAppareil1(appareil);
            return ResponseEntity.ok(savedAppareil);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    // ➡️ Modifier un appareil existant
    @PutMapping("/{id}")
    public ResponseEntity<Appareil> modifierAppareil(@PathVariable Integer id, @RequestBody Appareil appareil) {
        try {
            appareil.setIdAppareil(id); // On fixe l'ID pour être sûr de modifier le bon
            Appareil updatedAppareil = gestionAppareil.modifierAppareil(appareil);
            return ResponseEntity.ok(updatedAppareil);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    // ➡️ Supprimer un appareil par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerAppareil(@PathVariable Integer id) {
        try {
            gestionAppareil.supprimerAppareil(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    // ➡️ Rechercher un appareil par ID
    @GetMapping("/{id}")
    public ResponseEntity<Appareil> rechercherAppareil(@PathVariable Integer id) {
        try {
            Appareil appareil = gestionAppareil.rechercherAppareil(id);
            return ResponseEntity.ok(appareil);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // ➡️ Lister les appareils avec pagination
    @GetMapping
    public ResponseEntity<Page<Appareil>> listerAppareils(@RequestParam(defaultValue = "0") int page) {
        Page<Appareil> appareils = gestionAppareil.listerAppareils(page);
        return ResponseEntity.ok(appareils);
    }

    // ➡️ Lister les clients
    @GetMapping("/clients")
    public ResponseEntity<List<Client>> listerClients() {
        List<Client> clients = gestionAppareil.listerClients();
        return ResponseEntity.ok(clients);
    }

    // ➡️ Lister les réparations
    @GetMapping("/reparations")
    public ResponseEntity<List<Reparation>> listerReparations() {
        List<Reparation> reparations = gestionAppareil.listerReparations();
        return ResponseEntity.ok(reparations);
    }

    // ➡️ Rechercher appareils par marque et modèle
    @GetMapping("/search")
    public ResponseEntity<List<Appareil>> rechercherAppareils(@RequestParam(required = false) String marque,
                                                              @RequestParam(required = false) String model) {
        try {
            List<Appareil> appareils = gestionAppareil.rechercherAppareils(marque, model);
            return ResponseEntity.ok(appareils);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}