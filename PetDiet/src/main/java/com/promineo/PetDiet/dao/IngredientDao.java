package com.promineo.PetDiet.dao;

import java.util.List;
import java.util.Optional;

import com.promineo.PetDiet.entity.Ingredient;

public interface IngredientDao {

	//GET method: get all pertinent ingredients and information when provided diet ID
	List<Ingredient> fetchIngredientInfo(Long dietId);

	
	//POST method: create new ingredient given dietId, ingredient name and the amount required 
	Optional<Ingredient> createIngredient(Long dietId, String ingredientName, String amountRequired);

}
