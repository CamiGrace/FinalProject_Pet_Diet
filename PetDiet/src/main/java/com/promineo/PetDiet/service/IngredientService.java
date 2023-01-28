package com.promineo.PetDiet.service;

import java.util.List;

import com.promineo.PetDiet.entity.Ingredient;

public interface IngredientService {

	
	//GET method: get all pertinent ingredient information when provided unique ingredient ID
	List<Ingredient> fetchIngredientInfo(Long dietId);

}
