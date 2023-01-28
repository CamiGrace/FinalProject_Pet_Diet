package com.promineo.PetDiet.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineo.PetDiet.dao.PetDao;
import com.promineo.PetDiet.entity.HairLength;
import com.promineo.PetDiet.entity.Pet;
import com.promineo.PetDiet.entity.PetSize;

import lombok.extern.slf4j.Slf4j;




@Service
@Slf4j
public class DefaultPetService implements PetService {

	
	@Autowired
	private PetDao petDao;
	
	//Get (read) all pets of provided breed 
	@Transactional
	@Override
	public List<Pet> fetchPetName(String breed) {
		log.info("The fetchPetName method was called with breed ={}", breed);
		List<Pet> pets = petDao.fetchPetName(breed);		
	
		return pets;
	}
	//POST (create): create new pet entry given ownerID, petName, species, breed, and age 
	@Override
	public Optional<Pet> createPet(Long ownerId, String petName, String species, String breed, Long age,
			PetSize petSize, HairLength hairLength) {
			log.info("New pet was created with ownerId={}, petName={}, species={}, breed={}, age={}, petSize={}, hairLength={}",
				ownerId, petName, species, breed, age, petSize, hairLength);
		return petDao.createPet(ownerId, petName, species, breed, age, petSize, hairLength);
	}

}
