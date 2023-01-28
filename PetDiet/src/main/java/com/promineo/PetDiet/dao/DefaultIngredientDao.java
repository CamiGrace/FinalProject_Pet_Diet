package com.promineo.PetDiet.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.promineo.PetDiet.entity.Ingredient;


import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultIngredientDao implements IngredientDao {

	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	 
	//GET method: get all pertinent ingredients and information when provided diet ID
	@Override
	public List<Ingredient> fetchIngredientInfo(Long dietId) {
		log.debug("DAO: dietId={}", dietId);
		
		//@formatter:off
				String sql = " "
					+ "SELECT * "
					+ "FROM ingredient "
					+ " WHERE diet_id = :diet_id";
				//@formatter:on
		
				Map<String, Object> params = new HashMap<>();
				params.put("diet_id", dietId);
				
			
				return jdbcTemplate.query( sql, params, 
						new RowMapper<>() {

							@Override
							public Ingredient mapRow(ResultSet rs, int rowNum) throws SQLException {
								//@formatter:off
								return Ingredient.builder()
										  .ingredientId(rs.getLong("ingredient_id"))
										  .dietId(rs.getLong("diet_id"))
										  .ingredientName(new String(rs.getString("ingredient_name")))
										  .amountRequired(new String(rs.getString("amount_required")))
										  .build();
								//@formatter:on
							}
					
				});
			}

	//POST method: create new ingredient given dietId, ingredient name and the amount required 
	@Override
	public Optional<Ingredient> createIngredient(Long dietId, String ingredientName, String amountRequired) {
		log.info("New ingredient was created with dietId={}, ingredientName={}, amountRequired={}", dietId, ingredientName, amountRequired);
		//@formatter:off
	    String sql = " "
	        + " INSERT INTO ingredient ("
	        + "diet_id, ingredient_name, amount_required "
	        + " ) VALUES ( "
	        +  ":diet_id, :ingredient_name, :amount_required)";
	    
	    //@formatter:on
	    
	    Map<String, Object> params = new HashMap<>();
	    params.put("diet_id", dietId);
	    params.put("ingredient_name", ingredientName);
	    params.put("amount_required", amountRequired);
	
	    
	    jdbcTemplate.update(sql, params);
	    return Optional.ofNullable(
	    		Ingredient.builder()
	    		.dietId(dietId)
	    		.ingredientName(ingredientName)
	    		.amountRequired(amountRequired)
	    		.build());
	        }
	
	
	
	
}
