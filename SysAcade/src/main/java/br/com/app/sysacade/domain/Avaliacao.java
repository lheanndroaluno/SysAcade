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
import javax.persistence.Transient;

import br.com.app.sysacade.enums.TipoGenero;
import br.com.app.sysacade.enums.TipoPostura;
import br.com.app.sysacade.enums.TipoSanguineo;

@SuppressWarnings("serial")
@Entity
public class Avaliacao extends GenericDomain {

	@ManyToOne
	@JoinColumn(nullable = false)
	private Aluno aluno;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataAvaliacao;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoGenero genero;

	@Column(nullable = false)
	private Short idade;

	@Column(nullable = false, precision = 4, scale = 2)
	private Short altura;

	@Column(nullable = false, precision = 8, scale = 3)
	private Short peso;

	@Column(nullable = false, precision = 8, scale = 3)
	private Short imc;

	@Column(nullable = false)
	private Short pressaoArterial;

	@Column(nullable = false)
	private Boolean doencasAnteriores;

	@Column(length = 50, nullable = true)
	private String qualDA;

	@Column(nullable = false)
	private Boolean usaMedicacao;

	@Column(length = 50, nullable = true)
	private String qualM;

	@Column(nullable = false)
	private Boolean lesoesAnteriores;

	@Column(length = 50, nullable = true)
	private String qualLA;

	@Column(nullable = false)
	private Boolean fumante;

	@Column(nullable = false)
	private Boolean alergias;

	@Column(nullable = false)
	private Boolean cirurgia;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoSanguineo tipoSanguineo;

	@Column(nullable = false)
	private Short gorduraAbsolut;

	@Column(nullable = false)
	private Short massaMagra;

	@Column(nullable = false)
	private Short pesoIdeal;

	@Column(nullable = false)
	private Short pesoExcesso;

	@Column(nullable = false)
	private Short pesoResidual;

	@Column(nullable = false)
	private Short gordura;

	@Column(nullable = false)
	private Short torax;

	@Column(nullable = false)
	private Short cintura;

	@Column(nullable = false)
	private Short abdomen;

	@Column(nullable = false)
	private Short quadril;

	@Column(nullable = false)
	private Short coxaProximalDireito;

	@Column(nullable = false)
	private Short coxaProximalEsquerdo;

	@Column(nullable = false)
	private Short panturrilhaDireito;

	@Column(nullable = false)
	private Short panturrilhaesquerdo;

	@Column(nullable = false)
	private Short bracoNormalDireito;

	@Column(nullable = false)
	private Short bracoNormalEsquerdo;

	@Column(nullable = false)
	private Short anteBracoDireito;

	@Column(nullable = false)
	private Short anteBracoEsquerdo;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoPostura tipoPostura;

	@Column(nullable = false)
	private Short rmlAbdomen;

	@Column(nullable = false)
	private Short rmlBraco;

	/**
	 * Getters e Setters
	 * 
	 * @return
	 */
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

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

	public Short getIdade() {
		return idade;
	}

	public void setIdade(Short idade) {
		this.idade = idade;
	}

	public Short getAltura() {
		return altura;
	}

	public void setAltura(Short altura) {
		this.altura = altura;
	}

	public Short getPeso() {
		return peso;
	}

	public void setPeso(Short peso) {
		this.peso = peso;
	}

	public Short getImc() {
		return imc;
	}

	public void setImc(Short imc) {
		this.imc = imc;
	}

	public Short getPressaoArterial() {
		return pressaoArterial;
	}

	public void setPressaoArterial(Short pressaoArterial) {
		this.pressaoArterial = pressaoArterial;
	}

	public Boolean getDoencasAnteriores() {
		return doencasAnteriores;
	}

	public void setDoencasAnteriores(Boolean doencasAnteriores) {
		this.doencasAnteriores = doencasAnteriores;
	}

	public String getQualDA() {
		return qualDA;
	}

	public void setQualDA(String qualDA) {
		this.qualDA = qualDA;
	}

	public Boolean getUsaMedicacao() {
		return usaMedicacao;
	}

	@Transient
	public String getMedicacaoFormatado() {
		String medicacaoFormatado = null;

		if (usaMedicacao) {
			medicacaoFormatado = "Sim";
		} else {
			medicacaoFormatado = "Não";
		}

		return medicacaoFormatado;
	}

	public void setUsaMedicacao(Boolean usaMedicacao) {
		this.usaMedicacao = usaMedicacao;
	}

	public String getQualM() {
		return qualM;
	}

	public void setQualM(String qualM) {
		this.qualM = qualM;
	}

	public Boolean getLesoesAnteriores() {
		return lesoesAnteriores;
	}

	@Transient
	public String getLAFormatado() {
		String lessaoAFormatado = null;

		if (lesoesAnteriores) {
			lessaoAFormatado = "Sim";
		} else {
			lessaoAFormatado = "Não";
		}

		return lessaoAFormatado;
	}

	public void setLesoesAnteriores(Boolean lesoesAnteriores) {
		this.lesoesAnteriores = lesoesAnteriores;
	}

	public String getQualLA() {
		return qualLA;
	}

	public void setQualLA(String qualLA) {
		this.qualLA = qualLA;
	}

	public Boolean getFumante() {
		return fumante;
	}

