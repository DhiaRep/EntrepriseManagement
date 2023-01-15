package com.departementservice.departementservice.FeignClient;

import com.departementservice.departementservice.model.Employe;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "employe-service")
public interface EmployeeClient {
    @GetMapping("/employe/departement/{departementId}")
    public List<Employe> getEmployeesByDepartementId(@PathVariable("departementId") Long departementId);
}
