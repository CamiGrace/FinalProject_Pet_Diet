package com.promineo.PetDiet.dao;

import java.util.List;
import java.util.Optional;

import com.promineo.PetDiet.entity.HairLength;
import com.promineo.PetDiet.entity.Pet;
import com.promineo.PetDiet.entity.PetSize;

public interface PetDao {

	
	//GET method (READ)
	List<Pet> fetchPetName(String breed);

	
	//POST method (CREATE)
	Optional<Pet> createPet(Long ownerId, String petName, String species, String breed, Long age, PetSize petSize,
			HairLength hairLength); 
		
	

}
