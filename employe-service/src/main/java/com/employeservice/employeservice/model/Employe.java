package com.employeservice.employeservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nom ;
    private String prenom ;
    private int age ;
    private String cv ;
    private Long departementId;

    //a constructor without id
    public Employe(String nom, String prenom, int age, String cv, Long departementId) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.cv = cv;
        this.departementId = departementId;
    }
}
