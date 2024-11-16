package com.service.Clientes.demo.Entity;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "clientes")
public class Clientes {
	
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_cliente")
	    private Long idCliente;

	    @Column(name = "nombre_cliente", nullable = false, length = 50)
	    private String nombre;
	    
	    @Column(name = "fecha_nacimento")
	    @Temporal(TemporalType.DATE)
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private LocalDate fechaNacimiento;
	    
	    @Column(name = "linea_credito")
	    private Double lineaCredito;
	    
	    @Column(name = "cliente_Password", nullable = false, length = 16 )
	    @NotBlank(message = "La contraseña es obligatoria")
	    @Size(min = 10, max = 16, message = "La contraseña debe tener al menos 8 caracteres")
	    @JsonIgnore 
	    private String Password;
	    
	    @ManyToOne
	    @JoinColumn(name = "esquema_de_pago_id")  
	    private EsquemasDePago esquemaDePago;

		public Long getIdCliente() {
			return idCliente;
		}

		public void setIdCliente(Long idCliente) {
			this.idCliente = idCliente;
		}

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


		public Double getLineaCredito() {
			return lineaCredito;
		}

		public void setLineaCredito(Double lineaCredito) {
			this.lineaCredito = lineaCredito;
		}

		public String getPassword() {
			return Password;
		}

		public void setPassword(String password) {
			Password = password;
		}

		  public EsquemasDePago getEsquemaDePago() {
		        return esquemaDePago;
		    }

		    public void setEsquemaDePago(EsquemasDePago esquemaDePago) {
		        this.esquemaDePago = esquemaDePago;
		    }
		
	    
}
