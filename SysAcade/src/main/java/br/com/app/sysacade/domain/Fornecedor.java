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

import br.com.app.sysacade.enums.TipoStatusProf;

@SuppressWarnings("serial")
@Entity
public class Fornecedor extends GenericDomain {

	@Column(length = 100, nullable = false)
	private String razaoSocial;

	@Column(length = 100, nullable = false)
	private String nomeFantasia;

	@Column(length = 25, nullable = false)
	private String cnpj;

	@Column(length = 30)
	private String inscricaoEstadual;

	@Column(length = 30)
	private String inscricaoMunicipal;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoStatusProf status;

	@Column(length = 16, nullable = false)
	private String telFixo;

	@Column(length = 16, nullable = false)
	private String telCelular;

	@Column(length = 50, nullable = false)
	private String email;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Endereco endereco;

	/**
	 * Métodos Getters e Setters
	 * 
	 * @return
	 */
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public TipoStatusProf getStatus() {
		return status;
	}

	public void setStatus(TipoStatusProf status) {
		this.status = status;
	}

	public String getTelFixo() {
		return telFixo;
	}

	public void setTelFixo(String telFixo) {
		this.telFixo = telFixo;
	}

	public String getTelCelular() {
		return telCelular;
	}

	public void setTelCelular(String telCelular) {
		this.telCelular = telCelular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
