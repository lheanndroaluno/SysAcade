package br.com.app.sysacade.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@SuppressWarnings("serial")
@Entity
public class Menu extends GenericDomain {

	@Column(length = 50, nullable = false)
	private String rotuloMenu;

	@Column(length = 50)
	private String caminho;

	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JoinColumn(referencedColumnName = "codigo")
	private List<Menu> itensDoMenu;

	public String getRotuloMenu() {
		return rotuloMenu;
	}

	public void setRotuloMenu(String rotuloMenu) {
		this.rotuloMenu = rotuloMenu;
	}

	public List<Menu> getItensDoMenu() {
		return itensDoMenu;
	}

	public void setItensDoMenu(List<Menu> itensDoMenu) {
		this.itensDoMenu = itensDoMenu;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

}
