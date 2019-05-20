package com.example.demo.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vendedor")
public class Vendedor implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@OneToOne
	@JoinColumn(name = "codigo_pessoa")
	private Pessoa pessoa;
	
	@Column(name = "data_admissao")
	private LocalDate dataAdmissao;
	
	@Column(name = "data_demissao")
	private LocalDate dataDemissao;
	
	private Boolean ativo;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public LocalDate getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(LocalDate dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public LocalDate getDatademissao() {
		return dataDemissao;
	}

	public void setDatademissao(LocalDate datademissao) {
		this.dataDemissao = datademissao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
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
		Vendedor other = (Vendedor) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
}
