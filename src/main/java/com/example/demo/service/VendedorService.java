package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Respository.VendedorRepository;
import com.example.demo.model.Vendedor;

@Service
public class VendedorService {
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	public Vendedor criar(Vendedor vendedor) {
		return vendedorRepository.save(vendedor);
	}
}
