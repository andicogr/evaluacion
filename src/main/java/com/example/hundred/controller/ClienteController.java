package com.example.hundred.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.hundred.domain.Cliente;
import com.example.hundred.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping("/listar")
	public List<Cliente> getTodos(){
		System.out.println("Dentro de getTodos");
		return clienteService.getTodos();
	}
	
	@RequestMapping("/{id}")
	public Cliente clientePorId(@PathVariable Integer id) {
		System.out.println("Dentro de clientePorId");
		return clienteService.clientePorId(id);
	}

	@CrossOrigin
	@RequestMapping
	public Cliente clienteByNameAndEmail(String nombre, String email) {
		System.out.println("Dentro de clienteByNameAndEmail");
		return clienteService.clienteByNameAndEmail(nombre, email);
	}	
	
	@RequestMapping(value="/insertar", method = RequestMethod.POST)
	public int insertar(Cliente cliente) {
		System.out.println("Dentro de insertar");
		return clienteService.insertar(cliente);
	}
	
	@RequestMapping(value="/actualizar", method = RequestMethod.POST)
	public int actualizar(Cliente cliente) {
		System.out.println("Dentro de actualizar");
		return clienteService.actualizar(cliente);
	}

	@RequestMapping(value="/eliminar")
	public int eliminar(Integer idCliente) {
		System.out.println("Dentro de eliminar");
		return clienteService.eliminar(idCliente);
	}
	
	@RequestMapping("/edad")
	public Long obtenerEdad(String fecha) {
		System.out.println("fecha: " + fecha);
		Date hoy = new Date();
		Date fechaNacimiento = null;
		try {
			fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("fecha: " + fechaNacimiento);
		System.out.println("Hoy: " + hoy.getTime());
		System.out.println("fecha: " + fechaNacimiento.getTime());
		Long mili = hoy.getTime() - fechaNacimiento.getTime();
		
		System.out.println("edad: " + TimeUnit.DAYS.convert(mili, TimeUnit.MILLISECONDS));
		return mili / (1000 * 3600 * 24 * 365) ;
	}
	

}
