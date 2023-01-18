package com.enterprisemanagement.enterpriseservice.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("fournisseur-service")
public interface FournisseurFeign {

    @RequestMapping(method = RequestMethod.GET, value = "/fournisseur")
    List<Fournisseur> getAllFournisseurs();

}
