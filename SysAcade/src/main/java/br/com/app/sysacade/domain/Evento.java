package br.com.app.sysacade.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
public class Evento extends GenericDomain {

	@Column(length = 30, nullable = false)
	private String titulo;

	@Column(length = 150, nullable = false)
	private String descricao;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date inicioEvento;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fimEvento;

	@Column(nullable = true)
	private boolean status;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Usuario usuario;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getInicioEvento() {
		return inicioEvento;
	}

	public void setInicioEvento(Date inicioEvento) {
		this.inicioEvento = inicioEvento;
	}

	public Date getFimEvento() {
		return fimEvento;
	}

	public void setFimEvento(Date fimEvento) {
		this.fimEvento = fimEvento;
	}

	public boolean isStatus() {
		return status;
	}

	@Transient
	public String getStatus() {
		String statusFormatado = null;

		if (status) {
			statusFormatado = "SIM";
		} else {
			statusFormatado = "NÃO";
		}

		return statusFormatado;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
