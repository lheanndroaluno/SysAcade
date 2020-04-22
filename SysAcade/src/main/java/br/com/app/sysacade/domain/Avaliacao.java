package br.com.app.sysacade.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
public class Avaliacao extends GenericDomain {

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataAvaliacao;

	@Column(nullable = false)
	private Character genero;

	@Column(nullable = false)
	private Integer idade;

	@Column(nullable = false, precision = 4, scale = 2)
	private Integer altura;

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

	public Character getGenero() {
		return genero;
	}

	@Transient
	public String getGeneroFormatado() {
		String generoFormatado = null;

		if (genero == 'M') {
			generoFormatado = "Masculino";
		} else if (genero == 'F') {
			generoFormatado = "Feminino";
		}

		return generoFormatado;
	}

	public void setGenero(Character genero) {
		this.genero = genero;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
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
