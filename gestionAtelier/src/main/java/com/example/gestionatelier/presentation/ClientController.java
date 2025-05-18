
package com.example.gestionatelier.presentation;

import com.example.dao.entities.Appareil;
import com.example.dao.entities.Client;
import com.example.gestionatelier.metier.IGestionClient;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@AllArgsConstructor
public class ClientController {

    private final IGestionClient gestionClient;

    // ➡️ Ajouter un nouveau client
    @PostMapping
    public ResponseEntity<Client> ajouterClient(@RequestBody Client client) {
        try {
            Client savedClient = gestionClient.ajouterClient(client);
            return ResponseEntity.ok(savedClient);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    // ➡️ Modifier un client existant
    @PutMapping("/{id}")
    public ResponseEntity<Client> modifierClient(@PathVariable Integer id, @RequestBody Client client) {
        try {
            client.setId(id); // On fixe l'ID pour être sûr de modifier le bon
            Client updatedClient = gestionClient.modifierClient(client);
            return ResponseEntity.ok(updatedClient);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    // ➡️ Supprimer un client par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerClient(@PathVariable Integer id) {
        try {
            gestionClient.supprimerClient(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    // ➡️ Rechercher un client par ID
    @GetMapping("/{id}")
    public ResponseEntity<Client> rechercherClient(@PathVariable Integer id) {
        try {
            Client client = gestionClient.rechercherClient(id);
            return ResponseEntity.ok(client);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // ➡️ Lister les clients avec pagination
    @GetMapping
    public ResponseEntity<Page<Client>> listerClients(@RequestParam(defaultValue = "0") int page) {
        Page<Client> clients = gestionClient.listerClients(page);
        return ResponseEntity.ok(clients);
    }

    // ➡️ Lister tous les appareils
    @GetMapping("/appareils")
    public ResponseEntity<List<Appareil>> listerAppareils() {
        List<Appareil> appareils = gestionClient.listerAppareils();
        return ResponseEntity.ok(appareils);
    }

    // ➡️ Rechercher des clients par nom et prénom
    @GetMapping("/search")
    public ResponseEntity<List<Client>> rechercherClients(@RequestParam(required = false) String nom,
                                                          @RequestParam(required = false) String prenom) {
        try {
            List<Client> clients = gestionClient.rechercherClients(nom, prenom);
            return ResponseEntity.ok(clients);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

