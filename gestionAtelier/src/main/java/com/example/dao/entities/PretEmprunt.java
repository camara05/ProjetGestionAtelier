package com.example.dao.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PretEmprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTransaction;
    private Date dateTransaction;
    private float montant;
    private String statutRemboursement;
}


