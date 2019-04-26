package com.example.demo.resource;

import java.util.List;

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

import com.example.demo.Respository.ProdutoRepository;
import com.example.demo.event.RecursoCriadoEvent;
import com.example.demo.model.Produto;
import com.example.demo.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

	//CRIANDO EVENTO DE PUBLICAÇÃO COM O PACONTE EVENT E LISTENER
	//Ele é um publicador de Applicationevent que foi criado no pacote listener
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public List<Produto> listarTodos(){
		return produtoRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Produto> criar(@RequestBody Produto produto, HttpServletResponse response) {
		Produto produtoSalvo = produtoService.criar(produto);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, produtoSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
	}
	
	@DeleteMapping("/codigo")
	@ResponseStatus(HttpStatus.NO_CONTENT) // RETORNA UM 204 QUE QUER DIZER QUE TEVE SUCESSO MAS N TENHO NADA PRA TE RETORNAR, CONSEGUIU FAZER O QUE PRECISAVA MAS N TEM NADA PRA RETORNAR
	public void deletarProduto(@PathVariable Long codigo) {
		produtoRepository.deleteById(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Produto> autalizar(@RequestBody Produto produto, @PathVariable Long codigo){
		Produto produtoSalvo = produtoService.atualizar(codigo, produto);
		
		return ResponseEntity.ok(produtoSalvo);
	}
	
}
