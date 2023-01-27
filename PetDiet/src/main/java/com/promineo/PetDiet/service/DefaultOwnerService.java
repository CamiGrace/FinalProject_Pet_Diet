package com.promineo.PetDiet.service;

import java.util.List;

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
	
	//GET method (READ)
	@Transactional
	@Override
	public List<Owner> fetchOwnerInfo(Long ownerId) {
		log.info("The fetchOwnerInfo method was called with ownerId ={}", ownerId);
		List<Owner> owner = ownerDao.fetchOwnerInfo(ownerId);		
	
		return owner;
	}

}
