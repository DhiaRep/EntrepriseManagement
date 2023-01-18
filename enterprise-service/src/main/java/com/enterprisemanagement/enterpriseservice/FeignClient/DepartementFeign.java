package com.enterprisemanagement.enterpriseservice.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("departement-service")
public interface DepartementFeign {

    @RequestMapping(method = RequestMethod.GET, value = "/departement")
    List<Departement> getAllDepartements();
}
