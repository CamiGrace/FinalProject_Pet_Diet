package com.promineo.PetDiet.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Diet {

	private Long dietId;
	private String dietName;
	private Long ownerId;
	
	
	// Not sure how to add the time variable in here
}
