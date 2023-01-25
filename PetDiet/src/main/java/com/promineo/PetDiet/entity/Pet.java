package com.promineo.PetDiet.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
	private Long petId;
	private Long ownerId;
	private String petName;
	private String species;
	private String breed;
	private Long age;
	private PetSize petSize;
	private HairLength hairLength;
	
}
