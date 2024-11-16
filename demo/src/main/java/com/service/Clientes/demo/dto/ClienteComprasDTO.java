package com.service.Clientes.demo.dto;

import java.util.List;

public class ClienteComprasDTO {

    private Long idCliente;
    private List<DetalleCompraDTO> compras;

    
    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public List<DetalleCompraDTO> getCompras() {
        return compras;
    }

    public void setCompras(List<DetalleCompraDTO> compras) {
        this.compras = compras;
    }
}
