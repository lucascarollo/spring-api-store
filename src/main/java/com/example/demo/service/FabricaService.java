package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.Respository.FabricaRepository;
import com.example.demo.model.Fabrica;

@Service
public class FabricaService {

	
	@Autowired
	private FabricaRepository fabricaRepository;
	
	public Fabrica atualizar (Fabrica fabrica, Long codigo) {
		
		Fabrica fabricaSalva = buscarFabricaPeloCodigo(codigo);
		//a BIBLIOTECA SPRING FORNECE UM UTILITARIO PARA COPIAR PROPRIEDADES DE UM OBJETO PARA OUTRO BeanUtils
		BeanUtils.copyProperties(fabrica, fabricaSalva, "codigo");
		//Copiando de pessoa para pessoaSalva ignorando o código para que o código continue o mesmo
		
		return fabricaRepository.save(fabricaSalva);
	}
	
	public Fabrica buscarFabricaPeloCodigo(Long codigo) {
		Optional<Fabrica> fabrica = fabricaRepository.findById(codigo);
		if(!fabrica.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return fabrica.get();
	}
}
