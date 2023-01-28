package com.promineo.PetDiet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineo.PetDiet.dao.OwnerDao;
import com.promineo.PetDiet.entity.Owner;


import lombok.extern.slf4j.Slf4j;




@Service
@Slf4j
public class DefaultOwnerService implements OwnerService {

	@Autowired
	private OwnerDao ownerDao;
	
	//GET (READ) method to pull all owner information using unique owner ID
	@Transactional
	@Override
	public List<Owner> fetchOwnerInfo(Long ownerId) {
		log.info("The fetchOwnerInfo method was called with ownerId ={}", ownerId);
		List<Owner> owner = ownerDao.fetchOwnerInfo(ownerId);		
	
		return owner;
	}


	//POST (CREATE) method: create new Owner entry when given firstName, lastName, address, and Phone number 
	@Override
	public Optional<Owner> createOwner(String firstName, String lastName, String address, String phoneNo) {
		log.info("New owner was created with firstName={}, lastName={}, address={}, phoneNo={}",
				firstName, lastName, address, phoneNo);
		return ownerDao.createOwner(firstName, lastName, address, phoneNo);
	}

	// PUT (UPDATE) method: update customer information, given name, address, and Phone number 
	@Override
	public Optional<Owner> updateOwnerInformation(Long ownerId, String address, String phoneNo) {
		log.info("Owner informationw as updated with ownerId={}, address={}, phoneNo={}",
				ownerId, address, phoneNo);
		return ownerDao.updateOwnerInformation (ownerId, address, phoneNo);
	}

	//DELETE method: Delete owner from the system given unique owner ID
	@Override
	public Optional<Owner> deleteOwner(Long ownerId) {
		log.info("The fetchOwnerInfo method was called with ownerId={}",
			    ownerId);
		return ownerDao.deleteOwner(ownerId);
	
	}

}
