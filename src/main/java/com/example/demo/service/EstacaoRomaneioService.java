package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.Respository.EstacaoRomaneioRepository;
import com.example.demo.model.EstacaoRomaneio;

@Service
public class EstacaoRomaneioService {

	
	@Autowired
	EstacaoRomaneioRepository estacaoRomaneioRepository;
	
	
	public List<EstacaoRomaneio> listarPorStatus(boolean status){
		List<EstacaoRomaneio> estacoes = estacaoRomaneioRepository.findAll();
		List<EstacaoRomaneio> estacoesStatusPronta = new ArrayList<>();
		// estacoesStatusPronta = estacoes.forEach(e -> status = e.isStatus());
		for(EstacaoRomaneio c : estacoes) {
			if(c.isStatus() == status) {
				estacoesStatusPronta.add(c);
				System.out.println(c.getEstacaoNome());
				System.out.println(c.isStatus());
			}
		}
		
		return estacoesStatusPronta;	
	}


	public EstacaoRomaneio atualizar(EstacaoRomaneio estacaoRomaneio, Long codigo) {
		EstacaoRomaneio estacaoRomaneioSalva = buscarEstacaoRomaneioPorCodigo(codigo);
		BeanUtils.copyProperties(estacaoRomaneio, estacaoRomaneioSalva, "codigo");
		return estacaoRomaneioRepository.save(estacaoRomaneioSalva);
	}
	
	public EstacaoRomaneio buscarEstacaoRomaneioPorCodigo(Long codigo) {
		
		Optional<EstacaoRomaneio> estacaoRomaneio = estacaoRomaneioRepository.findById(codigo);
		if(!estacaoRomaneio.isPresent()) {
			throw new EmptyResultDataAccessException(1); // mínimo do tamanho esperado? 1
		}
		return estacaoRomaneio.get();
	}
}
