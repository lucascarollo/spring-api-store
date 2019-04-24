package com.example.demo.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Respository.FabricaRepository;
import com.example.demo.event.RecursoCriadoEvent;
import com.example.demo.model.Fabrica;
import com.example.demo.service.FabricaService;

@RestController
@RequestMapping("/fabricas")
public class FabricaResource {

	//CRIANDO EVENTO DE PUBLICAÇÃO COM O PACONTE EVENT E LISTENER
	//Ele é um publicador de Applicationevent que foi criado no pacote listener
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private FabricaRepository fabricaRepository;
	
	@Autowired
	private FabricaService fabricaService;
	
	@GetMapping
	public List<Fabrica> listar() {
		return fabricaRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Fabrica> criar (@RequestBody Fabrica fabrica, HttpServletResponse response){
		
		Fabrica novaFabrica = fabricaRepository.save(fabrica);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, novaFabrica.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(novaFabrica);	
	}
	
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT) // RETORNA UM 204 QUE QUER DIZER QUE TEVE SUCESSO MAS N TENHO NADA PRA TE RETORNAR, CONSEGUIU FAZER O QUE PRECISAVA MAS N TEM NADA PRA RETORNAR
	public void remover(@PathVariable Long codigo) {
		fabricaRepository.deleteById(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Fabrica> atualizar(@RequestBody Fabrica fabrica, @PathVariable Long codigo) {
		
		Fabrica fabricaSalva = fabricaService.atualizar(fabrica, codigo);
		
		return ResponseEntity.ok(fabricaSalva);
		
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Optional<Fabrica>> buscarPorCodigo(@PathVariable Long codigo) {
		Optional<Fabrica> fabrica = fabricaRepository.findById(codigo);
		
		if(!fabrica.isPresent()) {
			 return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(fabrica);
		}
	}
	
}
