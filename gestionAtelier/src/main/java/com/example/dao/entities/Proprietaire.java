package com.example.dao.entities;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("proprietaire")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proprietaire extends utilisateur {
    private String nomMagasin;
    @OneToMany(mappedBy = "proprietaire")
    private List<Facture> factures;
    
}
