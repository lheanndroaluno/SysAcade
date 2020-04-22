package br.com.app.sysacade.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import br.com.app.sysacade.converter.MenuDAO;
import br.com.app.sysacade.domain.Menu;

@ManagedBean
@SessionScoped
public class MenuBean {

	private MenuModel menuModel;

	public MenuModel getMenuModel() {
		return menuModel;
	}

	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}

	@PostConstruct
	public void iniciar() {
		MenuDAO menuDAO = new MenuDAO();

		List<Menu> lista = menuDAO.listar();
		
		menuModel = new DefaultMenuModel();
		
		//esse for é para descobrir os submenus da aplicação
		for (Menu menu : lista) {
			if (menu.getCaminho() == null) {
				DefaultSubMenu subMenu = new DefaultSubMenu(menu.getRotuloMenu());
				//esse for é para listar os menus itens de cada submenus
				for (Menu item : menu.getItensDoMenu()) {
					DefaultMenuItem menuItem = new DefaultMenuItem(item.getRotuloMenu());
					menuItem.setUrl(item.getCaminho());
					
					subMenu.addElement(menuItem);
				}
				
				menuModel.addElement(subMenu);
			}
		}
	}
}
