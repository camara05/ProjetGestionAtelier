package com.example.dao.entities;

import java.sql.Date;

import jakarta.persistence.Column;
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
public class Appareil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAppareil;
    @Column
    private Date dateDepot;
    @Column
    private String descriptionPanne;
    @Column
    private String IMEI;
    @Column
    private String marque;
    @Column
    private String model;
    @Column
    private String type;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne(mappedBy = "appareil")
    private Reparation reparation;
}

