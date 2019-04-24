package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Respository.EstacaoRomaneioRepository;
import com.example.demo.model.EstacaoRomaneio;
import com.example.demo.service.EstacaoRomaneioService;

@RestController
@RequestMapping("/estacao")
public class EstacaoRomaneioResource {
	
	@Autowired
	EstacaoRomaneioRepository estacaoRomaneioRepository;
	
	@Autowired
	EstacaoRomaneioService estacaoRomaneioService;

	@GetMapping
	public List<EstacaoRomaneio> listar() {
		return estacaoRomaneioRepository.findAll();
	}
	
	@GetMapping("/{status}")
	public ResponseEntity<List<EstacaoRomaneio>> listarPorStatus(@PathVariable boolean status) {
		List<EstacaoRomaneio> estacoes = estacaoRomaneioService.listarPorStatus(status);
		if(!estacoes.isEmpty()) {
			return ResponseEntity.ok(estacoes);
		} else {
			return ResponseEntity.notFound().build();
		}	
	}
}
