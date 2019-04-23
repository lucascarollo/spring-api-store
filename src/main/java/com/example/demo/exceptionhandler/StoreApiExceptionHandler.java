package com.example.demo.exceptionhandler;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class StoreApiExceptionHandler extends  ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;
	
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request){
		
				String mensagemUsuario = messageSource.getMessage("mensagem.invalida", null,  LocaleContextHolder.getLocale());
				String mensagemDesenvolvedor = ex.getCause()!= null ? ex.getCause().toString() : ex.toString();
				List<Erro> erros = Arrays.asList(new Erro(mensagemUsuario, mensagemDesenvolvedor));
				return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
		
		List<Erro> erros = criarListaDeErros(ex.getBindingResult());
		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);	
	}
	
	
	private List<Erro> criarListaDeErros(BindingResult bindingResult){
		List<Erro> erros = new ArrayList<>();
		
		for(FieldError fieldError : bindingResult.getFieldErrors()) {
			String mensagemUsuario = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			String mensagemDesenvolvedor= fieldError.toString();
			erros.add(new Erro(mensagemUsuario,mensagemDesenvolvedor));
		}
		return erros;
	}
	
	
	public static class Erro {
		String mensagemUsuario;
		String mensagemDesenvolvedor;
		public Erro(String mensagemUsuario, String mensagemDesenvolvedor) {
			super();
			this.mensagemUsuario = mensagemUsuario;
			this.mensagemDesenvolvedor = mensagemDesenvolvedor;
		}
		public String getMensagemUsuario() {
			return mensagemUsuario;
		}
		
		public String getMensagemDesenvolvedor() {
			return mensagemDesenvolvedor;
		}	
	}
	//SE EU TENTAR REMOVER UMA PESSOA COM CODIGO INEXISTENTE, OU SEJA QUE A PESSOA NÃO EXISTE
	//VAI RETORNAR UM ERRO NO CONSOLE DA CLASSE --> EmptyResultDataAccessException
	//Sabendo disso eu vou transformar esse erro
	//Essa anotação é pra dizer que quando esse erro acontecer eu quero trocar pelo método que eu to fazendo abaixo
	@ExceptionHandler({ EmptyResultDataAccessException.class })
	// @ResponseStatus(HttpStatus.NOT_FOUND) // PARA RETORNAR AO INVES DE UM ERRO 500 UM ERRO DE NAO ENCONTRADO 
	// se quisesse deixar o método sem implementar mais nada deixando ele void
	public ResponseEntity<Object> handleEmptyResultDataAccessException(RuntimeException ex, WebRequest request) {
		String mensagemUsuario = messageSource.getMessage("recurso.nao-encontrado", null,  LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.toString();
		List<Erro> erros = Arrays.asList(new Erro(mensagemUsuario, mensagemDesenvolvedor));
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
}
