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

import com.promineo.PetDiet.entity.Diet;


import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultDietDao implements DietDao {

	
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	//GET method: returns info on diet when given unique Diet ID
	@Override
	public List<Diet> fetchDietInfo(Long dietId) {
		log.debug("DAO: dietId={}", dietId);
		//@formatter:off
		String sql = " "
			+ "SELECT * "
			+ "FROM diet "
			+ " WHERE diet_id = :diet_id";
		//@formatter:on

		Map<String, Object> params = new HashMap<>();
		params.put("diet_id", dietId);
		
	
		return jdbcTemplate.query( sql, params, 
				new RowMapper<>() {

					@Override
					public Diet mapRow(ResultSet rs, int rowNum) throws SQLException {
						//@formatter:off
						return Diet.builder()
								  .dietId(rs.getLong("diet_id"))
								  .dietName(new String(rs.getString("diet_name")))
								  .prepTime(new String(rs.getString("prep_time")))
								  .build();
						//@formatter:on
					}
			
		});
	}

}
