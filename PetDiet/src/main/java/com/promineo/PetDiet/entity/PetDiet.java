package com.promineo.PetDiet.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor

public class PetDiet {

	
		private Long dietId;
		private Long petId;
		
}
