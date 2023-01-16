package com.entreprisemanagement.clientservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.entreprisemanagement.clientservice.dto.ClientRequest;
import com.entreprisemanagement.clientservice.dto.ClientResponse;

import com.entreprisemanagement.clientservice.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
	private final ClientService clientService;
	public ClientController ( ClientService clientService) {
		this.clientService=clientService; 
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createClient(@RequestBody ClientRequest clientRequest) {
		clientService.createClient(clientRequest);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ClientResponse> getAllClient(){
		return clientService.getAllClients();
	}

	@PutMapping(path = "{clientId}")
    public void updateClient(
            @PathVariable("clientId") Long clientId,
            @RequestParam(required = false) String nom,String prenom){
        clientService.updateClient(clientId,nom,prenom);
    }

	@DeleteMapping (path = "{clientId}") 
	public void deleteClient(@PathVariable("clientId") Long clientId){
	   clientService.deleteClient(clientId);
    }

	@GetMapping(path = "{clientId}")
	public ClientResponse getClient(@PathVariable("clientId") Long clientId){
		return clientService.getClient(clientId);
	}
}
