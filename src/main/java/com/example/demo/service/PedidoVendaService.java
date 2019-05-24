package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Respository.PedidoVendaRepository;
import com.example.demo.model.PedidoVenda;

@Service
public class PedidoVendaService {
	
	@Autowired
	private PedidoVendaRepository pedidoVendaRepository;

	public PedidoVenda criar(PedidoVenda pedidoVenda) {
		
		//if(pedidoVenda.isNova()) { //verifica se é uma nova venda
		//	pedidoVenda.setDataEmissao(LocalDateTime.now());
		//}
		
		return pedidoVendaRepository.save(pedidoVenda);
	}

}
