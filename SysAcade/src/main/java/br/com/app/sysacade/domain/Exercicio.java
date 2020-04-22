package br.com.app.sysacade.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Exercicio extends GenericDomain {
	@Column(length = 20, nullable = false)
	private String descricao;

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

}
