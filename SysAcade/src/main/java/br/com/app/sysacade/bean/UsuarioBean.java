package br.com.app.sysacade.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.app.sysacade.dao.PessoaDAO;
import br.com.app.sysacade.dao.UsuarioDAO;
import br.com.app.sysacade.domain.Pessoa;
import br.com.app.sysacade.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {
	
	private Usuario usuario;
	private List<Usuario> usuarios;
	private List<Pessoa> pessoas;

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

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public void novo() {
		try {
			usuario = new Usuario();

			// populando a lista de pessoas
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listarPorCampoOrdenacao("nome");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar criar uma nova pessoa!");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.merge(usuario);

			usuario = new Usuario();
			usuarios = usuarioDAO.listarPorCampoOrdenacao("tipoUsuario");

			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listarPorCampoOrdenacao("nome");

			// usando o omnifaces
			Messages.addGlobalInfo("Usuário salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar um novo usuário");
			erro.printStackTrace();
		}
	}

	@PostConstruct
	public void listarPorCampoOrdenacao() {
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarios = usuarioDAO.listarPorCampoOrdenacao("tipoUsuario");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar os usuários!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			usuario = (Usuario) evento.getComponent().getAttributes().get("linhaSelecionada");

			// populando a lista de pessoas
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listarPorCampoOrdenacao("nome");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar atualizar o usuário");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			usuario = (Usuario) evento.getComponent().getAttributes().get("linhaSelecionada");

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.excluir(usuario);

			// atualizando a lista depois da exclusão
			usuarios = usuarioDAO.listar();

			// usando o omnifaces
			Messages.addGlobalInfo("Usuário excluído com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar excluir o usuário");
			erro.printStackTrace();
		}
	}
}
