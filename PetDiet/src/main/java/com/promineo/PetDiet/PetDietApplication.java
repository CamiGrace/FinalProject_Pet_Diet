package com.promineo.PetDiet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.promineotech.ComponentScanMarker;


//Swagger URL
// http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/

@SpringBootApplication (scanBasePackageClasses = { ComponentScanMarker.class})
public class PetDietApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetDietApplication.class, args);
	}

}
