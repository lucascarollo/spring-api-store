package com.example.demo.Respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Cidade;

public interface CidadeRespository extends JpaRepository<Cidade, Long> {

}
