package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Respository.CidadeRespository;
import com.example.demo.model.Cidade;

@RestController
@RequestMapping("/cidades")
public class CidadeResource {

	@Autowired
	private CidadeRespository cidadeRepository;
	
	@GetMapping
	public List<Cidade> cidadesPorEstado(@RequestParam Long estado) {
		return cidadeRepository.findByEstadoCodigo(estado);
	}
	
}
