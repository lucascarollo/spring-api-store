package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Respository.ProdutoRepository;
import com.example.demo.model.Produto;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public List<Produto> listarTodos(){
		return produtoRepository.findAll();
	}
	
}
