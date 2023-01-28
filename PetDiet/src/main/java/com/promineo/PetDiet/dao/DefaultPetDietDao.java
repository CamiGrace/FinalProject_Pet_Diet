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


import com.promineo.PetDiet.entity.PetDiet;


import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class DefaultPetDietDao implements PetDietDao {

	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<PetDiet> fetchAssignedPets(Long dietId) {
		log.debug("DAO: dietId={}", dietId);
		
		//@formatter:off
				String sql = " "
					+ "SELECT * "
					+ "FROM pet_diet "
					+ " WHERE diet_id = :diet_id";
				//@formatter:on
		
				Map<String, Object> params = new HashMap<>();
				params.put("diet_id", dietId);
				
			
				return jdbcTemplate.query( sql, params, 
						new RowMapper<>() {

							@Override
							public PetDiet mapRow(ResultSet rs, int rowNum) throws SQLException {
								//@formatter:off
								return PetDiet.builder()
										.dietId(rs.getLong("diet_id"))  
										.petId(rs.getLong("pet_id"))
										.build();
								//@formatter:on
							}
					
				});
			}

	@Override
	public Optional<PetDiet> assignPetNewDiet(Long dietId, Long petId) {
		log.info("DAO: dietId={}, petId={}",
				 dietId, petId);
	
		   
		    //@formatter:off
		    String sql = " "
		        + " INSERT INTO pet_diet ("
		        + "diet_id, pet_id "
		        + " ) VALUES ( "
		        +  ":diet_id, :pet_id)";
		    
		    //@formatter:on
		    
		    Map<String, Object> params = new HashMap<>();
		    params.put("diet_id", dietId);
		    params.put("pet_id", petId);
		 
		    
		    jdbcTemplate.update(sql, params);
		    return Optional.ofNullable(
		    		PetDiet.builder()
		    		.dietId(dietId)
		    		.petId(petId)
		    		.build());
		        }
		
		
		
		
	}

		