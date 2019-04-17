package com.example.demo.Respository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Cidade;

public interface CidadeRespository extends JpaRepository<Cidade, Long> {


	List<Cidade> findByEstadoCodigo(Long estadoCodigo);
	

}
