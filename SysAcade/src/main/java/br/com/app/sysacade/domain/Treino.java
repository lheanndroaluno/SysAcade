package br.com.app.sysacade.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.app.sysacade.enums.Aerobico;
import br.com.app.sysacade.enums.NivelDeTreino;
import br.com.app.sysacade.enums.TiposDeTreino;

@SuppressWarnings("serial")
@Entity
public class Treino extends GenericDomain {

	@OneToOne
	@JoinColumn(nullable = false)
	private Aluno aluno;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Personal personal;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataInicio;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private NivelDeTreino NivelDeTreino;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TiposDeTreino objetivo;

	@Column(length = 200, nullable = true)
	private String anamnese;

	@Column(nullable = true)
	@Enumerated(EnumType.STRING)
	private Aerobico aerobico;

	@Column(length = 200, nullable = true)
	private String observacao;

	/**
	 * métodos Getters e Setters
	 * 
	 * @return
	 */
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public NivelDeTreino getNivelDeTreino() {
		return NivelDeTreino;
	}

	public void setNivelDeTreino(NivelDeTreino nivelDeTreino) {
		NivelDeTreino = nivelDeTreino;
	}

	public TiposDeTreino getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(TiposDeTreino objetivo) {
		this.objetivo = objetivo;
	}

	public String getAnamnese() {
		return anamnese;
	}

	public void setAnamnese(String anamnese) {
		this.anamnese = anamnese;
	}

	public Aerobico getAerobico() {
		return aerobico;
	}

	public void setAerobico(Aerobico aerobico) {
		this.aerobico = aerobico;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
