package br.com.app.sysacade.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.app.sysacade.enums.FormaDePagamento;
import br.com.app.sysacade.enums.MesDeReferencia;

@SuppressWarnings("serial")
@Entity
public class Pagamento extends GenericDomain {

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date horario;

	@Column(nullable = false, precision = 12, scale = 2)
	private BigDecimal valor;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Aluno aluno;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Plano plano;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private FormaDePagamento formaDePagamento;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private MesDeReferencia mesDeReferencia;

	/**
	 * Métodos Getters e Setters
	 * 
	 * @return
	 */
	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public FormaDePagamento getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public MesDeReferencia getMesDeReferencia() {
		return mesDeReferencia;
	}

	public void setMesDeReferencia(MesDeReferencia mesDeReferencia) {
		this.mesDeReferencia = mesDeReferencia;
	}

}
