package com.entrepriseservice.fournisseurservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
@Setter
public class Fournisseur {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID ;
	private String nom ;
	private int numTel;

	//a constructor without id
	public Fournisseur(String nom, int numTel) {
		this.nom = nom;
		this.numTel = numTel;
	}

}
