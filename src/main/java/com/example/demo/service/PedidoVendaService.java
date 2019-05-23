package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.demo.model.PedidoVenda;

@Service
public class PedidoVendaService {

	public PedidoVenda criar(PedidoVenda pedidoVenda) {
		
		if(pedidoVenda.isNova()) { //verifica se é uma nova venda
			pedidoVenda.setDataEmissao(LocalDateTime.now());
		}
		
		return null;
	}

}
