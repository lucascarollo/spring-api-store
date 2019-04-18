package com.example.demo.service;



import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.Respository.PessoaRepository;
import com.example.demo.model.Pessoa;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	public Pessoa atualizar(Long codigo, Pessoa pessoa) {
		Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);
		//a BIBLIOTECA SPRING FORNECE UM UTILITARIO PARA COPIAR PROPRIEDADES DE UM OBJETO PARA OUTRO BeanUtils
		BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
		//Copiando de pessoa para pessoaSalva ignorando o código para que o código continue o mesmo
		return pessoaRepository.save(pessoaSalva);
	}
	
	public Pessoa buscarPessoaPeloCodigo(Long codigo) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(codigo);
		if(!pessoa.isPresent()) {
			 throw new EmptyResultDataAccessException(1); // mínimo do tamanho esperado? 1
			 
		}
		return pessoa.get();
	}
}
