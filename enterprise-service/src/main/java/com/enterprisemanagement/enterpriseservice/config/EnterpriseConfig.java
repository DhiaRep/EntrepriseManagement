package com.enterprisemanagement.enterpriseservice.config;

import com.enterprisemanagement.enterpriseservice.model.Enterprise;
import com.enterprisemanagement.enterpriseservice.repository.EnterpriseRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // To tell Spring that this is a configuration class and it is used to configure the database connection
public class EnterpriseConfig {

    @Bean
    CommandLineRunner commandLineRunner(EnterpriseRepo repository) {
        return args -> {
            Enterprise enterprise1 = new Enterprise(
                    "enterprise name",
                    "description",
                    "address",
                    "email",
                    "phone",
                    "website"
            );
            repository.save(enterprise1);
        };
    }
}
