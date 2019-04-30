package com.example.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "pedido_venda")
public class PedidoVenda implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	//TODO: Criar atributo do vendedor
	@ManyToOne
	@JoinColumn(name = "codigo_vendedor")
	private Vendedor vendedor;
	
	@ManyToOne
	@JoinColumn(name = "codigo_cliente")
	private Pessoa cliente;
	
	@ManyToOne
	@JoinColumn(name = "codigo_fabrica")
	private Fabrica fabrica;
	
	@OneToMany(mappedBy="pedidoVenda", cascade = CascadeType.ALL,
			orphanRemoval = true)
	private List<PedidoVendaItem> pedidoVendaItens;
	
	private String transportadora;
	
	@Column(name="data_emissao")
	private LocalDate dataEmissao;
	
	@Column(name = "valor_total_bruto")
	private BigDecimal valorTotalBruto;
	
	@Column(name = "valor_total_liquido")
	private BigDecimal valorTotalLiquido;
	
	@Column(name = "valor_total_acrescimo")
	private BigDecimal valorTotalAcrescimo;
	
	@Column(name = "valor_total_desconto")
	private BigDecimal valorTotalDesconto;
	
	@Column(name = "valor_total_acrescimo_itens")
	private BigDecimal valorTotalAcrescimoItens;
	
	@Column(name = "valor_total_desconto_itens")
	private BigDecimal valorTotalDescontoItens;
	
	private String observacao;
	
	@Column(name="data_entrega")
	private LocalDate dataEntrega;
	

	
	@Enumerated(EnumType.STRING)
	private StatusPedido statusPedido = StatusPedido.ORCAMENTO;

	
	
	public String getTransportadora() {
		return transportadora;
	}

	public void setTransportadora(String transportadora) {
		this.transportadora = transportadora;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	private Long getCodigo() {
		return codigo;
	}

	private void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	private Pessoa getCliente() {
		return cliente;
	}

	private void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	

	public List<PedidoVendaItem> getPedidoVendaItens() {
		return pedidoVendaItens;
	}

	public void setPedidoVendaItens(List<PedidoVendaItem> pedidoVendaItens) {
		this.pedidoVendaItens = pedidoVendaItens;
	}

	private LocalDate getDataEmissao() {
		return dataEmissao;
	}

	private void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
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

	private BigDecimal getValorTotalAcrescimo() {
		return valorTotalAcrescimo;
	}

	private void setValorTotalAcrescimo(BigDecimal valorTotalAcrescimo) {
		this.valorTotalAcrescimo = valorTotalAcrescimo;
	}

	private BigDecimal getValorTotalDesconto() {
		return valorTotalDesconto;
	}

	private void setValorTotalDesconto(BigDecimal valorTotalDesconto) {
		this.valorTotalDesconto = valorTotalDesconto;
	}

	private BigDecimal getValorTotalAcrescimoItens() {
		return valorTotalAcrescimoItens;
	}

	private void setValorTotalAcrescimoItens(BigDecimal valorTotalAcrescimoItens) {
		this.valorTotalAcrescimoItens = valorTotalAcrescimoItens;
	}

	private BigDecimal getValorTotalDescontoItens() {
		return valorTotalDescontoItens;
	}

	private void setValorTotalDescontoItens(BigDecimal valorTotalDescontoItens) {
		this.valorTotalDescontoItens = valorTotalDescontoItens;
	}

	private String getObservacao() {
		return observacao;
	}

	private void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	private LocalDate getDataEntrega() {
		return dataEntrega;
	}

	private void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	private Fabrica getFabrica() {
		return fabrica;
	}

	private void setFabrica(Fabrica fabrica) {
		this.fabrica = fabrica;
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
		PedidoVenda other = (PedidoVenda) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}	
}
