package com.departementservice.departementservice.service;


import com.departementservice.departementservice.FeignClient.EmployeeClient;
import com.departementservice.departementservice.model.Departement;
import com.departementservice.departementservice.model.Employe;
import com.departementservice.departementservice.repository.DepartementRepo;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DepartementService {
    //mainly for business logic //contains all the Departement methods
    // This class is used to connect to the database and get the data from it and return it to the controller
    @Autowired
    private EmployeeClient employeeClient;

    @Autowired
    private final DepartementRepo departementRepo;
    @Autowired
    public DepartementService(DepartementRepo departementRepo) {
        this.departementRepo = departementRepo;
    }

    public List<Departement> getDepartements(){ // This is used to get all the departements from the database and
        // return it to the controller as a list of departements using the departementRepo interface
        return departementRepo.findAll();
    }

    public void addNewDepartement(Departement departement) {
        Optional<Departement> departementOptional = departementRepo.findDepartementByName(departement.getName());
        if (departementOptional.isPresent())
        {
            throw new IllegalStateException("name taken");
        }
        departementRepo.save(departement);
    }

    public void deleteDepartement(Long departementId){
        //check if the departement exist
        boolean idExist = departementRepo.existsById(departementId);
        if (!idExist){
            throw new IllegalStateException("departement with id " + departementId + " does not exist");
        }
        departementRepo.deleteById(departementId);
    }

    @Transactional
    public void updateDepartement(Long departementId, String name) {
        Departement departement = departementRepo.findById(departementId).orElseThrow(() -> new IllegalStateException(
                "departement with id " + departementId + " does not exist"
        ));
        if (name != null && name.length() > 0 && !departement.getName().equals(name)) {
            departement.setName(name);
        }
    }


    public Departement getDepartementByName(String departementName) {
        Optional<Departement> departementOptional = departementRepo.findDepartementByName(departementName);
        if (departementOptional.isEmpty()){
            throw new IllegalStateException("departement with name " + departementName + " does not exist");
        }
        return departementOptional.get();
    }

    public List<Employe> getEmployeesByDepartementId(Long departementId) {
        return employeeClient.getEmployeesByDepartementId(departementId);
    }
}
