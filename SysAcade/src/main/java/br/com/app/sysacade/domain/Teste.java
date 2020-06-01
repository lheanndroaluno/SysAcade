package br.com.app.sysacade.domain;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.app.sysacade.enums.TipoComida;

@SuppressWarnings("serial")
@Entity
public class Teste extends GenericDomain {

	@ElementCollection(targetClass = TipoComida.class)
	@Enumerated(EnumType.STRING)
	private List<TipoComida> tiposComida;

	public List<TipoComida> getTiposComida() {
		return tiposComida;
	}

	public void setTiposComida(List<TipoComida> tiposComida) {
		this.tiposComida = tiposComida;
	}

}
