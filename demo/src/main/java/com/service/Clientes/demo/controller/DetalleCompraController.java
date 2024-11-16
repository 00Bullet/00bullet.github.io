package com.service.Clientes.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.Clientes.demo.dto.ClienteComprasDTO;
import com.service.Clientes.demo.service.DetalleCompraService;

@RestController
@RequestMapping("/api/compras")
public class DetalleCompraController {

    @Autowired
    private DetalleCompraService compraService;

    @GetMapping("/{idCliente}")
    public ResponseEntity<ClienteComprasDTO> obtenerComprasPorCliente(@PathVariable Long idCliente) {
        ClienteComprasDTO respuesta = compraService.obtenerDetalleComprasPorCliente(idCliente);
        return ResponseEntity.ok(respuesta);
    }
}


