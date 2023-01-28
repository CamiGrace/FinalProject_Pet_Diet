package com.promineo.PetDiet.service;

import java.util.List;

import com.promineo.PetDiet.entity.Owner;

public interface OwnerService {

	
	//GET (READ) method to pull all owner information using unique owner ID
	List<Owner> fetchOwnerInfo(Long ownerId);

}
