package com.example.demo.model;

public enum StatusPedido {

	ORCAMENTO("Orçamento"),
	EMITIDA("Emitida"),
	CANCELADA("Cancelada"),
	ANDAMENTO("Andamento");
	
	private String descricao;

	private StatusPedido(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
}
