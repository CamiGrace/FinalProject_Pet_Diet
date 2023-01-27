package com.promineo.PetDiet.service;

import java.util.List;
import java.util.Optional;

import com.promineo.PetDiet.entity.HairLength;
import com.promineo.PetDiet.entity.Pet;
import com.promineo.PetDiet.entity.PetSize;

public interface PetService {

	//GET Method (READ)
	List <Pet> fetchPetName(String breed);

	
	// PUT Method (CREATE)
	Optional<Pet> createPet(Long ownerId, String petName, String species, String breed, Long age, PetSize petSize,
			HairLength hairLength);
		
}
