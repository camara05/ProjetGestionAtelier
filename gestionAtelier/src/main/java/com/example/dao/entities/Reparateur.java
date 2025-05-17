package com.example.dao.entities;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("reparateur")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reparateur extends utilisateur {
    private float commission;
    private boolean compteActif;
    private String specialite;

    @OneToMany(mappedBy = "reparateur")
    private List<Reparation> reparations;
}

