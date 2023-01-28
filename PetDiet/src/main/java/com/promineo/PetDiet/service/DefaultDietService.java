package com.promineo.PetDiet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineo.PetDiet.dao.DietDao;
import com.promineo.PetDiet.entity.Diet;


import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class DefaultDietService implements DietService {

	
	@Autowired
	private DietDao dietDao;
	
	// GET (READ) method to fetch information (dietName and prepTime) when provided with unique DietId
	@Override
	public List<Diet> fetchDietInfo(Long dietId) {
		log.info("The fetchDietInfo method was called with dietId ={}", dietId);
		List<Diet> diets = dietDao.fetchDietInfo(dietId);		
	
		return diets;
	}
	//Post Method: create new diet given dietName and prepTime
	@Override
	public Optional<Diet> createDiet(String dietName, String prepTime) {
			log.info("New diet was created with dietName={}, prepTime={}",
				dietName, prepTime);
		return dietDao.createDiet(dietName, prepTime);
	}

}
