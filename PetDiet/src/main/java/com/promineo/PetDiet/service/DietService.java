package com.promineo.PetDiet.service;

import java.util.List;

import com.promineo.PetDiet.entity.Diet;

public interface DietService {

	
	// GET (READ) method to fetch information (dietName and prepTime) when provided with unique DietId
	List<Diet> fetchDietInfo(Long dietId);

}
