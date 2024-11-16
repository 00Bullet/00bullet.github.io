package com.service.Clientes.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.Clientes.demo.Entity.Clientes;
import com.service.Clientes.demo.Entity.Compra;
import com.service.Clientes.demo.dto.ClienteComprasDTO;
import com.service.Clientes.demo.dto.DetalleCompraDTO;
import com.service.Clientes.demo.dto.PlazoDTO;
import com.service.Clientes.demo.repository.ClientesRepository;
import com.service.Clientes.demo.repository.CompraRepository;

@Service
public class DetalleCompraService {

    @Autowired
    private ClientesRepository clientesRepository;

    @Autowired
    private CompraRepository compraRepository;

    public ClienteComprasDTO obtenerDetalleComprasPorCliente(Long idCliente) {
        
        Clientes cliente = clientesRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + idCliente));

        
        List<Compra> compras = compraRepository.findByClienteIdCliente(idCliente);

        
        List<DetalleCompraDTO> detallesCompras = compras.stream().map(compra -> {
        	DetalleCompraDTO compraDetalleDTO = new DetalleCompraDTO();
            compraDetalleDTO.setIdCompra(compra.getIdCompra());
            compraDetalleDTO.setFechaCompra(compra.getFechaCompra());
            compraDetalleDTO.setMontoComision(compra.getMontoComision());
            compraDetalleDTO.setMontoCompra(compra.getMontoCompra());
            compraDetalleDTO.setTotalPagar(compra.getTotalAPagar());


            List<PlazoDTO> plazoDTOs = new ArrayList<>();
            double montoDelPlazo = Math.round((compra.getTotalAPagar() / compra.getPlazos()) * 100.0) / 100.0;

            for (int i = 1; i <= compra.getPlazos(); i++) {
                PlazoDTO plazoDTO = new PlazoDTO();
                plazoDTO.setNumPago(i);
                plazoDTO.setMontoDelPlazo(montoDelPlazo);

                if (i == compra.getPlazos()) {
                    
                    plazoDTO.setMontoDelPlazo(
                            Math.round((compra.getTotalAPagar() - (montoDelPlazo * (i - 1))) * 100.0) / 100.0);
                }

                plazoDTO.setFechaPago(compra.getFechaCompra().plusMonths(i));
                plazoDTOs.add(plazoDTO);
            }
            compraDetalleDTO.setPlazos(plazoDTOs);

            return compraDetalleDTO;
        }).collect(Collectors.toList());

        
        ClienteComprasDTO clienteComprasDTO = new ClienteComprasDTO();
        clienteComprasDTO.setIdCliente(cliente.getIdCliente());
        clienteComprasDTO.setCompras(detallesCompras);

        return clienteComprasDTO;
    }
}
