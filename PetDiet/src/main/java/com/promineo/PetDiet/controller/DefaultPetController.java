package com.promineo.PetDiet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineo.PetDiet.entity.HairLength;
import com.promineo.PetDiet.entity.Pet;
import com.promineo.PetDiet.entity.PetSize;
import com.promineo.PetDiet.service.PetService;

import lombok.extern.slf4j.Slf4j;






@RestController
@Slf4j
public class DefaultPetController implements PetController{

	@Autowired
	private PetService petService;
	
	
	//Get Method (Read)
	@Override
	public List<Pet> fetchPetName(String breed) {
		 log.info("The fetchPetName method was called with breed={}",
			        breed);
			    
			    return petService.fetchPetName(breed);
	}
	//Post Method (create)
	@Override
	public Optional<Pet> createPet(Long ownerId, String petName, String species, String breed, Long age,
			PetSize petSize, HairLength hairLength) {
			log.info("New pet was created with ownerId={}, petName={}, species={}, breed={}, age={}, petSize={}, hairLength={}",
						ownerId, petName, species, breed, age, petSize, hairLength);
		
		return petService.createPet( ownerId,  petName,  species,  breed,  age,
				 petSize,  hairLength);
	}

}
