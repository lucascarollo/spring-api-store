package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.Respository.ProdutoRepository;
import com.example.demo.model.Produto;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	
	
	public Produto criar(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public Produto atualizar(Long codigo, Produto produto) {
		Produto produtoSalvo = buscarPorCodigo(codigo);
		BeanUtils.copyProperties(produto, produtoSalvo, "codigo");
		
		return produtoRepository.save(produtoSalvo);
	}
	
	public Produto buscarPorCodigo(Long codigo) {
		Optional<Produto> produto = produtoRepository.findById(codigo);
		if(!produto.isPresent()) {
			throw new EmptyResultDataAccessException(1); // mínimo do tamanho esperado? 1
		}
		return produto.get();
	}
	
}
