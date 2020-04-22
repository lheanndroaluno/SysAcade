package br.com.app.sysacade.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Estado extends GenericDomain {
	@Column(length = 50, nullable = false)
	private String nome;

	@Column(length = 2, nullable = false)
	private String sigla;

	/**
	 * Métodos Getters e Setters
	 * 
	 * @return
	 */
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}
