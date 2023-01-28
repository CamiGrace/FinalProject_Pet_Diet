package com.promineo.PetDiet.dao;

import java.util.List;

import com.promineo.PetDiet.entity.Diet;

public interface DietDao {

	List<Diet> fetchDietInfo(Long dietId);



}
