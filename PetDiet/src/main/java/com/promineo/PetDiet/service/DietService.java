package com.promineo.PetDiet.service;

import java.util.List;
import java.util.Optional;

import com.promineo.PetDiet.entity.Diet;

public interface DietService {

	
	// GET (READ) method to fetch information (dietName and prepTime) when provided with unique DietId
	List<Diet> fetchDietInfo(Long dietId);

	
	//Post Method: create new diet given dietName and prepTime
	Optional<Diet> createDiet(String dietName, String prepTime);

}
