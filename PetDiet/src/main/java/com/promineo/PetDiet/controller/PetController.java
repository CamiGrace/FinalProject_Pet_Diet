package com.promineo.PetDiet.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineo.PetDiet.entity.Pet;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;





@Validated
@RequestMapping("/pet")
@OpenAPIDefinition(info = @Info(title = "Pet Name Service"), servers = {
@Server(url = "http://localhost:8080", description = "Local server.")})



public interface PetController {

	//@formatter:off
		@Operation(
		
		summary = "Returns a list of pets",
		description = "Returns a list of pet names given breed",
		responses  = {
			@ApiResponse(
					responseCode = "200", 
					description = "A list of pets is returned", 
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pet.class))),
			@ApiResponse(
					responseCode = "400", 
					description = "The request parameters are invalid", 
					content = @Content(mediaType = "application/json")),
			@ApiResponse(
					responseCode = "404", 
					description = "No pets were found with the input criteria", 
					content = @Content(mediaType = "application/json")),
			@ApiResponse(
					responseCode = "500", 
					description = "An unplanned error occured.", 
					content = @Content(mediaType = "application/json"))
			
		},
		parameters = {
			@Parameter(
					name = "breed", 
					allowEmptyValue = false, 
					required = false, 
					description = "animal breed (i.e., 'Pomeranian')"),
			
		}
		)
		
		@GetMapping
		@ResponseStatus(code =HttpStatus.OK)
		List <Pet> fetchPetName(
				String breed);
			
		
		
		
		
		
		
		//@formatter:on
	}

	

