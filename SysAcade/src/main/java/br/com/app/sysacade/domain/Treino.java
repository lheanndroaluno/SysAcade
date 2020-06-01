package br.com.app.sysacade.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.app.sysacade.enums.Abdominal;
import br.com.app.sysacade.enums.Aerobico;
import br.com.app.sysacade.enums.Biceps;
import br.com.app.sysacade.enums.Costas;
import br.com.app.sysacade.enums.Dorsal;
import br.com.app.sysacade.enums.Gluteos;
import br.com.app.sysacade.enums.MembrosInferiores;
import br.com.app.sysacade.enums.NivelDeTreino;
import br.com.app.sysacade.enums.Ombro;
import br.com.app.sysacade.enums.Peitoral;
import br.com.app.sysacade.enums.TiposDeTreino;
import br.com.app.sysacade.enums.Triceps;

@SuppressWarnings("serial")
@Entity
public class Treino extends GenericDomain {

	@OneToOne
	@JoinColumn(nullable = false)
	private Aluno aluno;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Professor professor;

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
	
	
	
	//musculos
	@ElementCollection(targetClass = Abdominal.class)
	@Column(nullable = true)
	@Enumerated(EnumType.STRING)
	private List<Abdominal> abdominal;
	
	@Column(nullable = true)
	@Enumerated(EnumType.STRING)
	private Biceps biceps;
	
	@Column(nullable = true)
	@Enumerated(EnumType.STRING)
	private Triceps triceps;
	
	@Column(nullable = true)
	@Enumerated(EnumType.STRING)
	private Costas costas;
	
	@Column(nullable = true)
	@Enumerated(EnumType.STRING)
	private Gluteos gluteos;
	
	@Column(nullable = true)
	@Enumerated(EnumType.STRING)
	private Ombro ombro;
	
	@Column(nullable = true)
	@Enumerated(EnumType.STRING)
	private Dorsal dorsal;
	
	@Column(nullable = true)
	@Enumerated(EnumType.STRING)
	private MembrosInferiores membrosInferiores;
	
	@Column(nullable = true)
	@Enumerated(EnumType.STRING)
	private Peitoral peitoral;
	
	
	
	//peso
	@Column(nullable = false)
	private Short pesoParaAbdominal;
	
	@Column(nullable = false)
	private Short pesoParaBiceps;
	
	@Column(nullable = false)
	private Short pesoParaDorsal;
	
	@Column(nullable = false)
	private Short pesoParaTriceps;
	
	@Column(nullable = false)
	private Short pesoParaGluteos;
	
	@Column(nullable = false)
	private Short pesoParaMembrosInferiores;
	
	@Column(nullable = false)
	private Short pesoParaOmbro;
	
	@Column(nullable = false)
	private Short pesoParaPeitoral;
	
	//serie
	
	@Column(nullable = true)
	private Short serieParaAbdominal;
	
	@Column(nullable = true)
	private Short serieParaBiceps;
	
	@Column(nullable = true)
	private Short serieParaDorsal;
	
	@Column(nullable = true)
	private Short serieParaTriceps;
	
	@Column(nullable = true)
	private Short serieParaGluteos;
	
	@Column(nullable = true)
	private Short serieParaMembrosInferiores;
	
	@Column(nullable = true)
	private Short serieParaOmbro;
	
	@Column(nullable = true)
	private Short serieParaPeitoral;
	
	//repetições
	
	@Column(nullable = true)
	private Short repeticaoParaAbdominal;
	
	@Column(nullable = true)
	private Short repeticaoParaBiceps;
	
	@Column(nullable = true)
	private Short repeticaoParaDorsal;
	
	@Column(nullable = true)
	private Short repeticaoParaTriceps;
	
	@Column(nullable = true)
	private Short repeticaoParaGluteos;
	
	@Column(nullable = true)
	private Short repeticaoParaMembrosInferiores;
	
