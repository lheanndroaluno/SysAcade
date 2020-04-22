package br.com.app.sysacade.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Movimentacao extends GenericDomain {

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date horario;

	@Column(nullable = false, precision = 12, scale = 2)
	private BigDecimal valorMovimentacaoEntrada;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Caixa caixa;

	/**
	 * Método Getters e Setters
	 * 
	 * @return
	 */
	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public BigDecimal getValorMovimentacaoEntrada() {
		return valorMovimentacaoEntrada;
	}

	public void setValorMovimentacaoEntrada(BigDecimal valorMovimentacaoEntrada) {
		this.valorMovimentacaoEntrada = valorMovimentacaoEntrada;
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

}
