package br.com.app.sysacade.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.app.sysacade.dao.LogradouroDAO;
import br.com.app.sysacade.domain.Logradouro;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class LogradouroBean implements Serializable {
	private Logradouro logradouro;
	private List<Logradouro> logradouros;

	/**
	 * Métodos Getters e Setters
	 * 
	 * @return
	 */
	public Logradouro getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	public List<Logradouro> getLogradouros() {
		return logradouros;
	}

	public void setLogradouros(List<Logradouro> logradouros) {
		this.logradouros = logradouros;
	}

	public void novo() {
		logradouro = new Logradouro();
	}

	public void salvar() {
		try {
			LogradouroDAO logradouroDAO = new LogradouroDAO();
			logradouroDAO.merge(logradouro);
			novo();
			logradouros = logradouroDAO.listar();

			// usando ominifaces
			Messages.addFlashGlobalInfo("Registro salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar um novo registro!");
			erro.printStackTrace();
		}
	}

	@PostConstruct
	public void listar() {
		try {
			LogradouroDAO logradouroDAO = new LogradouroDAO();
			logradouros = logradouroDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar todos os registros!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		logradouro = (Logradouro) evento.getComponent().getAttributes().get("linhaSelecionada");
	}

	public void excluir(ActionEvent evento) {
		try {
			logradouro = (Logradouro) evento.getComponent().getAttributes().get("linhaSelecionada");

			LogradouroDAO logradouroDAO = new LogradouroDAO();
			logradouroDAO.excluir(logradouro);

			// atualizando a lista depois da exclusão
			logradouros = logradouroDAO.listar();

			Messages.addGlobalInfo("Registro excluído com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar excluir o registro!");
			erro.printStackTrace();
		}
	}
}
