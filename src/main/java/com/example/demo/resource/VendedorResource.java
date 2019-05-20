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

import com.example.demo.Respository.VendedorRepository;
import com.example.demo.event.RecursoCriadoEvent;
import com.example.demo.model.Vendedor;
import com.example.demo.service.VendedorService;

@RestController
@RequestMapping("/vendedor")
public class VendedorResource {

	
	    //CRIANDO EVENTO DE PUBLICAÇÃO COM O PACONTE EVENT E LISTENER
		//Ele é um publicador de Applicationevent que foi criado no pacote listener
		@Autowired
		private ApplicationEventPublisher publisher;
		
		@Autowired
		private VendedorRepository vendedorRepository;
		
		@Autowired
		private VendedorService VendedorService;
		
		
		@GetMapping
		public List<Vendedor> listarTodos() {
			return vendedorRepository.findAll();
		}
		
		@PostMapping														    
		public ResponseEntity<Vendedor> criar (@RequestBody Vendedor vendedor, HttpServletResponse response) {
			Vendedor vendedorSalvo = VendedorService.criar(vendedor);
			publisher.publishEvent(new RecursoCriadoEvent(this, response, vendedorSalvo.getCodigo()) );
			return ResponseEntity.status(HttpStatus.CREATED).body(vendedorSalvo);
		}
		
		
}
