package com.PinAppDef.PinAppChallenge.Repositorio;


import com.PinAppDef.PinAppChallenge.Clientes.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repositorio extends JpaRepository<Cliente,Long> {
}
