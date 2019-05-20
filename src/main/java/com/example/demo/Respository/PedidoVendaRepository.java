package com.example.demo.Respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.PedidoVenda;

public interface PedidoVendaRepository extends JpaRepository<PedidoVenda, Long> {

}
