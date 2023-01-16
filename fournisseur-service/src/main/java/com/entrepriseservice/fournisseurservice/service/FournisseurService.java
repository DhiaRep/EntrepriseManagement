package com.entrepriseservice.fournisseurservice.service;


import com.entrepriseservice.fournisseurservice.Repository.FournisseurRepository;
import com.entrepriseservice.fournisseurservice.dto.FournisseurRequest;
import com.entrepriseservice.fournisseurservice.dto.FournisseurResponse;
import com.entrepriseservice.fournisseurservice.model.Fournisseur;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class FournisseurService {
private final FournisseurRepository fournisseurRepository;
	
	public FournisseurService ( FournisseurRepository fournisseurRepository) {
		this.fournisseurRepository=fournisseurRepository; 
	}
	
	public void createFournisseur(FournisseurRequest fournisseurRequest) {
		Fournisseur fournisseur = Fournisseur.builder()
				.nom(fournisseurRequest.getNom())
                .numTel(fournisseurRequest.getNumTel())
                .build();
		
		fournisseurRepository.save(fournisseur);
		log.info("fournisseur"+fournisseur.getID());
				
	}

	private FournisseurResponse mapToFournisseurResponse(Fournisseur fournisseur) {
		return FournisseurResponse.builder()
				.ID(fournisseur.getID())
				.nom(fournisseur.getNom())
				.numTel(fournisseur.getNumTel())
				.build();
	}
	
	@Transactional
    public void updateFournisseur(int fournisseurId, String nom) {
		Fournisseur fournisseur = fournisseurRepository.findById(fournisseurId).orElseThrow(() -> new IllegalStateException(
                "fournisseur with id " +fournisseurId + " does not exist"
        ));
        if (nom != null && nom.length() > 0 && !fournisseur.getNom().equals(nom)) {
            fournisseur.setNom(nom);
        }
    }
	
	
	
	public void deleteFournisseur(int fournisseurId){
        
        boolean idExist = fournisseurRepository.existsById(fournisseurId);
        if (!idExist){
            throw new IllegalStateException("departement with id " + fournisseurId + " does not exist");
        }
        fournisseurRepository.deleteById(fournisseurId);
    }

    public List<FournisseurResponse> getAllFournisseur() {
		List<Fournisseur> fournisseurs = fournisseurRepository.findAll();
		return fournisseurs.stream().map(fournisseur -> mapToFournisseurResponse(fournisseur)).toList();
	}
}
