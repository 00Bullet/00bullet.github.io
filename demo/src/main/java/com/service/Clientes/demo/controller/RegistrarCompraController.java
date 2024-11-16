package com.service.Clientes.demo.controller;

import com.service.Clientes.demo.dto.RegistroCompraDTO;
import com.service.Clientes.demo.service.RegistroCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/compras")
public class RegistrarCompraController {

    @Autowired
    private RegistroCompraService registroCompraService;


    @PostMapping("/procesar")
    public ResponseEntity<String> procesarCompra(@RequestBody RegistroCompraDTO registroCompraDTO) {
        try {
            
            registroCompraService.procesarCompra(registroCompraDTO);
            return new ResponseEntity<>("Compra procesada con éxito", HttpStatus.OK);
        } catch (RuntimeException e) {
            
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
