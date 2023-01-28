package com.promineo.PetDiet.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	}
