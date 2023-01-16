package com.entreprisemanagement.clientservice.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.entreprisemanagement.clientservice.dto.ClientRequest;
import com.entreprisemanagement.clientservice.dto.ClientResponse;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import com.entreprisemanagement.clientservice.model.Client;
import com.entreprisemanagement.clientservice.repository.ClientRepository;

@Slf4j
@Service 
public class ClientService {
private final ClientRepository clientRepository;
	
	public ClientService ( ClientRepository clientRepository) {
		this.clientRepository=clientRepository; 
	}
	
	public void createClient(ClientRequest clientRequest) {
		
		Client client = Client.builder()
				.nom(clientRequest.getNom())
                .prenom(clientRequest.getPrenom())
                .build();
		
		clientRepository.save(client);
		log.info("client"+client.getCIN());
				
	}

	private ClientResponse mapToClientResponse(Client client) {
		return ClientResponse.builder()
				.CIN(client.getCIN())
				.nom(client.getNom())
				.prenom(client.getPrenom())
				.build();
	}
	
	@Transactional
    public void updateClient(Long clientId, String nom,String prenom) {
		Client client = clientRepository.findById(clientId).orElseThrow(() -> new IllegalStateException(
                "client with id " +clientId + " does not exist"
        ));
        if (nom != null && nom.length() > 0 && !client.getNom().equals(nom)) {
            client.setNom(nom);
			client.setPrenom(prenom);
        }
    }


	public List<ClientResponse> getAllClients() {

		List<Client> clients= clientRepository.findAll();
		return clients.stream().map(client -> mapToClientResponse(client)).toList();
	}


	public ClientResponse getClient(Long clientId) {// TODO Auto-generated method stub
		Client client = clientRepository.findById(clientId).orElseThrow(() -> new IllegalStateException(
				"client with id " +clientId + " does not exist"
		));
		return mapToClientResponse(client);
	}

	public void deleteClient(Long clientId) {
		boolean exists = clientRepository.existsById(clientId);
		if (!exists) {
			throw new IllegalStateException(
					"client with id " +clientId + " does not exist"
			);
		}
		clientRepository.deleteById(clientId);
	}

}
