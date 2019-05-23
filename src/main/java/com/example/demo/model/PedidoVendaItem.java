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
	private Long codigo;
	
	@ManyToOne
	@JoinColumn(name = "codigo_pedido_venda")
	private PedidoVenda pedidoVenda;
	
	@ManyToOne
	@JoinColumn(name="codigo_produto")
	private Produto produto;
	
	private int quantidade;
	
	@Column(name = "valor_unitario")
	private BigDecimal valorUnitario;
	
	@Column(name = "valor_total_bruto")
	private BigDecimal valorTotalBruto;
	
	@Column(name = "valor_total_liquido")
	private BigDecimal valorTotalLiquido;
	
	@Column(name = "valor_total_desconto")
	private BigDecimal valorTotalDesconto;	
	
	@Column(name = "valor_total_acrescimo")
	private BigDecimal valorTotalAcrescimo;

	

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public PedidoVenda getPedidoVenda() {
		return pedidoVenda;
	}

	public void setPedidoVenda(PedidoVenda pedidoVenda) {
		this.pedidoVenda = pedidoVenda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public BigDecimal getValorTotalBruto() {
		return valorTotalBruto;
	}

	public void setValorTotalBruto(BigDecimal valorTotalBruto) {
		this.valorTotalBruto = valorTotalBruto;
	}

	public BigDecimal getValorTotalLiquido() {
		return valorTotalLiquido;
	}

	public void setValorTotalLiquido(BigDecimal valorTotalLiquido) {
		this.valorTotalLiquido = valorTotalLiquido;
	}

	public BigDecimal getValorTotalDesconto() {
		return valorTotalDesconto;
	}

	public void setValorTotalDesconto(BigDecimal valorTotalDesconto) {
		this.valorTotalDesconto = valorTotalDesconto;
	}

	public BigDecimal getValorTotalAcrescimo() {
		return valorTotalAcrescimo;
	}

	public void setValorTotalAcrescimo(BigDecimal valorTotalAcrescimo) {
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
