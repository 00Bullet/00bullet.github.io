package com.service.Clientes.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.Clientes.demo.Entity.Clientes;
import com.service.Clientes.demo.dto.RegistroClientesDTO;
import com.service.Clientes.demo.exception.ClientesException;
import com.service.Clientes.demo.repository.ClientesRepository;

import java.time.LocalDate;
import java.time.Period;

@Service
public class RegistroClientesService {

    @Autowired
    private ClientesRepository clientesRepository;

    
    public Clientes registrarUsuario(RegistroClientesDTO clienteDTO) {

        int edad = calcularEdad(clienteDTO.getFechaNacimiento());

        
        double lineaCredito = asignarLineaCredito(edad);

        
        Clientes cliente = new Clientes();
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setFechaNacimiento(clienteDTO.getFechaNacimiento());
        cliente.setPassword(clienteDTO.getPassword());
        cliente.setLineaCredito(lineaCredito); 
        
        return clientesRepository.save(cliente);
    }

    
    private int calcularEdad(LocalDate fechaNacimiento) {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    
    private double asignarLineaCredito(int edad) {
        if (edad < 18) {
            throw new ClientesException("Lo siento, no tienes la mayoría de edad para obtener una línea de crédito.");
        } else if (edad <= 25) {
            return 3000;
        } else if (edad <= 30) {
            return 5000;
        } else if (edad <= 65) {
            return 8000;
        } else if (edad <= 90) {
            return 1500;
        } else {
            return 0;
        }
    }
}
