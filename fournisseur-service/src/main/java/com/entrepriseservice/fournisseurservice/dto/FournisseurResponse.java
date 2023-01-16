package com.entrepriseservice.fournisseurservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FournisseurResponse {
	private int ID ;
	private String nom ;
	private int numTel ;


}
