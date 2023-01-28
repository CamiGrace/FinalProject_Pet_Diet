package com.promineo.PetDiet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineo.PetDiet.dao.IngredientDao;
import com.promineo.PetDiet.entity.Ingredient;


import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class DefaultIngredientService implements IngredientService {

	@Autowired
	private IngredientDao ingredientDao;
	
	//GET method: return all ingredients that correspond to the diet Id
	@Override
	public List<Ingredient> fetchIngredientInfo(Long dietId) {
		log.info("The fetchIngredientInfo method was called with dietId ={}", dietId);
		List<Ingredient> ingredients = ingredientDao.fetchIngredientInfo(dietId);		
	
		return ingredients;
	
	}
	//POST method: create new ingredient given dietId, ingredient name and the amount required 
	@Override
	public Optional<Ingredient> createIngredient(Long dietId, String ingredientName, String amountRequired) {
		log.info("New ingredient was created with dietId={}, ingredientName={}, amountRequired={}", dietId, ingredientName, amountRequired);
		
		return ingredientDao.createIngredient(dietId, ingredientName, amountRequired);
	}

}
