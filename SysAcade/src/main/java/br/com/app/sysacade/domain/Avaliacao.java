package br.com.app.sysacade.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.app.sysacade.enums.TipoGenero;

@SuppressWarnings("serial")
@Entity
public class Avaliacao extends GenericDomain {

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataAvaliacao;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoGenero genero;

	@Column(nullable = false)
	private Integer idade;

	@Column(nullable = false, precision = 4, scale = 2)
	private Float altura;

	@Column(nullable = false, precision = 8, scale = 3)
	private Float peso;

	@Column(nullable = false, precision = 8, scale = 3)
	private Float imc;

	/**
	 * Métodos Getters e Setters
	 * 
	 * @return
	 */

	public Date getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(Date dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

	public TipoGenero getGenero() {
		return genero;
	}

	public void setGenero(TipoGenero genero) {
		this.genero = genero;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Float getAltura() {
		return altura;
	}

	public void setAltura(Float altura) {
		this.altura = altura;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public Float getImc() {
		return imc;
	}

	public void setImc(Float imc) {
		this.imc = imc;
	}

}
