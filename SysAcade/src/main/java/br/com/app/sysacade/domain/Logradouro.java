package br.com.app.sysacade.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Logradouro extends GenericDomain {
	@Column(length = 30, nullable = false)
	private String descricao;

	/**
	 * Metodos Getters e Setters
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
