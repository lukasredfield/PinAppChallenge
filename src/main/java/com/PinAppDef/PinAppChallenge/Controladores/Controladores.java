package com.PinAppDef.PinAppChallenge.Controladores;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.PinAppDef.PinAppChallenge.Clientes.Cliente;
import com.PinAppDef.PinAppChallenge.Repositorio.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controladores {

    @Autowired
    private Repositorio clienteRepositorio;

    @GetMapping(value = "/")
    public String PinAappChallenge(){
        return "API de Clientes (PinApp)!";
    }


    @PostMapping("/creacliente")
    public ResponseEntity<Cliente> creaCliente(@RequestBody Cliente cliente) {
        Cliente clienteCreado = clienteRepositorio.save(cliente);
        return new ResponseEntity<>(clienteCreado, HttpStatus.CREATED);
    }


    @GetMapping(value = "/kpiDeClientes")
    public Map<String, Double> kpiDeClientes() {
        List<Cliente> clientes = clienteRepositorio.findAll();
        double edadPromedio = clientes.stream()
                .mapToInt(Cliente::getEdad)
                .average()
                .orElse(0.0);
        double desviacionEstandar = Math.sqrt(clientes.stream()
                .mapToDouble(cliente -> Math.pow(cliente.getEdad() - edadPromedio, 2))
                .average()
                .orElse(0.0));
        Map<String, Double> result = new HashMap<>();
        result.put("promedio_edad", edadPromedio);
        result.put("desviacion_estandar", desviacionEstandar);
        return result;
    }


    @GetMapping("/listclientes")
    public ResponseEntity<List<Cliente>> listaClientes() {
        List<Cliente> clientes = clienteRepositorio.findAll();
        List<Cliente> clientesConFechasDeMuerte = new ArrayList<>();
        clientes.forEach(cliente -> {
            LocalDate fechaMuerte = LocalDate.now().plusYears(80 - cliente.getEdad());
            Cliente clienteConFechaDeMuerte = new Cliente(cliente);
            clienteConFechaDeMuerte.setFechaMuerte(fechaMuerte);
            clientesConFechasDeMuerte.add(clienteConFechaDeMuerte);
        });
        return ResponseEntity.ok(clientesConFechasDeMuerte);
    }

}


