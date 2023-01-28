package com.promineo.PetDiet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineo.PetDiet.dao.PetDietDao;

import com.promineo.PetDiet.entity.PetDiet;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class DefaultPetDietService implements PetDietService {

	
	@Autowired
	private PetDietDao petDietDao;
	
	@Override
	public List<PetDiet> fetchAssignedPets(Long dietId) {
		log.info("The fetchAssignedPets method was called with dietId ={}", dietId);
		List<PetDiet> petDiets = petDietDao.fetchAssignedPets(dietId);		
	
		return petDiets;
	}

	@Override
	public Optional<PetDiet> assignPetNewDiet(Long dietId, Long petId) {
		log.info("New pet/diet pair was created with dietId={}, petId={}",
				dietId, petId);
		return petDietDao.assignPetNewDiet(dietId, petId);
	}

}
