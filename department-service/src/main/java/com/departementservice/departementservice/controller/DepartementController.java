package com.departementservice.departementservice.controller;


import com.departementservice.departementservice.FeignClient.EmployeeClient;
import com.departementservice.departementservice.model.Departement;
import com.departementservice.departementservice.model.Employe;
import com.departementservice.departementservice.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// This is the controller that is used to get the data from the service and return it to the user


@RestController
@RequestMapping("/departement")
public class DepartementController {

    @Autowired
    private final EmployeeClient employeClient;
    private final DepartementService departementService;
     @Autowired
     public DepartementController(EmployeeClient employeClient, DepartementService departementService) {
         this.employeClient = employeClient;
         this.departementService = departementService;
     }


    @GetMapping
    public List<Departement> getDepartements(){
        return departementService.getDepartements();
    }


    @PostMapping
    public void registerNewDepartement (@RequestBody Departement departement){
        departementService.addNewDepartement(departement);
    }

    @GetMapping(path = "{departementName}")
    public Departement getDepartementByName(@PathVariable("departementName") String departementName){
        return departementService.getDepartementByName(departementName);
    }

    @PutMapping(path = "{departementId}")
    public void updateDepartement(
            @PathVariable("departementId") Long departementId,
            @RequestParam(required = false) String name){
        departementService.updateDepartement(departementId,name);
    }

    @DeleteMapping(path = "{departementId}") // This is used to get the id from the url and pass it to the deleteDepartement method in the service
    public void deleteDepartement(@PathVariable("departementId") Long departementId){
        departementService.deleteDepartement(departementId);
    }

    @GetMapping("/{departementId}/employees")
    public List<Employe> getEmployeesByDepartementId(@PathVariable("departementId") Long departementId){
        return employeClient.getEmployeesByDepartementId(departementId);
    }
}
