package com.employeservice.employeservice.repository;

import com.employeservice.employeservice.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface EmployeRepository extends JpaRepository<Employe, Long> {

    List<Employe> findByDepartementId(Long departementId);
}