	@Column(nullable = true)
	private Short repeticaoParaOmbro;
	
	@Column(nullable = true)
	private Short repeticaoParaPeitoral;
	
	
	
	
	
	
	/**
	 * Métodos Getters e Setters
	 * 
	 * @return
	 */
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
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

	public NivelDeTreino getNivelDeTreino() {
		return NivelDeTreino;
	}

	public void setNivelDeTreino(NivelDeTreino nivelDeTreino) {
		NivelDeTreino = nivelDeTreino;
	}

	public List<Abdominal> getAbdominal() {
		return abdominal;
	}

	public void setAbdominal(List<Abdominal> abdominal) {
		this.abdominal = abdominal;
	}

	public Biceps getBiceps() {
		return biceps;
	}

	public void setBiceps(Biceps biceps) {
		this.biceps = biceps;
	}

	public Triceps getTriceps() {
		return triceps;
	}

	public void setTriceps(Triceps triceps) {
		this.triceps = triceps;
	}

	public Costas getCostas() {
		return costas;
	}

	public void setCostas(Costas costas) {
		this.costas = costas;
	}

	public Gluteos getGluteos() {
		return gluteos;
	}

	public void setGluteos(Gluteos gluteos) {
		this.gluteos = gluteos;
	}

	public Ombro getOmbro() {
		return ombro;
	}

	public void setOmbro(Ombro ombro) {
		this.ombro = ombro;
	}

	public Dorsal getDorsal() {
		return dorsal;
	}

	public void setDorsal(Dorsal dorsal) {
		this.dorsal = dorsal;
	}

	public MembrosInferiores getMembrosInferiores() {
		return membrosInferiores;
	}

	public void setMembrosInferiores(MembrosInferiores membrosInferiores) {
		this.membrosInferiores = membrosInferiores;
	}

	public Peitoral getPeitoral() {
		return peitoral;
	}

	public void setPeitoral(Peitoral peitoral) {
		this.peitoral = peitoral;
	}

	public Short getPesoParaAbdominal() {
		return pesoParaAbdominal;
	}

	public void setPesoParaAbdominal(Short pesoParaAbdominal) {
		this.pesoParaAbdominal = pesoParaAbdominal;
	}

	public Short getPesoParaBiceps() {
		return pesoParaBiceps;
	}

	public void setPesoParaBiceps(Short pesoParaBiceps) {
		this.pesoParaBiceps = pesoParaBiceps;
	}

	public Short getPesoParaDorsal() {
		return pesoParaDorsal;
	}

	public void setPesoParaDorsal(Short pesoParaDorsal) {
		this.pesoParaDorsal = pesoParaDorsal;
	}

	public Short getPesoParaTriceps() {
		return pesoParaTriceps;
	}

	public void setPesoParaTriceps(Short pesoParaTriceps) {
		this.pesoParaTriceps = pesoParaTriceps;
	}

	public Short getPesoParaGluteos() {
		return pesoParaGluteos;
	}

	public void setPesoParaGluteos(Short pesoParaGluteos) {
		this.pesoParaGluteos = pesoParaGluteos;
	}

	public Short getPesoParaMembrosInferiores() {
		return pesoParaMembrosInferiores;
	}

	public void setPesoParaMembrosInferiores(Short pesoParaMembrosInferiores) {
		this.pesoParaMembrosInferiores = pesoParaMembrosInferiores;
	}

	public Short getPesoParaOmbro() {
		return pesoParaOmbro;
	}

	public void setPesoParaOmbro(Short pesoParaOmbro) {
		this.pesoParaOmbro = pesoParaOmbro;
	}

	public Short getPesoParaPeitoral() {
		return pesoParaPeitoral;
	}

	public void setPesoParaPeitoral(Short pesoParaPeitoral) {
		this.pesoParaPeitoral = pesoParaPeitoral;
	}

	public Short getSerieParaAbdominal() {
		return serieParaAbdominal;
	}

