package br.com.app.sysacade.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Endereco extends GenericDomain {
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Logradouro logradouro;
	
	@Column(length = 80, nullable = false)
	private String nomeEnd;
	
	@Column(nullable = false)
	private Short numero;
	
	@Column(length = 50, nullable = false)
	private String bairro;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Cidade cidade;
	
	@Column(length = 10, nullable = false)
	private String cep;
	
	@Column(length = 30, nullable = true)
	private String complemento;

	/**
	 * Métodos Getters e Setters
	 * 
	 * @return
	 */
	public Logradouro getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	public String getNomeEnd() {
		return nomeEnd;
	}

	public void setNomeEnd(String nomeEnd) {
		this.nomeEnd = nomeEnd;
	}

	public Short getNumero() {
		return numero;
	}

	public void setNumero(Short numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
