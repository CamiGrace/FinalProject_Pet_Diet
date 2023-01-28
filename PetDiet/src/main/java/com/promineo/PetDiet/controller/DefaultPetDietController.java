package com.promineo.PetDiet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineo.PetDiet.entity.PetDiet;
import com.promineo.PetDiet.service.PetDietService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j

public class DefaultPetDietController implements PetDietController {

	
	@Autowired
	private PetDietService petDietService;
	
	//GET method 
	@Override
	public List<PetDiet> fetchAssignedPets(Long dietId) {
		 log.info("The fetchAssignedPets method was called with dietId={}",
			        dietId);
		return petDietService.fetchAssignedPets(dietId);
	}
	//POST method
	@Override
	public Optional<PetDiet> assignPetNewDiet(Long dietId, Long petId) {
		 log.info("The assignPetsNewDiet method was called with dietId={}, petId={}",
			        dietId, petId);
		return petDietService.assignPetNewDiet(dietId, petId);
	}

}
