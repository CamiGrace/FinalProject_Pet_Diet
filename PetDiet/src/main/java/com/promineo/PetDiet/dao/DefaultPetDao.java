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

import com.promineo.PetDiet.entity.HairLength;
import com.promineo.PetDiet.entity.Pet;
import com.promineo.PetDiet.entity.PetSize;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class DefaultPetDao implements PetDao{

	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	//Get method to read list of pets from database
	
	@Override
	public List<Pet> fetchPetName(String breed) {
		log.debug("DAO: breed={}", breed);
		
		//@formatter:off
				String sql = " "
					+ "SELECT * "
					+ "FROM pet "
					+ " WHERE breed = :breed";
				//@formatter:on
		
				Map<String, Object> params = new HashMap<>();
				params.put("breed", breed);
				
			
				return jdbcTemplate.query( sql, params, 
						new RowMapper<>() {

							@Override
							public Pet mapRow(ResultSet rs, int rowNum) throws SQLException {
								//@formatter:off
								return Pet.builder()
										  .petId(rs.getLong("pet_id"))
										  .ownerId(rs.getLong("owner_id"))
										  .petName(new String(rs.getString("pet_name")))
										  .species(new String(rs.getString("species")))
										  .breed(new String(rs.getString("breed")))
										  .age(rs.getLong("age"))
										  .petSize(PetSize.valueOf(rs.getString("pet_size")))
										  .hairLength(HairLength.valueOf(rs.getString("pet_size")))
										  .build();
								//@formatter:on
							}
					
				});
			}

		}
