package br.com.app.sysacade.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.app.sysacade.dao.PersonalDAO;
import br.com.app.sysacade.dao.PessoaDAO;
import br.com.app.sysacade.domain.Personal;
import br.com.app.sysacade.domain.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PersonalBean implements Serializable {

	private Personal personal;
	private List<Personal> personals;
	private List<Pessoa> pessoas;

	/**
	 * Métodos Getters e Setters
	 * 
	 * @return
	 */
	public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	public List<Personal> getPersonals() {
		return personals;
	}

	public void setPersonals(List<Personal> personals) {
		this.personals = personals;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	/**
	 * Método para criar um novo registro
	 */
	public void novo() {
		try {
			personal = new Personal();

			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listarPorCampoOrdenacao("nome");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar criar um novo cliente!");
			erro.printStackTrace();
		}
	}

	@PostConstruct
	public void listarPorCampoOrdenacao() {
		try {
			PersonalDAO personalDAO = new PersonalDAO();
			personals = personalDAO.listarPorCampoOrdenacao("dataAdmissao");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar os professores!");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			PersonalDAO personalDAO = new PersonalDAO();
			personalDAO.merge(personal);

			personal = new Personal();

			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listarPorCampoOrdenacao("nome");

			personals = personalDAO.listar();

			// usando o omnifaces
			Messages.addGlobalInfo("Professor salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar um novo professor!");
			erro.printStackTrace();
		}
	}

	/**
	 * Método para atualizar um registro do banco de dados
	 * 
	 * @param evento
	 */
	public void editar(ActionEvent evento) {
		try {
			personal = (Personal) evento.getComponent().getAttributes().get("linhaSelecionada");

			// populando a lista de pessoas
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listarPorCampoOrdenacao("nome");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar atualizar o professor!");
			erro.printStackTrace();
		}
	}
	
	/**
	 * Método para mostrar os daddos pessoais
	 * @param evento
	 */
	public void mostrarDadospersonal(ActionEvent evento) {
		try {
			personal = (Personal) evento.getComponent().getAttributes().get("linhaSelecionada");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar mostrar dados do cliente!");
			erro.printStackTrace();
		}
	}

	/**
	 * Método para excluir um registro do banco de dados
	 * 
	 * @param evento
	 */
	public void excluir(ActionEvent evento) {
		try {
			personal = (Personal) evento.getComponent().getAttributes().get("linhaSelecionada");

			PersonalDAO personalDAO = new PersonalDAO();
			personalDAO.excluir(personal);

			// atualizando a lista depois da exclusão
			personals = personalDAO.listar();

			// usando o omnifaces
			Messages.addGlobalInfo("Professor excluído com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar excluir o professor!");
			erro.printStackTrace();
		}
	}

}
