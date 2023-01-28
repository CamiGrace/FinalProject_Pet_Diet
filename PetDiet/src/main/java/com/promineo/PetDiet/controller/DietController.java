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

import com.promineo.PetDiet.entity.Diet;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/diet")
@OpenAPIDefinition(info = @Info(title = "Diet Info Service"), servers = {
@Server(url = "http://localhost:8080", description = "Local server.")})
public interface DietController {

	
	
	
	// GET (Read) operation 
		//@formatter:off
			@Operation(
			
			summary = "Returns a list of Diet",
			description = "Returns the information for the Diet that corresponds with the unique diet ID",
			responses  = {
				@ApiResponse(
						responseCode = "200", 
						description = "A diet was found", 
						content = @Content(mediaType = "application/json", schema = @Schema(implementation = Diet.class))),
				@ApiResponse(
						responseCode = "400", 
						description = "The request parameters are invalid", 
						content = @Content(mediaType = "application/json")),
				@ApiResponse(
						responseCode = "404", 
						description = "No diets were found with the input criteria", 
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
						description = "unique diet ID (i.e., '1')"),
				
			}
			)
			
			@GetMapping
			@ResponseStatus(code =HttpStatus.OK)
			List <Diet> fetchDietInfo(
					@RequestParam(required = false)
					Long dietId);
	
	
			@Operation(
					
					summary = "Create new diet",
					description = "Create new diet using diet_name and prep_time",
					responses  = {
						@ApiResponse(
								responseCode = "200", 
								description = "A new diet has been created", 
								content = @Content(mediaType = "application/json", schema = @Schema(implementation = Diet.class))),
						@ApiResponse(
								responseCode = "400", 
								description = "The request parameters are invalid", 
								content = @Content(mediaType = "application/json")),
						@ApiResponse(
								responseCode = "404", 
								description = "Unable to create diet with the input criteria", 
								content = @Content(mediaType = "application/json")),
						@ApiResponse(
								responseCode = "500", 
								description = "An unplanned error occured.", 
								content = @Content(mediaType = "application/json"))
						
					},
					parameters = {
						@Parameter(
								name = "dietName", 
								allowEmptyValue = false, 
								required = false, 
								description = "The name of teh diet ID(i.e., 'Chicken Thigh Cat Diet')"),
						
						@Parameter(
								name = "prepTime", 
								allowEmptyValue = false, 
								required = false, 
								description = "The amount of time to prepare diet (i.e., '1 hour')"),
						
						
						
						
						
					}
					)
				// Post method (create)	
			  @PostMapping
			  @ResponseStatus(code = HttpStatus.CREATED)
			  Optional<Diet> createDiet(
				      @RequestParam(required = false)
				      String dietName,
				      @RequestParam(required = false)
				      String prepTime);
			
			
			
			
			//@formatter:on
		}

		
