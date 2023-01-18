package com.enterprisemanagement.enterpriseservice.service;

import com.enterprisemanagement.enterpriseservice.model.Enterprise;
import com.enterprisemanagement.enterpriseservice.repository.EnterpriseRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EnterpriseService {

    @Autowired
    private EnterpriseRepo enterpriseRepo;

    public EnterpriseService(EnterpriseRepo enterpriseRepo) {
        this.enterpriseRepo = enterpriseRepo;
    }


    public List<Enterprise> getAllEnterprises() {
    //get all enterprises
        return enterpriseRepo.findAll();
    }

    public void updateEnterprise(Enterprise enterprise) {
    //update enterprise
        enterpriseRepo.save(enterprise);
    }
}
