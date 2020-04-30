package br.com.app.sysacade.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.app.sysacade.enums.TipoDeMusculo;
import br.com.app.sysacade.enums.TipoDeTreino;
import br.com.app.sysacade.enums.TipoGenero;

@SuppressWarnings("serial")
@Entity
public class Exercicio extends GenericDomain {

	@Column(length = 40, nullable = false)
	private String descricao;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoDeMusculo tipoDeMusculo;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoDeTreino tipoDeTreino;

	@Column(length = 20, nullable = false)
	private String peso;

	@Column(length = 20, nullable = false)
	private String serie;

	@Column(length = 20, nullable = false)
	private String repeticoes;

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

	public TipoDeMusculo getTipoDeMusculo() {
		return tipoDeMusculo;
	}

	public void setTipoDeMusculo(TipoDeMusculo tipoDeMusculo) {
		this.tipoDeMusculo = tipoDeMusculo;
	}

	public TipoDeTreino getTipoDeTreino() {
		return tipoDeTreino;
	}

	public void setTipoDeTreino(TipoDeTreino tipoDeTreino) {
		this.tipoDeTreino = tipoDeTreino;
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

	public String getRepeticoes() {
		return repeticoes;
	}

	public void setRepeticoes(String repeticoes) {
		this.repeticoes = repeticoes;
	}

}
