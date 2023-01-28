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



import com.promineo.PetDiet.entity.PetDiet;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/petDiet")
@OpenAPIDefinition(info = @Info(title = "Pet Diet Service"), servers = {
@Server(url = "http://localhost:8080", description = "Local server.")})
public interface PetDietController {

	
	// GET method 
	//@formatter:off
	@Operation(
	
	summary = "Returns a list of pets",
	description = "Returns a list of pets IDs given dietID",
	responses  = {
		@ApiResponse(
				responseCode = "200", 
				description = "A list of pets is returned", 
				content = @Content(mediaType = "application/json", schema = @Schema(implementation = PetDiet.class))),
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
				name = "dietId", 
				allowEmptyValue = false, 
				required = false, 
				description = "Unique Diet ID  (i.e., '1')"),
		
	}
	)
	//POST method 
	@GetMapping
	@ResponseStatus(code =HttpStatus.OK)
	List <PetDiet> fetchAssignedPets(
			@RequestParam(required = false)
			Long dietId);
		
	
	@Operation(
			
			summary = "Create new pet/diet pairing",
			description = "Assign a new diet to a pet, using cooresponding IDs",
			responses  = {
				@ApiResponse(
						responseCode = "200", 
						description = "A new pet/diet pairing has been created", 
						content = @Content(mediaType = "application/json", schema = @Schema(implementation = PetDiet.class))),
				@ApiResponse(
						responseCode = "400", 
						description = "The request parameters are invalid", 
						content = @Content(mediaType = "application/json")),
				@ApiResponse(
						responseCode = "404", 
						description = "Unable to create pet/diet pairing with the input criteria", 
						content = @Content(mediaType = "application/json")),
				@ApiResponse(
						responseCode = "500", 
						description = "An unplanned error occured.", 
						content = @Content(mediaType = "application/json"))
				
			},
			parameters = {
				@Parameter(
						name = "dietId", 
						allowEmptyValue = false, 
						required = false, 
						description = "The unique diet ID(i.e., '5')"),
				
				@Parameter(
						name = "petId", 
						allowEmptyValue = false, 
						required = false, 
						description = "The unique pet ID (i.e., '2')"),
				
				
				
				
			}
			)
		// Post method (create)	
	  @PostMapping
	  @ResponseStatus(code = HttpStatus.CREATED)
	  Optional<PetDiet> assignPetNewDiet(
			  @RequestParam(required = false)
		      Long dietId, 
		      @RequestParam(required = false)
		      Long petId);
		    
	
	
	
	//@formatter:on
}


	

