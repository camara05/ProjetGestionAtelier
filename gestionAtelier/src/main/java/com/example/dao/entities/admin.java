package com.example.dao.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("adm")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class admin extends utilisateur {
    private String permissions;
}
