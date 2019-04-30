package com.example.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedido_venda_item")
public class PedidoVendaItem  implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long codigo;
	
	@ManyToOne
	@JoinColumn(name = "codigo_pedido_venda")
	PedidoVenda pedidoVenda;
	
	@ManyToOne
	@JoinColumn(name="codigo_produto")
	Produto produto;
	
	int quantidade;
	
	@Column(name = "valor_unitario")
	BigDecimal valorUnitario;
	
	@Column(name = "valor_total_bruto")
	BigDecimal valorTotalBruto;
	
	@Column(name = "valor_total_liquido")
	BigDecimal valorTotalLiquido;
	
	@Column(name = "valor_total_desconto")
	BigDecimal valorTotalDesconto;	
	
	@Column(name = "valor_total_acrescimo")
	BigDecimal valorTotalAcrescimo;

	private Long getCodigo() {
		return codigo;
	}

	private void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	private Produto getProduto() {
		return produto;
	}

	private void setProduto(Produto produto) {
		this.produto = produto;
	}

	private int getQuantidade() {
		return quantidade;
	}

	private void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	private BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	private void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	private BigDecimal getValorTotalBruto() {
		return valorTotalBruto;
	}

	private void setValorTotalBruto(BigDecimal valorTotalBruto) {
		this.valorTotalBruto = valorTotalBruto;
	}

	private BigDecimal getValorTotalLiquido() {
		return valorTotalLiquido;
	}

	private void setValorTotalLiquido(BigDecimal valorTotalLiquido) {
		this.valorTotalLiquido = valorTotalLiquido;
	}

	private BigDecimal getValorTotalDesconto() {
		return valorTotalDesconto;
	}

	private void setValorTotalDesconto(BigDecimal valorTotalDesconto) {
		this.valorTotalDesconto = valorTotalDesconto;
	}

	private BigDecimal getValorTotalAcrescimo() {
		return valorTotalAcrescimo;
	}

	private void setValorTotalAcrescimo(BigDecimal valorTotalAcrescimo) {
		this.valorTotalAcrescimo = valorTotalAcrescimo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoVendaItem other = (PedidoVendaItem) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
