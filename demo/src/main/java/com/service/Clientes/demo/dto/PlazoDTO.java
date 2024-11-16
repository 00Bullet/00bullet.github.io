package com.service.Clientes.demo.dto;

import java.time.LocalDate;

public class PlazoDTO {
    private int numPago;
    private double montoDelPlazo;
    private LocalDate fechaPago;

    
    public int getNumPago() {
        return numPago;
    }

    public void setNumPago(int numPago) {
        this.numPago = numPago;
    }

    public double getMontoDelPlazo() {
        return montoDelPlazo;
    }

    public void setMontoDelPlazo(double montoDelPlazo) {
        this.montoDelPlazo = montoDelPlazo;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }
}
