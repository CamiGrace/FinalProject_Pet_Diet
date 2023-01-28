package com.promineo.PetDiet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineo.PetDiet.entity.Diet;
import com.promineo.PetDiet.service.DietService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j

public class DefaultDietController implements DietController {

	
	@Autowired
	private DietService dietService;
	
	
	@Override
	public List<Diet> fetchDietInfo(Long dietId) {
		 log.info("The fetchDietInfo method was called with dietId={}",
	    dietId);
			return dietService.fetchDietInfo(dietId);
	}

}
