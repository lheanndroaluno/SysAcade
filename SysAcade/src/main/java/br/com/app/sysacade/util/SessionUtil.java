package br.com.app.sysacade.util;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class SessionUtil implements Serializable{
	
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static HttpSession getSession() {
		FacesContext contexto = FacesContext.getCurrentInstance();
		HttpSession sessao = (HttpSession) contexto.getExternalContext().getSession(false);
		return sessao;
	}
	
	public static void setParam(String chave, Object valor) {
		getSession().setAttribute(chave, valor);
	}
	
	public static Object getParam(String chave) {
		return getSession().getAttribute(chave);
	}
	
	public static void remove(String chave) {
		getSession().removeAttribute(chave);
	}
	
	public static void invalidate() {
		getSession().invalidate();
	}
	
}
