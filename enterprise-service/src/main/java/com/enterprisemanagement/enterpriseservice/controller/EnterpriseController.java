package com.enterprisemanagement.enterpriseservice.controller;

import com.enterprisemanagement.enterpriseservice.FeignClient.*;
import com.enterprisemanagement.enterpriseservice.model.Enterprise;
import com.enterprisemanagement.enterpriseservice.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;
    @Autowired
    private DepartementFeign departementFeign;
    @Autowired
    private FournisseurFeign fournisseurFeign;
    @Autowired
    private ClientFeign clientFeign;

    //inject enterprise service
    public EnterpriseController(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }

    //get all enterprises
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Enterprise> getAllEnterprises() {
        return enterpriseService.getAllEnterprises();
    }

    //update enterprise
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateEnterprise(@RequestBody Enterprise enterprise) {
        enterpriseService.updateEnterprise(enterprise);
    }

    //get all departements
    @GetMapping("/departements")
    @ResponseStatus(HttpStatus.OK)
    public List<Departement> getDepartement() {
        return departementFeign.getAllDepartements();
    }

    //get all fournisseurs
    @GetMapping("/fournisseurs")
    @ResponseStatus(HttpStatus.OK)
    public List<Fournisseur> getFournisseur() {
        return fournisseurFeign.getAllFournisseurs();
    }

    //get all clients
    @GetMapping("/clients")
    @ResponseStatus(HttpStatus.OK)
    public List<Client> getClient() {
        return clientFeign.getAllClients();
    }
}
