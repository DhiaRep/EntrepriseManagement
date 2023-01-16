package com.entreprisemanagement.clientservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entreprisemanagement.clientservice.model.Client;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Long>{

}
