package com.example.dao.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFacture;
    private float montantPaye;
    private float montantTotal;
    private float soldeRestant;

    @OneToOne
    @JoinColumn(name = "reparation_id")
    private reparation reparation;
}
