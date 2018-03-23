package com.example.hundred.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.hundred.domain.Cliente;

public class ClienteRowMapper implements RowMapper<Cliente>{

	@Override
	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cliente cliente = new Cliente();
		cliente.setId(rs.getInt(1));
		cliente.setName(rs.getString(2));
		cliente.setCorreo(rs.getString(3));
		return cliente;
	}

}
