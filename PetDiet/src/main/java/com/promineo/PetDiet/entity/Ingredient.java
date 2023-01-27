package com.promineo.PetDiet.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
	
	private Long ingredientId;
	private Long dietId;
	private String ingredientName;
	private String amountRequired;
}
