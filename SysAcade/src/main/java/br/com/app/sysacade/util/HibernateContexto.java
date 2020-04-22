package br.com.app.sysacade.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HibernateContexto implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent evento) {
		HibernateUtil.getFabricaDeSessoes().openSession();
	}

	@Override
	public void contextDestroyed(ServletContextEvent evento) {
		HibernateUtil.getFabricaDeSessoes().close();
	}

}
