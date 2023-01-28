package com.promineo.PetDiet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineo.PetDiet.entity.Owner;
import com.promineo.PetDiet.service.OwnerService;

import lombok.extern.slf4j.Slf4j;




@RestController
@Slf4j
public class DefaultOwnerController implements OwnerController {

	@Autowired
	private OwnerService ownerService;
	
	//GET method: Get all owner information given owner ID
	@Override
	public List<Owner> fetchOwnerInfo(Long ownerId) {
		log.info("The fetchOwnerInfo method was called with ownerId={}",
    ownerId);
		return ownerService.fetchOwnerInfo(ownerId);
	}

	//POST method: create new Owner entry when given firstName, lastName, address, and Phone number 
	@Override
	public Optional<Owner> createOwner(String firstName, String lastName, String address, String phoneNo) {
		log.info("New owner was created with firstName={}, lastName={}, address={}, phoneNo={}",
				firstName, lastName, address, phoneNo);
		return ownerService.createOwner(firstName, lastName, address, phoneNo);
	}
	// PUT (UPDATE) method: update customer's contact information, given ownerId, last name, and new address, and Phone number 

	@Override
	public Optional<Owner> updateOwnerInformation(Long ownerId, String address, String phoneNo) {
		log.info("The updateOwnerInformation was called with ownerId={}, address={}, phoneNo={}", ownerId, address, phoneNo);
		return ownerService.updateOwnerInformation(ownerId, address, phoneNo);
	}
	
	
	//DELETE method: Delete owner from the system given unique owner ID
	@Override
	public Optional<Owner> deleteOwner(Long ownerId) {
		log.info("The fetchOwnerInfo method was called with ownerId={}",
			    ownerId);
		return ownerService.deleteOwner(ownerId);
	}

	

}
