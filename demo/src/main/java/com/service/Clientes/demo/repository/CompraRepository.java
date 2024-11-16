package com.service.Clientes.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.Clientes.demo.Entity.Compra;

public interface CompraRepository  extends JpaRepository<Compra, Long>{
	 List<Compra> findByClienteIdCliente(Long idCliente);

}
