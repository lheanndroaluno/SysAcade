package br.com.app.sysacade.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.app.sysacade.enums.TipoFuncao;

@SuppressWarnings("serial")
@Entity
public class Funcionario extends GenericDomain {

	@Column(length = 12, nullable = false, unique = true) // exemplo: MATRIZ01****
	private String matricula;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoFuncao funcao;

	@Column(length = 25, nullable = false)
	private String numeroCT;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataAdmissao;

	@Column(length = 25, nullable = false)
	private String numeroReservista;

	@OneToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;

	/**
	 * Métodos Getters e Setters
	 * 
	 * @return
	 */
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public TipoFuncao getFuncao() {
		return funcao;
	}

	public void setFuncao(TipoFuncao funcao) {
		this.funcao = funcao;
	}

	public String getNumeroCT() {
		return numeroCT;
	}

	public void setNumeroCT(String numeroCT) {
		this.numeroCT = numeroCT;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public String getNumeroReservista() {
		return numeroReservista;
	}

	public void setNumeroReservista(String numeroReservista) {
		this.numeroReservista = numeroReservista;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
