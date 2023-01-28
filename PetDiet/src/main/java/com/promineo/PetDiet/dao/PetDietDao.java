package com.promineo.PetDiet.dao;

import java.util.List;
import java.util.Optional;

import com.promineo.PetDiet.entity.PetDiet;

public interface PetDietDao {

	List<PetDiet> fetchAssignedPets(Long dietId);

	Optional<PetDiet> assignPetNewDiet(Long dietId, Long petId);

	

}
