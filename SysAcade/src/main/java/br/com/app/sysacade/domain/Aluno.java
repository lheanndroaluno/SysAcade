package br.com.app.sysacade.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.app.sysacade.enums.TipoEtnia;
import br.com.app.sysacade.enums.TipoGenero;
import br.com.app.sysacade.enums.TipoHorario;
import br.com.app.sysacade.enums.TipoSituacao;
import br.com.app.sysacade.enums.TipoStatus;

@SuppressWarnings("serial")
@Entity
public class Aluno extends GenericDomain {

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataMatricula;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@Column(nullable = true)
	private Short idade;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoHorario horario;

	@Column(nullable = false)
	@Temporal(TemporalType.TIME)
	private Date horarioInicial;

	@Column(nullable = false)
	@Temporal(TemporalType.TIME)
	private Date horarioFinal;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date vencimentoPlano;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoStatus status;

	@Column(length = 100)
	private String obervacao;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoGenero sexo;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoSituacao situacao;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoEtnia etnia;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Plano plano;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;

	/**
	 * Métodos Getters e Setters
	 * 
	 * @return
	 */

	public Plano getPlano() {
		return plano;
	}

	public Date getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setHorarioInicial(Date horarioInicial) {
		this.horarioInicial = horarioInicial;
	}

	public void setHorarioFinal(Date horarioFinal) {
		this.horarioFinal = horarioFinal;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getObervacao() {
		return obervacao;
	}

	public void setObervacao(String obervacao) {
		this.obervacao = obervacao;
	}

	public Date getHorarioInicial() {
		return horarioInicial;
	}

	public Date getHorarioFinal() {
		return horarioFinal;
	}

	public Date getVencimentoPlano() {
		return vencimentoPlano;
	}

	public void setVencimentoPlano(Date vencimentoPlano) {
		this.vencimentoPlano = vencimentoPlano;
	}

	public TipoHorario getHorario() {
		return horario;
	}

	public void setHorario(TipoHorario horario) {
		this.horario = horario;
	}

	public TipoStatus getStatus() {
		return status;
	}

	public void setStatus(TipoStatus status) {
		this.status = status;
	}

	public TipoGenero getSexo() {
		return sexo;
	}

	public void setSexo(TipoGenero sexo) {
		this.sexo = sexo;
	}

	public TipoSituacao getSituacao() {
		return situacao;
	}

	public void setSituacao(TipoSituacao situacao) {
		this.situacao = situacao;
	}

	public TipoEtnia getEtnia() {
		return etnia;
	}

	public void setEtnia(TipoEtnia etnia) {
		this.etnia = etnia;
	}

	public Short getIdade() {
		return idade;
	}

	public void setIdade(Short idade) {
		this.idade = idade;
	}

}
