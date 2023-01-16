package com.entrepriseservice.fournisseurservice.controller;

import com.entrepriseservice.fournisseurservice.dto.FournisseurRequest;
import com.entrepriseservice.fournisseurservice.dto.FournisseurResponse;
import com.entrepriseservice.fournisseurservice.service.FournisseurService;
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

import java.util.List;

@RestController
@RequestMapping("/fournisseur")
public class FournisseurController {
	private final FournisseurService fournisseurService;
	public FournisseurController ( FournisseurService fournisseurService) {
		this.fournisseurService=fournisseurService; 
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createFournisseur(@RequestBody FournisseurRequest fournisseurRequest) {
		fournisseurService.createFournisseur(fournisseurRequest);
	}

	@PutMapping(path = "{fournisseurId}")
    public void updateFournisseur(
            @PathVariable("fournisseurId") int fournisseurId,
            @RequestParam(required = false) String nom){
        fournisseurService.updateFournisseur(fournisseurId,nom);
    }

	@DeleteMapping (path = "{fournisseurId}") 
    public void deleteFournisseur(@PathVariable("fournisseurId") int fournisseurId){
       fournisseurService.deleteFournisseur(fournisseurId);
    }
	//get all fournisseur
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<FournisseurResponse> getAllFournisseur(){
		return fournisseurService.getAllFournisseur();
	}

}
