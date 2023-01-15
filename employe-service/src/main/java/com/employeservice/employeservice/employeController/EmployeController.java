package com.employeservice.employeservice.employeController;

import com.employeservice.employeservice.EmployeService.EmployeService;
import com.employeservice.employeservice.dto.EmployeRequest;
import com.employeservice.employeservice.dto.EmployeResponse;
import com.employeservice.employeservice.model.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employe")
public class EmployeController {

    @Autowired
    private final EmployeService employeService;

    public EmployeController (EmployeService employeService) {
        this.employeService=employeService;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeResponse> gettAllEmployes() {
        return employeService.gettAllEmployes();
    }



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmploye(@RequestBody EmployeRequest employeRequest) {
        employeService.createEmploye(employeRequest);

    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateEmploye(@PathVariable("id") Long id, @RequestBody EmployeRequest employeRequest) {
        employeService.updateEmploye(id, employeRequest);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmploye(@PathVariable("id") Long id) {
        employeService.deleteEmploye(id);
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeResponse getEmploye(@PathVariable("id") Long id) {
        return employeService.getEmploye(id);
    }

    @GetMapping("/departement/{departementId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employe> getEmployesByDepartementId(@PathVariable("departementId") Long departementId) {
        return employeService.getEmployeesByDepartementId(departementId);
    }
}
