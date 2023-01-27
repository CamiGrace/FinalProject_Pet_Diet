package com.promineo.PetDiet.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Owner {

	private Long ownerId;
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNo;
}
