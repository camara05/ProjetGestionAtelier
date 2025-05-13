package com.example.dao.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String motDePasse;
    private String mail;
    private String nom;
    private String prenom;
}
