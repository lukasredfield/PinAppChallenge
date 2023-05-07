package com.PinAppDef.PinAppChallenge.service.impl;



import com.PinAppDef.PinAppChallenge.Clientes.Cliente;
import com.PinAppDef.PinAppChallenge.Repositorio.Repositorio;
import com.PinAppDef.PinAppChallenge.service.ImplServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClienteServiceImpl implements ImplServicio {

	@Autowired
	private Repositorio clienteRepositorio;
	
	@Override
	public List<Cliente> findAll() {
		return clienteRepositorio.findAll();
	}

	public Cliente findById(long idClient) {
		return clienteRepositorio.findById(idClient).get();
	}

	@Override
	public Cliente save(Cliente cliente) {
		return clienteRepositorio.save(cliente);
	}

	@Override
	public void deleteById(int idClient) {

	}


	public void deleteById(long idClient) {
		clienteRepositorio.deleteById(idClient);
	}

}
