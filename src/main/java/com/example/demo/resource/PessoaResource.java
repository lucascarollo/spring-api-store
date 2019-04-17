package com.example.demo.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.event.RecursoCriadoEvent;
import com.example.demo.model.Pessoa;
import com.example.demo.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

	@Autowired
	private PessoaService pessoaService;
	
	//CRIANDO EVENTO DE PUBLICAÇÃO COM O PACONTE EVENT E LISTENER
	//Ele é um publicador de Applicationevent que foi criado no pacote listener
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	@PostMapping
	public ResponseEntity<Pessoa> criar (@Valid @RequestBody Pessoa pessoa, HttpServletResponse response) {
		
		Pessoa pessoaSalva = pessoaService.salvar(pessoa);
		//this --> Quem criou o evento? this de pessoaResource
		publisher.publishEvent(new RecursoCriadoEvent(this, response, pessoaSalva.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);	
	}
	
}
