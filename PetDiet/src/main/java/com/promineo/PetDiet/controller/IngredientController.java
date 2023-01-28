package com.promineo.PetDiet.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineo.PetDiet.entity.Ingredient;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/ingredient")
@OpenAPIDefinition(info = @Info(title = "Ingredient Info Service"), servers = {
@Server(url = "http://localhost:8080", description = "Local server.")})

public interface IngredientController {
	
	// GET (Read) operation 
	//@formatter:off
		@Operation(
		
		summary = "Returns a list of ingredient",
		description = "Returns list of ingredient when given diet Id",
		responses  = {
			@ApiResponse(
					responseCode = "200", 
					description = "The ingredients were found", 
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = Ingredient.class))),
			@ApiResponse(
					responseCode = "400", 
					description = "The request parameters are invalid", 
					content = @Content(mediaType = "application/json")),
			@ApiResponse(
					responseCode = "404", 
					description = "No ingredients were found with the input criteria", 
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
					description = "unique diet ID (i.e., '4')"),
			
		}
		)
		
		@GetMapping
		@ResponseStatus(code =HttpStatus.OK)
		List <Ingredient> fetchIngredientInfo(
				@RequestParam(required = false)
				Long dietId);
			
}



