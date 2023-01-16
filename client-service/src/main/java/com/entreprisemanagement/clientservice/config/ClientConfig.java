package com.entreprisemanagement.clientservice.config;

import com.entreprisemanagement.clientservice.model.Client;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.entreprisemanagement.clientservice.repository.ClientRepository;

import java.util.List;

@Configuration
public class ClientConfig {

    @Bean
    CommandLineRunner commandLineRunner(ClientRepository clientRepository) {
        return args -> {
            Client client1 = new Client(
                    "Client 1 nom",
                    "Client 1 prenom"
            );
            Client client2 = new Client(
                    "Client 2 nom",
                    "Client 2 prenom"
            );


            clientRepository.saveAll(List.of(client1, client2)); // This is used to save the clients in the database on startup

        };
    }
}
