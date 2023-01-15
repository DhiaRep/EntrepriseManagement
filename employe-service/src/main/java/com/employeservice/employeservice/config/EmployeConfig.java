package com.employeservice.employeservice.config;

import com.employeservice.employeservice.model.Employe;
import com.employeservice.employeservice.repository.EmployeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class EmployeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeRepository repository) {
        return args -> {
            Employe employe1 = new Employe(
                    //public Employe(String nom, String prenom, int age, String cv)
                    "Employe 1 nom",
                    "Employe 1 prenom",
                    20,
                    "Employe 1 cv",
                    1L

            );
            Employe employe2 = new Employe(
                    "Employe 2 nom",
                    "Employe 2 prenom",
                    21,
                    "Employe 2 cv",
                    2L

            );
            repository.saveAll(List.of(employe1, employe2)); // This is used to save the students in the database

        };
    }
}
