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

	//POST (CREATE) method: create new Owner entry when given firstName, lastName, address, and Phone number 
	@Override
	public Optional<Owner> createOwner(String firstName, String lastName, String address, String phoneNo) {
		 log.info("DAO: firstName={}, lastName={}, address={}, phoneNo={}",
				 firstName, lastName, address, phoneNo);
	
		   
		    //@formatter:off
		    String sql = " "
		        + " INSERT INTO owner ("
		        + "first_name, last_name, address, phone_no "
		        + " ) VALUES ( "
		        +  ":first_name, :last_name, :address, :phone_no) ";
		    
		    //@formatter:on
		    
		    Map<String, Object> params = new HashMap<>();
		    params.put("first_name", firstName);
		    params.put("last_name", lastName);
		    params.put("address", address);
		    params.put("phone_no", phoneNo);
		    
		    
		    jdbcTemplate.update(sql, params);
		    return Optional.ofNullable(
		    		Owner.builder()
		    		.firstName(firstName)
		    		.lastName(lastName)
		    		.address(address)
		    		.phoneNo(phoneNo)
		    		.build());
		        }

	@Override
	public Optional<Owner> updateOwnerInformation(Long ownerId, String address, String phoneNo) {
		log.info("DAO: ownerId={}, address={}, phoneNo={}", ownerId, address, phoneNo);
		
		//@formatter:off
		  String sql = ""
				  + "UPDATE owner SET address = :address AND "
			        + "phone_no = :phone_no "
			        + "WHERE owner_id = :owner_id";
		  
		  
		  //@formatter:on
		  
		  Map<String, Object> params = new HashMap<>();
		  params.put("owner_id", ownerId);
		  params.put("address", address);
		  params.put("phone_no", phoneNo);
		
		  
		    jdbcTemplate.update(sql, params);
		    return Optional.ofNullable(
		    		Owner.builder()
		    		.ownerId(ownerId)
		    		.address(address)
		    		.phoneNo(phoneNo)
		    		.build());
		        }
	@Override
	public Optional<Owner> deleteOwner(Long ownerId) {
		//@formatter:off
		  String sql = ""
		      + "DELETE FROM owner WHERE "
		      + "owner_id = :owner_id";
		   
		  //@formatter:on
		  
		  Map<String, Object> params = new HashMap<>();
		  params.put("owner_id", ownerId);

		  jdbcTemplate.update(sql, params);  
		    return Optional.ofNullable(
		    		Owner.builder()
		    		.ownerId(ownerId)
		    		.build());
		        }
}

