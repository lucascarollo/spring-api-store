package com.example.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
	private List<PedidoVendaItem> pedidoVendaItens = new ArrayList<>();
	
	private String transportadora;
	
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
	
	@Column(name="data_emissao")
	private LocalDateTime dataEmissao;
	

	
	@Enumerated(EnumType.STRING)
	@Column(name = "status_pedido")
	private StatusPedido statusPedido = StatusPedido.ORCAMENTO;

	
	
	

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	public Fabrica getFabrica() {
		return fabrica;
	}

	public void setFabrica(Fabrica fabrica) {
		this.fabrica = fabrica;
	}

	public List<PedidoVendaItem> getPedidoVendaItens() {
		return pedidoVendaItens;
	}

	public void setPedidoVendaItens(List<PedidoVendaItem> pedidoVendaItens) {
		this.pedidoVendaItens = pedidoVendaItens;
	}

	public String getTransportadora() {
		return transportadora;
	}

	public void setTransportadora(String transportadora) {
		this.transportadora = transportadora;
	}

	public LocalDateTime getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDateTime dataEmissao) {
		this.dataEmissao = dataEmissao;
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

	public BigDecimal getValorTotalAcrescimo() {
		return valorTotalAcrescimo;
	}

	public void setValorTotalAcrescimo(BigDecimal valorTotalAcrescimo) {
		this.valorTotalAcrescimo = valorTotalAcrescimo;
	}

	public BigDecimal getValorTotalDesconto() {
		return valorTotalDesconto;
	}

	public void setValorTotalDesconto(BigDecimal valorTotalDesconto) {
		this.valorTotalDesconto = valorTotalDesconto;
	}

	public BigDecimal getValorTotalAcrescimoItens() {
		return valorTotalAcrescimoItens;
	}

	public void setValorTotalAcrescimoItens(BigDecimal valorTotalAcrescimoItens) {
		this.valorTotalAcrescimoItens = valorTotalAcrescimoItens;
	}

	public BigDecimal getValorTotalDescontoItens() {
		return valorTotalDescontoItens;
	}

	public void setValorTotalDescontoItens(BigDecimal valorTotalDescontoItens) {
		this.valorTotalDescontoItens = valorTotalDescontoItens;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	//SE O CÓDIGO FOR IGUAL A NULL QUER DIZER Q É UMA VENDA NOVA
	public boolean isNova() {
		return codigo == null;
	}
	
	//Aqui é apra que dentro de cada item de venda contenha as informações da venda como o Id da venda
	public void adicionarItens(List<PedidoVendaItem> pedidoVendaItens) {
		this.pedidoVendaItens = pedidoVendaItens;
		this.pedidoVendaItens.forEach(i -> i.setPedidoVenda(this));
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
