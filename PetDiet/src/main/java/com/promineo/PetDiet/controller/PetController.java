package com.promineo.PetDiet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineo.PetDiet.entity.HairLength;
import com.promineo.PetDiet.entity.Pet;
import com.promineo.PetDiet.entity.PetSize;

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
				@RequestParam(required = false)
				String breed);
			
		
		@Operation(
				
				summary = "Create new pet",
				description = "Create new pet using ownerId, petName, species, breed, age, petSize, and hairLength",
				responses  = {
					@ApiResponse(
							responseCode = "200", 
							description = "A new pet has been created", 
							content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pet.class))),
					@ApiResponse(
							responseCode = "400", 
							description = "The request parameters are invalid", 
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404", 
							description = "Unable to create pet with the input criteria", 
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "500", 
							description = "An unplanned error occured.", 
							content = @Content(mediaType = "application/json"))
					
				},
				parameters = {
					@Parameter(
							name = "ownerId", 
							allowEmptyValue = false, 
							required = false, 
							description = "The owner ID(i.e., '5')"),
					
					@Parameter(
							name = "petName", 
							allowEmptyValue = false, 
							required = false, 
							description = "The name of the Pet (i.e., 'Sparkles')"),
					
					@Parameter(
							name = "species", 
							allowEmptyValue = false, 
							required = false, 
							description = "The species of the pet (i.e., 'cat')"),
					
					@Parameter(
							name = "breed", 
							allowEmptyValue = false, 
							required = false, 
							description = "The specific breed within the given species ID(i.e., 'Siamese')"),
					
					@Parameter(
							name = "age", 
							allowEmptyValue = false, 
							required = false, 
							description = "The age of the pet in years(i.e., '4')"),
				
					@Parameter(
							name = "petSize", 
							allowEmptyValue = false, 
							required = false, 
							description = "The size of the pet(i.e., 'SMALL')"),
				
					@Parameter(
							name = "hairLength", 
							allowEmptyValue = false, 
							required = false, 
							description = "The length of the pet's hair(i.e., 'LONG')"),
					
					
					
					
				}
				)
			// Post method (create)	
		  @PostMapping
		  @ResponseStatus(code = HttpStatus.CREATED)
		  Optional<Pet> createPet(
				  @RequestParam(required = false)
			      Long ownerId, 
			      @RequestParam(required = false)
			      String petName,
			      @RequestParam(required = false)
			      String species, 
			      @RequestParam(required = false)
			      String breed, 
			      @RequestParam(required = false)
			      Long age,
			      @RequestParam(required = false)
			      PetSize petSize, 
			      @RequestParam(required = false)
			      HairLength hairLength);
		
		
		
		
		//@formatter:on
	}

	

