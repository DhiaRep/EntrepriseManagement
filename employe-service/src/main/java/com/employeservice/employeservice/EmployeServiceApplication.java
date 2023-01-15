package com.employeservice.employeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class EmployeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeServiceApplication.class, args);
	}

}
