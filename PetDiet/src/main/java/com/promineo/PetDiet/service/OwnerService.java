package com.promineo.PetDiet.service;

import java.util.List;

import com.promineo.PetDiet.entity.Owner;

public interface OwnerService {

	
	//GET method (READ)
	List<Owner> fetchOwnerInfo(Long ownerId);

}
