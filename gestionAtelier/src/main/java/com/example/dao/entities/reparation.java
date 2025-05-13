package com.example.dao.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class reparation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReparation;
    private float coutTotal;
    private Date dateDebut;
    private Date dateFinEstimee;
    private String statut;

    @OneToOne
    @JoinColumn(name = "appareil_id")
    private appareil appareil;

    @OneToMany(mappedBy = "reparation")
    private List<sousReparation> sousReparations;

    @ManyToOne
    @JoinColumn(name = "reparateur_id")
    private reparateur reparateur;
}

