package com.promineo.PetDiet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;


import com.promineo.PetDiet.entity.Owner;



import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;



// Controller interface sets up information and hands if off to the default controller class 
@Validated
	@RequestMapping("/owner")
	@OpenAPIDefinition(info = @Info(title = "Owner Info Service"), servers = {
	@Server(url = "http://localhost:8080", description = "Local server.")})

public interface OwnerController {

	
	
	// GET (Read) operation 
		//@formatter:off
			@Operation(
			
			summary = "Returns a list of owner",
			description = "Returns the information for the owner that corresponds with the unique owner ID",
			responses  = {
				@ApiResponse(
						responseCode = "200", 
						description = "The owner was found", 
						content = @Content(mediaType = "application/json", schema = @Schema(implementation = Owner.class))),
				@ApiResponse(
						responseCode = "400", 
						description = "The request parameters are invalid", 
						content = @Content(mediaType = "application/json")),
				@ApiResponse(
						responseCode = "404", 
						description = "No owners were found with the input criteria", 
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
						description = "unique owner ID (i.e., '4')"),
				
			}
			)
			
			@GetMapping
			@ResponseStatus(code =HttpStatus.OK)
			List <Owner> fetchOwnerInfo(
					@RequestParam(required = false)
					Long ownerId);
				

@Operation(
		
		summary = "Create new owner",
		description = "Create new owner using, firstName, lastName, address, and phone number",
		responses  = {
			@ApiResponse(
					responseCode = "200", 
					description = "A new owner has been created", 
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = Owner.class))),
			@ApiResponse(
					responseCode = "400", 
					description = "The request parameters are invalid", 
					content = @Content(mediaType = "application/json")),
			@ApiResponse(
					responseCode = "404", 
					description = "Unable to create owner with the input criteria", 
					content = @Content(mediaType = "application/json")),
			@ApiResponse(
					responseCode = "500", 
					description = "An unplanned error occured.", 
					content = @Content(mediaType = "application/json"))
			
		},
		parameters = {
			
			
			@Parameter(
					name = "firstName", 
					allowEmptyValue = false, 
					required = false, 
					description = "The first name of the owner (i.e., 'Sara')"),
			
			@Parameter(
					name = "lastName", 
					allowEmptyValue = false, 
					required = false, 
					description = "The last name of the owner (i.e., 'Rigby')"),
			
			@Parameter(
					name = "address", 
					allowEmptyValue = false, 
					required = false, 
					description = "The home address of owner(i.e., '252 Cloverdale')"),
			
			@Parameter(
					name = "phoneNo", 
					allowEmptyValue = false, 
					required = false, 
					description = "The phone number of the owner(i.e., '15647894652')"),
		
			
			
			
			
		}
		)
	// Post method (create)	
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Optional<Owner> createOwner(
	      @RequestParam(required = false)
	      String firstName,
	      @RequestParam(required = false)
	      String lastName, 
	      @RequestParam(required = false)
	      String address, 
	      @RequestParam(required = false)
	      String phoneNo);
	


@Operation(
	      summary = "Updates owner information",
	      description = "Update owner information using, firstName, lastName, address, and phone number",
	      responses = {
	          @ApiResponse(
	              responseCode = "200", 
	              description = "Owner has been updated", 
	              content = @Content(
	                  mediaType = "application/json", 
	              schema = @Schema(implementation = Owner.class))),
	          @ApiResponse(
	              responseCode = "400", 
	              description = "The request parameters are invalid.", 
	              content = @Content(
	                  mediaType = "application/json")),
	          @ApiResponse(
	              responseCode = "404", 
	              description = "Unable to update owner infomation with the input criteria.", 
	              content = @Content(
	                  mediaType = "application/json")),
	          @ApiResponse(
	              responseCode = "500", 
	              description = "An unplanned error occurred.", 
	              content = @Content(
	                  mediaType = "application/json"))
	      },
			parameters = {
				
				
				@Parameter(
					    name = "ownerId", 
					    allowEmptyValue = false, 
					    required = false, 
					    description = "The unique owner ID (i.e., '1')"), 
					       
				@Parameter(
						name = "firstName", 
						allowEmptyValue = false, 
						required = false, 
						description = "The first name of the owner(i.e., 'Olivia')"),
				
				@Parameter(
						name = "lastName", 
						allowEmptyValue = false, 
						required = false, 
						description = "The last name of the owner(i.e., 'Dickens')"),
				
				
				@Parameter(
						name = "address", 
						allowEmptyValue = false, 
						required = false, 
						description = "The home address of owner(i.e., '252 Cloverdale')"),
				
				@Parameter(
						name = "phoneNo", 
						allowEmptyValue = false, 
						required = false, 
						description = "The phone number of the owner(i.e., '15647894652')"),
			
			
	      }
	  )
	  


	  // PUT  (UPDATE )method: 	update owner information 
	 @PutMapping
	 @ResponseStatus(code = HttpStatus.OK)
	 Optional<Owner> updateOwnerInformation(
			 @RequestParam(required = false)
		      Long ownerId,
		      @RequestParam(required = false)
		      String firstName, 
		      @RequestParam(required = false)
		      String lastName, 
		      @RequestParam(required = false)
		      String address, 
		      @RequestParam(required = false)
		      String phoneNo);
		     

	  
	// Delete method: delete owner information 
	 @Operation(
	     summary = "Deletes an Owner",
	     description = "Delete an owner given the unique owner ID",
	     responses = {
	         @ApiResponse(
	             responseCode = "200", 
	             description = "The Owner has been deleted from the system.", 
	             content = @Content(
	                 mediaType = "application/json", 
	             schema = @Schema(implementation = Owner.class))),
	         @ApiResponse(
	             responseCode = "400", 
	             description = "The request parameters are invalid.", 
	             content = @Content(
	                 mediaType = "application/json")),
	         @ApiResponse(
	             responseCode = "404", 
	             description = "No owners were found with the input criteria.", 
	             content = @Content(
	                 mediaType = "application/json")),
	         @ApiResponse(
	             responseCode = "500", 
	             description = "An unplanned error occurred.", 
	             content = @Content(
	                 mediaType = "application/json"))
	     },
	     parameters = {
	         @Parameter(
	             name = "ownerId", 
	             allowEmptyValue = false, 
	             required = false, 
	             description = "The unique owner ID (i.e., '1')"), 
	       
	     }
	 )
	  // Delete method (Delete)
	  @DeleteMapping
	  @ResponseStatus(code = HttpStatus.OK)
	  Optional<Owner> deleteOwner(
	      @RequestParam(required = false) 
	      Long ownerId);
	  
	  //@formatter:on
	}