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

import br.com.app.sysacade.enums.TipoGenero;
import br.com.app.sysacade.enums.TipoStatusProf;

@SuppressWarnings("serial")
@Entity
public class Personal extends GenericDomain {

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoStatusProf tipoStatusProf;

	@Column(length = 8, nullable = true, unique = true)
	private String cref;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoGenero genero;

	@OneToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;
	
	/**
	 * Métodos Getters e Setters
	 * 
	 * @return
	 */
	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public TipoStatusProf getTipoStatusProf() {
		return tipoStatusProf;
	}

	public void setTipoStatusProf(TipoStatusProf tipoStatusProf) {
		this.tipoStatusProf = tipoStatusProf;
	}

	public String getCref() {
		return cref;
	}

	public void setCref(String cref) {
		this.cref = cref;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public TipoGenero getGenero() {
		return genero;
	}

	public void setGenero(TipoGenero genero) {
		this.genero = genero;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
