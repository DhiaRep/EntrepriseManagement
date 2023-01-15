package com.departementservice.departementservice.config;

import com.departementservice.departementservice.model.Departement;
import com.departementservice.departementservice.repository.DepartementRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration // To tell Spring that this is a configuration class and it is used to configure the database connection
public class DepartementConfig {

    @Bean
    CommandLineRunner commandLineRunner(DepartementRepo repository) {
        return args -> {
            //cannot resolve Departement(String, String)
            Departement departement = new Departement(
                    "IT",
                    "Departement 1 description"
            );
            Departement departement2 = new Departement(
                    "Chemistry",
                    "Departement 2 description"
            );

            repository.saveAll(List.of(departement, departement2)); // This is used to save the students in the database

        };
    }
}
