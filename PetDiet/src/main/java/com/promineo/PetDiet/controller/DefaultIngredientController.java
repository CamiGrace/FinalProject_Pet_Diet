package com.promineo.PetDiet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineo.PetDiet.entity.Ingredient;
import com.promineo.PetDiet.service.IngredientService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class DefaultIngredientController implements IngredientController {

	
	@Autowired
	private IngredientService ingredientService;

	
	//GET method: get all pertinent ingredient information when provided unique ingredient ID
	@Override
	public List<Ingredient> fetchIngredientInfo(Long dietId) {
		log.info("The fetchIngredientInfo method was called with dietId={}",
			    dietId);
					return ingredientService.fetchIngredientInfo(dietId);
	}

}