	public void setSerieParaAbdominal(Short serieParaAbdominal) {
		this.serieParaAbdominal = serieParaAbdominal;
	}

	public Short getSerieParaBiceps() {
		return serieParaBiceps;
	}

	public void setSerieParaBiceps(Short serieParaBiceps) {
		this.serieParaBiceps = serieParaBiceps;
	}

	public Short getSerieParaDorsal() {
		return serieParaDorsal;
	}

	public void setSerieParaDorsal(Short serieParaDorsal) {
		this.serieParaDorsal = serieParaDorsal;
	}

	public Short getSerieParaTriceps() {
		return serieParaTriceps;
	}

	public void setSerieParaTriceps(Short serieParaTriceps) {
		this.serieParaTriceps = serieParaTriceps;
	}

	public Short getSerieParaGluteos() {
		return serieParaGluteos;
	}

	public void setSerieParaGluteos(Short serieParaGluteos) {
		this.serieParaGluteos = serieParaGluteos;
	}

	public Short getSerieParaMembrosInferiores() {
		return serieParaMembrosInferiores;
	}

	public void setSerieParaMembrosInferiores(Short serieParaMembrosInferiores) {
		this.serieParaMembrosInferiores = serieParaMembrosInferiores;
	}

	public Short getSerieParaOmbro() {
		return serieParaOmbro;
	}

	public void setSerieParaOmbro(Short serieParaOmbro) {
		this.serieParaOmbro = serieParaOmbro;
	}

	public Short getSerieParaPeitoral() {
		return serieParaPeitoral;
	}

	public void setSerieParaPeitoral(Short serieParaPeitoral) {
		this.serieParaPeitoral = serieParaPeitoral;
	}

	public Short getRepeticaoParaAbdominal() {
		return repeticaoParaAbdominal;
	}

	public void setRepeticaoParaAbdominal(Short repeticaoParaAbdominal) {
		this.repeticaoParaAbdominal = repeticaoParaAbdominal;
	}

	public Short getRepeticaoParaBiceps() {
		return repeticaoParaBiceps;
	}

	public void setRepeticaoParaBiceps(Short repeticaoParaBiceps) {
		this.repeticaoParaBiceps = repeticaoParaBiceps;
	}

	public Short getRepeticaoParaDorsal() {
		return repeticaoParaDorsal;
	}

	public void setRepeticaoParaDorsal(Short repeticaoParaDorsal) {
		this.repeticaoParaDorsal = repeticaoParaDorsal;
	}

	public Short getRepeticaoParaTriceps() {
		return repeticaoParaTriceps;
	}

	public void setRepeticaoParaTriceps(Short repeticaoParaTriceps) {
		this.repeticaoParaTriceps = repeticaoParaTriceps;
	}

	public Short getRepeticaoParaGluteos() {
		return repeticaoParaGluteos;
	}

	public void setRepeticaoParaGluteos(Short repeticaoParaGluteos) {
		this.repeticaoParaGluteos = repeticaoParaGluteos;
	}

	public Short getRepeticaoParaMembrosInferiores() {
		return repeticaoParaMembrosInferiores;
	}

	public void setRepeticaoParaMembrosInferiores(Short repeticaoParaMembrosInferiores) {
		this.repeticaoParaMembrosInferiores = repeticaoParaMembrosInferiores;
	}

	public Short getRepeticaoParaOmbro() {
		return repeticaoParaOmbro;
	}

	public void setRepeticaoParaOmbro(Short repeticaoParaOmbro) {
		this.repeticaoParaOmbro = repeticaoParaOmbro;
	}

	public Short getRepeticaoParaPeitoral() {
		return repeticaoParaPeitoral;
	}

	public void setRepeticaoParaPeitoral(Short repeticaoParaPeitoral) {
		this.repeticaoParaPeitoral = repeticaoParaPeitoral;
	}

}
