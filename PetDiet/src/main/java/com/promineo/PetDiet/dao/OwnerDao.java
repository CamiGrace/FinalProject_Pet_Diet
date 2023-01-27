package com.promineo.PetDiet.dao;

import java.util.List;

import com.promineo.PetDiet.entity.Owner;

public interface OwnerDao {

	
	//GET method (READ)
	List<Owner> fetchOwnerInfo(Long ownerId);



}
