package com.promineo.PetDiet.service;

import java.util.List;
import java.util.Optional;

import com.promineo.PetDiet.entity.Ingredient;

public interface IngredientService {

	
	//GET method: get all pertinent ingredient information when provided unique ingredient ID
	List<Ingredient> fetchIngredientInfo(Long dietId);

	
	//POST method: create new ingredient given dietId, ingredient name and the amount required 
	Optional<Ingredient> createIngredient(Long dietId, String ingredientName, String amountRequired);

}
