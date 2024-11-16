package com.service.Clientes.demo.dto;


import java.time.LocalDate;

public class RegistroClientesDTO {
	
	private String nombre;
    private LocalDate fechaNacimiento;
    private String password;
    
    
    
	public String getNombre() {		
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

    	
}
