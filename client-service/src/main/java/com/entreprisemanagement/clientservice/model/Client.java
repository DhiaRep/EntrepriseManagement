package com.entreprisemanagement.clientservice.model;

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
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CIN ;
	private String nom ;
	private String prenom ;
	
	//a constructor without id
	public Client(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
}
