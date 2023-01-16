package com.entrepriseservice.fournisseurservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FournisseurRequest {
	
	private String nom ;
	private int numTel;


}
