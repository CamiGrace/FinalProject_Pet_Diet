package com.promineo.PetDiet.service;

import java.util.List;

import com.promineo.PetDiet.entity.Pet;

public interface PetService {

	
	List <Pet> fetchPetName(String breed);
		
}
