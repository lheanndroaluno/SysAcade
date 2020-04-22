package br.com.app.sysacade.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.app.sysacade.dao.UsuarioDAO;
import br.com.app.sysacade.domain.Pessoa;
import br.com.app.sysacade.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class AutenticacaoBean implements Serializable {

	private Usuario usuario;
	private Usuario usuarioLogado;

	/**
	 * Métodos Getters e Setters
	 * 
	 * @return
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	@PostConstruct
	public void iniciar() {
		usuario = new Usuario();
		usuario.setPessoa(new Pessoa());
	}

	/*
	 * public void autenticar() { try { UsuarioDAO usuarioDAO = new UsuarioDAO();
	 * usuarioLogado = usuarioDAO.autenticar(usuario.getPessoa().getCpf(),
	 * usuario.getSenha());
	 * 
	 * if (usuarioLogado == null) {
	 * Messages.addGlobalError("CPF e/ou Senha incorretos!"); return; }
	 * 
	 * Faces.redirect("./pages/principal.xhtml"); } catch (IOException erro) {
	 * erro.printStackTrace(); Messages.addFlashGlobalError(erro.getMessage()); } }
	 * 
	 * public boolean temPermissoes(List<String> permissoes) { for (String permissao
	 * : permissoes) { if (usuarioLogado.getTipo() == permissao.charAt(0)) { return
	 * true; } } return false; }
	 */

}
