package com.example.demo.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Respository.PedidoVendaRepository;
import com.example.demo.event.RecursoCriadoEvent;
import com.example.demo.model.PedidoVenda;
import com.example.demo.service.PedidoVendaService;

@RestController
@RequestMapping("/pedido")
public class PedidoVendaResource {

	
		//CRIANDO EVENTO DE PUBLICAÇÃO COM O PACONTE EVENT E LISTENER
		//Ele é um publicador de Applicationevent que foi criado no pacote listener
		@Autowired
		private ApplicationEventPublisher publisher;
		
		@Autowired
		private PedidoVendaRepository pedidoVendaRepository;
		
		@Autowired
		private PedidoVendaService pedidoVendaService;
		
		
		@PostMapping("/novo")
		public ResponseEntity<PedidoVenda> criar (@RequestBody PedidoVenda pedidoVenda, HttpServletResponse response) {
			
			//TODO: fazer algo como isso: pedidoVenda.adicionarItens(PEGAR OS ITENS DA SEÇÃO<ARRAY>); 
			
			PedidoVenda pedidoVendaSalvo = pedidoVendaService.criar(pedidoVenda);
			
			publisher.publishEvent(new RecursoCriadoEvent(this, response, pedidoVendaSalvo.getCodigo()));
			return ResponseEntity.status(HttpStatus.CREATED).body(pedidoVendaSalvo);
		}
		
		@GetMapping
		private  List<PedidoVenda> listarTodos() {
			return pedidoVendaRepository.findAll();
		}
		
	
}
