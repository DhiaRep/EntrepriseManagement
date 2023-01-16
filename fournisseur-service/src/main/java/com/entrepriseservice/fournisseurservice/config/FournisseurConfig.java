package com.entrepriseservice.fournisseurservice.config;

import com.entrepriseservice.fournisseurservice.Repository.FournisseurRepository;
import com.entrepriseservice.fournisseurservice.model.Fournisseur;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FournisseurConfig {
    @Bean
    CommandLineRunner commandLineRunner(FournisseurRepository fournisseurRepository) {
        return args -> {
            Fournisseur fournisseur1 = new Fournisseur(
                    "Fournisseur 1 nom",
                    27095882
            );
            Fournisseur fournisseur2 = new Fournisseur(
                    "Fournisseur 2 nom",
                    27095666
            );

            fournisseurRepository.saveAll(List.of(fournisseur1, fournisseur1)); // This is used to save the students in the database

        };
    }

}
