package com.promineo.PetDiet.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineo.PetDiet.dao.PetDao;
import com.promineo.PetDiet.entity.Pet;


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
		log.info("The fetPetName method was called with breed ={}", breed);
		
	
		return petDao.fetchPetName(breed);
	}

}
