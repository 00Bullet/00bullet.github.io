package com.service.Clientes.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.Clientes.demo.Entity.Clientes;
import com.service.Clientes.demo.dto.RegistroClientesDTO;
import com.service.Clientes.demo.service.RegistroClientesService;

@RestController
@RequestMapping("/api")
public class RegistroClientesController {
    @Autowired
    private RegistroClientesService registroClintesService;

    @PostMapping("/registrar")
    public ResponseEntity<Clientes> registrarUsuario(@RequestBody RegistroClientesDTO registroDTO) {
        try {
            Clientes usuarioRegistrado = registroClintesService.registrarUsuario(registroDTO);
            return new ResponseEntity<>(usuarioRegistrado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
