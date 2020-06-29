package br.com.app.sysacade.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@SuppressWarnings("serial")
@Entity
public class Teste extends GenericDomain {

	@ManyToMany
	@JoinColumn(nullable = true)
	private List<TipoDeMusculo> tipoDeMusculos;

	public List<TipoDeMusculo> getTipoDeMusculos() {
		return tipoDeMusculos;
	}

	public void setTipoDeMusculos(List<TipoDeMusculo> tipoDeMusculos) {
		this.tipoDeMusculos = tipoDeMusculos;
	}
	
	

}
