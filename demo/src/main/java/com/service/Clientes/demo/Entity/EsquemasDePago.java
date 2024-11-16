package com.service.Clientes.demo.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EsquemasDePago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "esuqema_de_pago_id")
    private Long esquemaDePagoId; 
    
    @Column(name = "tipo_esquema")
    private String tipoEsquema; 
    
    @Column(name = "numero_de_pagos")
    private int numeroDePagos; 
    
    @Column(name = "frecuencia_cobro")
    private String frecuenciaCobro; 
    
    @Column(name = "tasa_interes")
    private double tasaInteres; 

    // Getters y Setters
    public Long getEsquemaDePagoId() {
        return esquemaDePagoId;
    }

    public void setEsquemaDePagoId(Long esquemaDePagoId) {
        this.esquemaDePagoId = esquemaDePagoId;
    }

    public String getTipoEsquema() {
        return tipoEsquema;
    }

    public void setTipoEsquema(String tipoEsquema) {
        this.tipoEsquema = tipoEsquema;
    }

    public int getNumeroDePagos() {
        return numeroDePagos;
    }

    public void setNumeroDePagos(int numeroDePagos) {
        this.numeroDePagos = numeroDePagos;
    }

    public String getFrecuenciaCobro() {
        return frecuenciaCobro;
    }

    public void setFrecuenciaCobro(String frecuenciaCobro) {
        this.frecuenciaCobro = frecuenciaCobro;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }
}
