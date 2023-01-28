package com.promineo.PetDiet.dao;

import java.util.List;
import java.util.Optional;

import com.promineo.PetDiet.entity.Owner;

public interface OwnerDao {

	
	//GET (READ) method to pull all owner information using unique owner ID
	List<Owner> fetchOwnerInfo(Long ownerId);

	//POST (CREATE) method: create new Owner entry when given firstName, lastName, address, and Phone number 
	Optional<Owner> createOwner(String firstName, String lastName, String address, String phoneNo);
	
	// PUT (UPDATE) method: update customer information, given name, address, and Phone number 
	Optional<Owner> updateOwnerInformation(Long ownerId, String address, String phoneNo);

	//DELETE method: Delete owner from the system given unique owner ID
	Optional<Owner> deleteOwner(Long ownerId);



}
