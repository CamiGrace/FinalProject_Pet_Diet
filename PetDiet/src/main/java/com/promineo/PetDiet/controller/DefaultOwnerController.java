package com.promineo.PetDiet.controller;

import java.util.List;

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
	
	
	@Override
	public List<Owner> fetchOwnerInfo(Long ownerId) {
		log.info("The fetchOwnerInfo method was called with ownerId={}",
    ownerId);
		return ownerService.fetchOwnerInfo(ownerId);
	}

}
