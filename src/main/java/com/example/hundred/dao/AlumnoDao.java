package com.example.hundred.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AlumnoDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

}
