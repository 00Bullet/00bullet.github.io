package com.service.Clientes.demo.dto;

import java.time.LocalDate;
import java.util.List;

public class DetalleCompraDTO {

    private Long idCompra;
    private LocalDate fechaCompra;
    private double montoComision;
    private double montoCompra;
    private double totalPagar;
    private List<PlazoDTO> plazos;

    
    public Long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Long idCompra) {
        this.idCompra = idCompra;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public double getMontoComision() {
        return montoComision;
    }

    public void setMontoComision(double montoComision) {
        this.montoComision = montoComision;
    }

    public double getMontoCompra() {
        return montoCompra;
    }

    public void setMontoCompra(double montoCompra) {
        this.montoCompra = montoCompra;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public List<PlazoDTO> getPlazos() {
        return plazos;
    }

    public void setPlazos(List<PlazoDTO> plazos) {
        this.plazos = plazos;
    }
}
