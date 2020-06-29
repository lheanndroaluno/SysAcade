package br.com.app.sysacade.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HibernateContexto implements ServletContextListener {
	
	@Override //quando desliga o tomcat
    public void contextDestroyed(ServletContextEvent event) {
        HibernateUtil.getFabricaDeSessoes().close();
        
    }

    @Override //quando liga o tomcat
    public void contextInitialized(ServletContextEvent event) {
        HibernateUtil.getFabricaDeSessoes().openSession(); /*forçar criação da fabrica de sessões 
        quando o tomcat for iniciado  */
		
	}

}