	@Transient
	public String getFumanteFormatado() {
		String fumanteFormatado = null;

		if (fumante) {
			fumanteFormatado = "Sim";
		} else {
			fumanteFormatado = "Não";
		}

		return fumanteFormatado;
	}

	public void setFumante(Boolean fumante) {
		this.fumante = fumante;
	}

	public Boolean getAlergias() {
		return alergias;
	}

	@Transient
	public String getAlergiasFormatado() {
		String alergiasFormatado = null;

		if (alergias) {
			alergiasFormatado = "Sim";
		} else {
			alergiasFormatado = "Não";
		}

		return alergiasFormatado;
	}

	public void setAlergias(Boolean alergias) {
		this.alergias = alergias;
	}

	public Boolean getCirurgia() {
		return cirurgia;
	}

	@Transient
	public String getCirurgiaFormatado() {
		String cirurgiaFormatado = null;

		if (cirurgia) {
			cirurgiaFormatado = "Sim";
		} else {
			cirurgiaFormatado = "Não";
		}

		return cirurgiaFormatado;
	}

	public void setCirurgia(Boolean cirurgia) {
		this.cirurgia = cirurgia;
	}

	public TipoSanguineo getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	public Short getGorduraAbsolut() {
		return gorduraAbsolut;
	}

	public void setGorduraAbsolut(Short gorduraAbsolut) {
		this.gorduraAbsolut = gorduraAbsolut;
	}

	public Short getMassaMagra() {
		return massaMagra;
	}

	public void setMassaMagra(Short massaMagra) {
		this.massaMagra = massaMagra;
	}

	public Short getPesoIdeal() {
		return pesoIdeal;
	}

	public void setPesoIdeal(Short pesoIdeal) {
		this.pesoIdeal = pesoIdeal;
	}

	public Short getPesoExcesso() {
		return pesoExcesso;
	}

	public void setPesoExcesso(Short pesoExcesso) {
		this.pesoExcesso = pesoExcesso;
	}

	public Short getPesoResidual() {
		return pesoResidual;
	}

	public void setPesoResidual(Short pesoResidual) {
		this.pesoResidual = pesoResidual;
	}

	public Short getGordura() {
		return gordura;
	}

	public void setGordura(Short gordura) {
		this.gordura = gordura;
	}

	public Short getTorax() {
		return torax;
	}

	public void setTorax(Short torax) {
		this.torax = torax;
	}

	public Short getCintura() {
		return cintura;
	}

	public void setCintura(Short cintura) {
		this.cintura = cintura;
	}

	public Short getAbdomen() {
		return abdomen;
	}

	public void setAbdomen(Short abdomen) {
		this.abdomen = abdomen;
	}

	public Short getQuadril() {
		return quadril;
	}

	public void setQuadril(Short quadril) {
		this.quadril = quadril;
	}

	public Short getCoxaProximalDireito() {
		return coxaProximalDireito;
	}

	public void setCoxaProximalDireito(Short coxaProximalDireito) {
		this.coxaProximalDireito = coxaProximalDireito;
	}

	public Short getCoxaProximalEsquerdo() {
		return coxaProximalEsquerdo;
	}

	public void setCoxaProximalEsquerdo(Short coxaProximalEsquerdo) {
		this.coxaProximalEsquerdo = coxaProximalEsquerdo;
	}

	public Short getPanturrilhaDireito() {
		return panturrilhaDireito;
	}

	public void setPanturrilhaDireito(Short panturrilhaDireito) {
		this.panturrilhaDireito = panturrilhaDireito;
	}

	public Short getPanturrilhaesquerdo() {
		return panturrilhaesquerdo;
	}

	public void setPanturrilhaesquerdo(Short panturrilhaesquerdo) {
		this.panturrilhaesquerdo = panturrilhaesquerdo;
	}

	public Short getBracoNormalDireito() {
		return bracoNormalDireito;
	}

	public void setBracoNormalDireito(Short bracoNormalDireito) {
		this.bracoNormalDireito = bracoNormalDireito;
	}

	public Short getBracoNormalEsquerdo() {
		return bracoNormalEsquerdo;
	}

	public void setBracoNormalEsquerdo(Short bracoNormalEsquerdo) {
		this.bracoNormalEsquerdo = bracoNormalEsquerdo;
	}

	public Short getAnteBracoDireito() {
		return anteBracoDireito;
	}

	public void setAnteBracoDireito(Short anteBracoDireito) {
		this.anteBracoDireito = anteBracoDireito;
	}

	public Short getAnteBracoEsquerdo() {
		return anteBracoEsquerdo;
	}

	public void setAnteBracoEsquerdo(Short anteBracoEsquerdo) {
		this.anteBracoEsquerdo = anteBracoEsquerdo;
	}

	public TipoPostura getTipoPostura() {
		return tipoPostura;
	}

	public void setTipoPostura(TipoPostura tipoPostura) {
		this.tipoPostura = tipoPostura;
	}

	public Short getRmlAbdomen() {
		return rmlAbdomen;
	}

	public void setRmlAbdomen(Short rmlAbdomen) {
		this.rmlAbdomen = rmlAbdomen;
	}

	public Short getRmlBraco() {
		return rmlBraco;
	}

	public void setRmlBraco(Short rmlBraco) {
		this.rmlBraco = rmlBraco;
	}

}
