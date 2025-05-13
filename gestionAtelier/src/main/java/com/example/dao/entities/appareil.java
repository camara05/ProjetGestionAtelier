package com.example.dao.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class appareil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAppareil;
    private Date dateDepot;
    private String descriptionPanne;
    private String IMEI;
    private String marque;
    private String modele;
    private String type;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private client client;

    @OneToOne(mappedBy = "appareil")
    private reparation reparation;
}

