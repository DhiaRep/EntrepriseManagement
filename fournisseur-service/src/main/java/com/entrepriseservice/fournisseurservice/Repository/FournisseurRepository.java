package com.entrepriseservice.fournisseurservice.Repository;

import com.entrepriseservice.fournisseurservice.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {

}
