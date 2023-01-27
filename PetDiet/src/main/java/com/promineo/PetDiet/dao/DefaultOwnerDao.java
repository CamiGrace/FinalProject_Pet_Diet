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


import com.promineo.PetDiet.entity.Owner;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class DefaultOwnerDao implements OwnerDao {


	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	
	//GET method (READ)
	@Override
	public List<Owner> fetchOwnerInfo(Long ownerId) {
	log.debug("DAO: ownerId={}", ownerId);
		
		//@formatter:off
				String sql = " "
					+ "SELECT * "
					+ "FROM owner "
					+ " WHERE owner_id = :owner_id";
				//@formatter:on
		
				Map<String, Object> params = new HashMap<>();
				params.put("owner_id", ownerId);
				
			
				return jdbcTemplate.query( sql, params, 
						new RowMapper<>() {

							@Override
							public Owner mapRow(ResultSet rs, int rowNum) throws SQLException {
								//@formatter:off
								return Owner.builder()
										  .ownerId(rs.getLong("owner_id"))
										  .firstName(new String(rs.getString("first_name")))
										  .lastName(new String(rs.getString("last_name")))
										  .address(new String(rs.getString("address")))
										  .phoneNo(new String(rs.getString("phone_no")))
										  .build();
								//@formatter:on
							}
					
				});
			}
	}


