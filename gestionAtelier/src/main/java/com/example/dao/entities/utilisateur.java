package com.example.dao.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;



@DiscriminatorColumn(name = "role")
@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String motDePasse;
    @Column
    private String mail;
    @Column
    private String nom;
    @Column
    private String prenom;
    @Column
    private Integer telephone;
}
