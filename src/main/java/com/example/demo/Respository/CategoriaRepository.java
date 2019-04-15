package com.example.demo.Respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
}
