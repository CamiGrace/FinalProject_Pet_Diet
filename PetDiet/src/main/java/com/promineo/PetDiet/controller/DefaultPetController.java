package com.promineo.PetDiet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineo.PetDiet.entity.Pet;
import com.promineo.PetDiet.service.PetService;

import lombok.extern.slf4j.Slf4j;






@RestController
@Slf4j
public class DefaultPetController implements PetController{

	@Autowired
	private PetService petService;
	
	@Override
	public List<Pet> fetchPetName(String breed) {
		 log.info("The fetchPetName method was called with breed={}",
			        breed);
			    
			    return petService.fetchPetName(breed);
	}

}
