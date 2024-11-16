package com.service.Clientes.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.Clientes.demo.Entity.Clientes;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {

}
