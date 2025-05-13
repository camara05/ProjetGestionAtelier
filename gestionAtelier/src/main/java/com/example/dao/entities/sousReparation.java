package com.example.dao.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class sousReparation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSousReparation;
    private float cout;
    private String description;
    private String piecesUtilisees;
    private String statut;

    @ManyToOne
    @JoinColumn(name = "reparation_id")
    private reparation reparation;
}