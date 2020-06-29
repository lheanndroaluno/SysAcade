package br.com.app.sysacade.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Exercicio extends GenericDomain {

	@Column(length = 50, nullable = false)
	private String grupoMuscular;

	@Column(length = 50, nullable = false)
	private String descricao;

	@Column(length = 20, nullable = false)
	private String peso;

	@Column(length = 20, nullable = false)
	private String serie;

	@Column(length = 20, nullable = false)
	private String repeticao;

	/**
	 * Métodos Getters e Setters
	 * 
	 * @return
	 */

	public String getGrupoMuscular() {
		return grupoMuscular;
	}

	public void setGrupoMuscular(String grupoMuscular) {
		this.grupoMuscular = grupoMuscular;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getRepeticao() {
		return repeticao;
	}

	public void setRepeticao(String repeticao) {
		this.repeticao = repeticao;
	}

}
