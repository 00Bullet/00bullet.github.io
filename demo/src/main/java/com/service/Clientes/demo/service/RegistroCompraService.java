package com.service.Clientes.demo.service;

import com.service.Clientes.demo.dto.RegistroCompraDTO;
import com.service.Clientes.demo.Entity.Clientes;
import com.service.Clientes.demo.Entity.Compra;
import com.service.Clientes.demo.Entity.EsquemasDePago;
import com.service.Clientes.demo.Entity.Mensajes;
import com.service.Clientes.demo.repository.ClientesRepository;
import com.service.Clientes.demo.repository.CompraRepository;
import com.service.Clientes.demo.repository.EsquemasDePagoRepository;
import com.service.Clientes.demo.repository.MensajesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class RegistroCompraService {

    @Autowired
    private ClientesRepository clientesRepository;

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private EsquemasDePagoRepository esquemasDePagoRepository;

    @Autowired
    private MensajesRepository mensajesRepository;

    public void procesarCompra(RegistroCompraDTO registroCompraDTO) {

        
        Optional<Clientes> clienteOpt = clientesRepository.findById(registroCompraDTO.getIdCliente());

        if (!clienteOpt.isPresent()) {
            throw new RuntimeException("Cliente no encontrado con ID: " + registroCompraDTO.getIdCliente());
        }


        Clientes cliente = clienteOpt.get();


        EsquemasDePago esquemaAsignado = asignarEsquemaDePago(cliente);

        
        if (registroCompraDTO.getMontoCompra() > cliente.getLineaCredito()) {
            Mensajes mensajeError = new Mensajes();
            mensajeError.setTipoMensaje("Error");
            mensajeError.setMensaje("El monto de la compra excede la línea de crédito del cliente.");
            mensajeError.setCliente(cliente); 
            mensajesRepository.save(mensajeError);
            throw new RuntimeException("Compra rechazada: excede la línea de crédito.");
        }

        
        double tasaInteres = esquemaAsignado.getTasaInteres();
        int numeroDePagos = esquemaAsignado.getNumeroDePagos();
        double montoComision = registroCompraDTO.getMontoCompra() * (tasaInteres / 100);
        double totalAPagar = registroCompraDTO.getMontoCompra() + montoComision;

        
        Compra compra = new Compra();
        compra.setCliente(cliente); 
        compra.setFechaCompra(LocalDate.now());
        compra.setMontoComision(montoComision);
        compra.setMontoCompra(registroCompraDTO.getMontoCompra());
        compra.setTotalAPagar(totalAPagar);
        compra.setPlazos(numeroDePagos);

        
        LocalDate fechaSiguientePago = calcularFechaSiguientePago(compra.getFechaCompra(), esquemaAsignado.getFrecuenciaCobro());
        compra.setFechaSiguientePago(fechaSiguientePago);

        
        compraRepository.save(compra);

        
        double nuevaLineaCredito = cliente.getLineaCredito() - registroCompraDTO.getMontoCompra();
        cliente.setLineaCredito(nuevaLineaCredito);
        clientesRepository.save(cliente); 

        
        Mensajes mensajeExito = new Mensajes();
        mensajeExito.setTipoMensaje("Éxito");
        mensajeExito.setMensaje("Compra realizada con éxito.");
        mensajeExito.setCliente(cliente); 
        mensajesRepository.save(mensajeExito);
    }

    
    private EsquemasDePago asignarEsquemaDePago(Clientes cliente) {

        EsquemasDePago esquemaAsignado = null;

        
        if (cliente.getFechaNacimiento() != null && cliente.getFechaNacimiento().getYear() < 2005) {
            esquemaAsignado = esquemasDePagoRepository.findById(1L).orElseThrow(() -> new RuntimeException("Esquema de pago con ID 1 no encontrado."));
        }
        else if (cliente.getIdCliente() > 25) {
            esquemaAsignado = esquemasDePagoRepository.findById(2L).orElseThrow(() -> new RuntimeException("Esquema de pago con ID 2 no encontrado."));
        }
        else {
            esquemaAsignado = esquemasDePagoRepository.findById(2L).orElseThrow(() -> new RuntimeException("Esquema de pago con ID 2 no encontrado."));
        }

        
        if (cliente.getEsquemaDePago() == null) {
            cliente.setEsquemaDePago(esquemaAsignado);
            clientesRepository.save(cliente); 
        }

        return esquemaAsignado;
    }

    
    private LocalDate calcularFechaSiguientePago(LocalDate fechaCompra, String frecuenciaCobro) {
        LocalDate fechaSiguientePago = fechaCompra;

        if (frecuenciaCobro == null || frecuenciaCobro.isEmpty()) {
            throw new IllegalArgumentException("Frecuencia de cobro no proporcionada");
        }

        switch (frecuenciaCobro.toLowerCase()) {
            case "semanal":
                fechaSiguientePago = fechaCompra.plusWeeks(1); 
                break;
            case "quincenal":
                fechaSiguientePago = fechaCompra.plusWeeks(2); 
                break;
            default:
                throw new IllegalArgumentException("Frecuencia de cobro no válida: ");
        }

        return fechaSiguientePago;
    }
}
