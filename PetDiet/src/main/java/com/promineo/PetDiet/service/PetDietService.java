package com.promineo.PetDiet.service;

import java.util.List;
import java.util.Optional;

import com.promineo.PetDiet.entity.PetDiet;

public interface PetDietService {

	
	//GET method
	List<PetDiet> fetchAssignedPets(Long dietId);
	
	//POST method
	Optional<PetDiet> assignPetNewDiet(Long dietId, Long petId);
}
