package com.enterprisemanagement.enterpriseservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class EnterpriseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnterpriseServiceApplication.class, args);
	}

}
