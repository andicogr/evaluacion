package com.example.hundred.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.hundred.domain.Cliente;

@Repository
public class ClienteDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Cliente> getTodos(){
		RowMapper<Cliente> clienteRowMapper = new ClienteRowMapper();
		List<Cliente> listaClientes = jdbcTemplate.query("select id, name, correo from cliente", clienteRowMapper);
		return listaClientes;
	}
	
	public Cliente clienteByNameAndEmail(String nombre, String email) {
		RowMapper<Cliente> clienteRowMapper = new ClienteRowMapper();
		List<Cliente> listaClientes = jdbcTemplate.query("select id, name, correo from cliente where name = ? and correo = ?", clienteRowMapper, nombre, email);
		if(listaClientes.isEmpty()) {
			return new Cliente();
		}
		//RowMapper<Cliente> clienteRowMapper = new BeanPropertyRowMapper<>(Cliente.class);
		//Cliente cliente = jdbcTemplate.queryForObject("select * from cliente where name = ? and correo = ?", clienteRowMapper, nombre, email);
		return listaClientes.get(0);
	}
	
	public Cliente clientePorId(Integer id) {
		
		RowMapper<Cliente> rowMapper = new BeanPropertyRowMapper<>(Cliente.class);
		Cliente cliente = jdbcTemplate.queryForObject(
				"select * from cliente where id = ? ", rowMapper, id);
		return cliente;
	}
	
	public int insertar(Cliente cliente) {
		/*RowMapper<Integer> integerRowMapper = new BeanPropertyRowMapper<>(Integer.class);
		Integer maxId = jdbcTemplate.queryForObject("select count(*) from cliente", integerRowMapper);
		
		if(cliente.getId() == null) {
			cliente.setId(maxId + 1);
		}*/
		
		int resultado = jdbcTemplate.update("INSERT INTO CLIENTE(ID, NAME, CORREO) VALUES(? ,? ,?)", cliente.getId(), cliente.getName(), cliente.getCorreo());
		return resultado;
	}
	
	public int actualizar(Cliente cliente) {
		int resultado = jdbcTemplate.update("UPDATE CLIENTE SET NAME = ?, CORREO = ? WHERE ID = ?", cliente.getName(), cliente.getCorreo(), cliente.getId());
		return resultado;
	}

	public int eliminar(Integer idCliente) {
		int resultado = jdbcTemplate.update("DELETE FROM CLIENTE WHERE ID = ?", idCliente);
		return resultado;
	}
	
}
