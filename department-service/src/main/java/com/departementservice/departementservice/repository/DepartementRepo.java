package com.departementservice.departementservice.repository;

import com.departementservice.departementservice.model.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface DepartementRepo extends JpaRepository<Departement, Long> {
    Optional<Departement> findDepartementByName(String name);

    // This is the interface that is used to connect to the database and get the data from it and return it to the controller

}
