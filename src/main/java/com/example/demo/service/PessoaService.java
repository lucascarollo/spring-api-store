package com.example.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Respository.PessoaRepository;
import com.example.demo.model.Pessoa;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRespository;
	
	
	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRespository.save(pessoa);
	}

}
