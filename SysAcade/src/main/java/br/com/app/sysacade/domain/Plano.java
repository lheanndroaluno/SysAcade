package br.com.app.sysacade.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.app.sysacade.enums.Quantidade_Meses;

@SuppressWarnings("serial")
@Entity
public class Plano extends GenericDomain {

	@Column(length = 30, nullable = false)
	private String descricao;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Quantidade_Meses quantMeses;

	@Column(nullable = false, precision = 12, scale = 2)
	private BigDecimal valor;

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

	public Quantidade_Meses getQuantMeses() {
		return quantMeses;
	}

	public void setQuantMeses(Quantidade_Meses quantMeses) {
		this.quantMeses = quantMeses;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
