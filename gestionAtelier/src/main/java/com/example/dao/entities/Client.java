package com.example.dao.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("client")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client extends utilisateur {
	@Column
    private String photo;
    @Column
    private String adresse;
    @Column
    private String codeAcces;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Appareil> appareils;
}

