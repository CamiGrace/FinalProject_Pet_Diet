package com.promineo.PetDiet.dao;

import java.util.List;

import com.promineo.PetDiet.entity.Pet;

public interface PetDao {

	List<Pet> fetchPetName(String breed); 
		
	

}
