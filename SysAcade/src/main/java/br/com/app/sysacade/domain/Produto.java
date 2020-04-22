package br.com.app.sysacade.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
public class Produto extends GenericDomain {
	@Column(length = 80, nullable = false)
	private String descricao;
	@Column(nullable = false)
	private Short quantidade;
	@Column(nullable = false, precision = 12, scale = 2)
	private BigDecimal preco;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Fornecedor fornecedor;

	// serve para guardar um avriável temporária
	@Transient
	private String caminho;

	/**
	 * Métodos Getters e Setters
	 * 
	 * @return
	 */
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Short getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Short quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

}
