package com.employeservice.employeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeResponse {


	private Long id ;
	private String nom ;
	private String prenom ;
	private int age ;
	private String cv ;
	private Long departementId;


}
