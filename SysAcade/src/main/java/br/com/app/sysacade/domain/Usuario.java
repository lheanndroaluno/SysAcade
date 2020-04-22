package br.com.app.sysacade.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import br.com.app.sysacade.enums.TipoUsuario;

@SuppressWarnings("serial")
@Entity
public class Usuario extends GenericDomain {
	/*
	 * @Column(nullable = false) private Character tipo;
	 */
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipoUsuario;

	@Column(length = 32, nullable = false)
	private String senha;

	@Transient
	private String senhaSemCriptografia;

	@Column(nullable = false)
	private Boolean ativo;

	@OneToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;

	/**
	 * Métodos Getters e Setters
	 * 
	 * @return
	 */

	/*
	 * public Character getTipo() { return tipo; }
	 * 
	 * @Transient public String getTipoFormatado() { String tipoFormatado = null;
	 * 
	 * if (tipo == 'A') { tipoFormatado = "Administrador"; } else if (tipo == 'B') {
	 * tipoFormatado = "Balconista"; } else if (tipo == 'D') { tipoFormatado =
	 * "Diretor"; } else if (tipo == 'G') { tipoFormatado = "Gerente"; } else if
	 * (tipo == 'U') { tipoFormatado = "Usuario"; } else if (tipo == 'P') {
	 * tipoFormatado = "Personal"; }
	 * 
	 * return tipoFormatado; }
	 * 
	 * public void setTipo(Character tipo) { this.tipo = tipo; }
	 */

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	@Transient
	public String getAtivoFormatado() {
		String ativoFormatado = null;

		if (ativo) {
			ativoFormatado = "Sim";
		} else {
			ativoFormatado = "Não";
		}

		return ativoFormatado;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getSenhaSemCriptografia() {
		return senhaSemCriptografia;
	}

	public void setSenhaSemCriptografia(String senhaSemCriptografia) {
		this.senhaSemCriptografia = senhaSemCriptografia;
	}

}
