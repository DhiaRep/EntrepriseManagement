package com.employeservice.employeservice.EmployeService;

import com.employeservice.employeservice.dto.EmployeRequest;
import com.employeservice.employeservice.dto.EmployeResponse;
import com.employeservice.employeservice.model.Employe;
import com.employeservice.employeservice.repository.EmployeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j

public class EmployeService {
    @Autowired
    private final EmployeRepository employeRepository;
    public EmployeService ( EmployeRepository employeRepository) {
            this.employeRepository=employeRepository;
        }

        public void createEmploye(EmployeRequest employeRequest) {

            Employe employe = Employe.builder()
                    .nom(employeRequest.getNom())
                    .prenom(employeRequest.getPrenom())
                    .age(employeRequest.getAge())
                    .cv(employeRequest.getCv())
                    .departementId(employeRequest.getDepartementId())
                    .build();

            employeRepository.save(employe);
            log.info("employe"+employe.getId());

        }

        public List<EmployeResponse> gettAllEmployes() {
            List<Employe> employes= employeRepository.findAll();
            return employes.stream().map(employe -> mapToEmployeResponse(employe)).toList();
        }

        private EmployeResponse mapToEmployeResponse(Employe employe) {
            return EmployeResponse.builder()
                    .id(employe.getId())
                    .nom(employe.getNom())
                    .prenom(employe.getPrenom())
                    .age(employe.getAge())
                    .cv(employe.getCv())
                    .departementId(employe.getDepartementId())
                    .build();
        }


        public void updateEmploye(Long id, EmployeRequest employeRequest) {
            Employe employe = employeRepository.findById(id).orElseThrow(() -> new IllegalStateException("employe with id" + id + "does not exist"));
            employe.setNom(employeRequest.getNom());
            employe.setPrenom(employeRequest.getPrenom());
            employe.setAge(employeRequest.getAge());
            employe.setCv(employeRequest.getCv());
            employeRepository.save(employe);
        }


    public void deleteEmploye(Long id) {
        boolean exist = employeRepository.existsById(id);
        if (!exist) {
            throw new IllegalStateException("employe with id" + id + "does not exist");
        }
        employeRepository.deleteById(id);
    }

    public EmployeResponse getEmploye(Long id) {
        Employe employe = employeRepository.findById(id).orElseThrow(() -> new IllegalStateException("employe with id" + id + "does not exist"));
        return mapToEmployeResponse(employe);
    }

    public List<Employe> getEmployeesByDepartementId(Long departmentId) {
        return employeRepository.findByDepartementId(departmentId);
    }
}
