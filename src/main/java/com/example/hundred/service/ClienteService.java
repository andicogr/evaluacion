package com.example.hundred.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hundred.dao.ClienteDao;
import com.example.hundred.domain.Cliente;

@Service
public class ClienteService {
	
	@Autowired
	private	ClienteDao clienteDao;

	public List<Cliente> getTodos(){
		return clienteDao.getTodos();
	}
	
	public Cliente clienteByNameAndEmail(String nombre, String email) {
		return clienteDao.clienteByNameAndEmail(nombre, email);
	}	
	
	public Cliente clientePorId(Integer id) {
		return clienteDao.clientePorId(id);
	}
	
	public int insertar(Cliente cliente) {
		return clienteDao.insertar(cliente);
	}
	
	public int actualizar(Cliente cliente) {
		return clienteDao.actualizar(cliente);
	}

	public int eliminar(Integer idCliente) {
		return clienteDao.eliminar(idCliente);
	}
}
