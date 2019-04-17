package com.example.demo.Respository;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> master
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Cidade;

public interface CidadeRespository extends JpaRepository<Cidade, Long> {

<<<<<<< HEAD
=======
	List<Cidade> findByEstadoCodigo(Long estadoCodigo);
	
>>>>>>> master
}
