package br.com.app.sysacade.util;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

import org.omnifaces.util.Faces;

import br.com.app.sysacade.bean.AutenticacaoBean;
import br.com.app.sysacade.domain.Usuario;

@SuppressWarnings("serial")
public class AutenticacaoListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent event) {

		String paginaAtual = Faces.getViewId();// Faces.getViewId serve para pegar a página atual ou página corrente

		boolean paginaDeAutenticacao = paginaAtual.contains("autenticacao.xhtml");
		// ! não é página de autenticação
		if (!paginaDeAutenticacao) {
			// autenticaçaoBean é um objeto temporario
			// Faces é um componente do omnifaces
			AutenticacaoBean autenticacaoBean = Faces.getSessionAttribute("autenticacaoBean");

			if (autenticacaoBean == null) {
				// força o usuário a ir para a tela de autenticação
				Faces.navigate("/pages/autenticacao.xhtml");
				return;
			}

			Usuario usuario = autenticacaoBean.getUsuarioLogado();

			if (usuario == null) {
				Faces.navigate("/pages/autenticacao.xhtml");
				return;
			}
		}

	}

	public Object getAtributoSessao(String attributeName) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		if (session != null) {
			return session.getAttribute(attributeName);
		}
		return null;
	}

	@Override
	public void beforePhase(PhaseEvent event) {

	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
