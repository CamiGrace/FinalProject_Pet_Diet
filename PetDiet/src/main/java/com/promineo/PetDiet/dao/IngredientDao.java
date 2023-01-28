package com.promineo.PetDiet.dao;

import java.util.List;

import com.promineo.PetDiet.entity.Ingredient;

public interface IngredientDao {

	//GET method: get all pertinent ingredients and information when provided diet ID
	List<Ingredient> fetchIngredientInfo(Long dietId);

}
