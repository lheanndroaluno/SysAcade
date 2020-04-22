package br.com.app.sysacade.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.app.sysacade.converter.MenuDAO;
import br.com.app.sysacade.domain.Menu;

public class MenuDAOTeste {
	@Test
	@Ignore
	public void listar() {
		MenuDAO menuDAO = new MenuDAO();
		
		List<Menu> lista = menuDAO.listar();
		
		for (Menu menu : lista) {
			System.out.println(menu.getRotuloMenu() + "-" + menu.getCaminho());
			for (Menu itemMenu : menu.getItensDoMenu()) {
				System.out.println("\t" + itemMenu.getRotuloMenu() + " - " + itemMenu.getCaminho());
			}
		}
	}
}
