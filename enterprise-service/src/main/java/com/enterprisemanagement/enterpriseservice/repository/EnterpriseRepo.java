package com.enterprisemanagement.enterpriseservice.repository;

import com.enterprisemanagement.enterpriseservice.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface EnterpriseRepo extends JpaRepository<Enterprise, Long> {
}
