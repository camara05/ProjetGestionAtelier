package com.example.dao.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("admin")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin extends utilisateur {
	@Column
	private String permissions;
}
