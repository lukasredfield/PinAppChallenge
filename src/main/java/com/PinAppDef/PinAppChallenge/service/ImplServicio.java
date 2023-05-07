package com.PinAppDef.PinAppChallenge.service;


import com.PinAppDef.PinAppChallenge.Clientes.Cliente;

import java.util.List;

public interface ImplServicio {
	 List<Cliente> findAll();
	 Cliente findById(long idClient);
	 Cliente save(Cliente cliente);
	 void deleteById(int idClient);
}
