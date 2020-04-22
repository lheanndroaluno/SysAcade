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
public class Caixa extends GenericDomain {
	@Column(nullable = false, unique = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAbertura;

	@Column(nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFechamento;

	@Column(nullable = false, precision = 12, scale = 2)
	private BigDecimal valorAbertura;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Funcionario funcionario;

	/**
	 * Método Getters e Setters
	 * 
	 * @return
	 */
	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public BigDecimal getValorAbertura() {
		return valorAbertura;
	}

	public void setValorAbertura(BigDecimal valorAbertura) {
		this.valorAbertura = valorAbertura;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
