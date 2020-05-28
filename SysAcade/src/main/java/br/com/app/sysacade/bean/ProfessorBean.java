package br.com.app.sysacade.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.app.sysacade.dao.PessoaDAO;
import br.com.app.sysacade.dao.ProfessorDAO;
import br.com.app.sysacade.domain.Pessoa;
import br.com.app.sysacade.domain.Professor;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProfessorBean implements Serializable {

	private Professor professor;
	private List<Professor> professores;
	private List<Pessoa> pessoas;

	/**
	 * Métodos Getters e Setters
	 * 
	 * @return
	 */
	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
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
			professor = new Professor();

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
			ProfessorDAO professorDAO = new ProfessorDAO();
			professores = professorDAO.listarPorCampoOrdenacao("dataAdmissao");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar os professores!");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			ProfessorDAO professorDAO = new ProfessorDAO();
			professorDAO.merge(professor);

			professor = new Professor();

			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listarPorCampoOrdenacao("nome");

			professores = professorDAO.listar();

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
			professor = (Professor) evento.getComponent().getAttributes().get("linhaSelecionada");

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
	 * 
	 * @param evento
	 */
	public void mostrarDadosProfessor(ActionEvent evento) {
		try {
			professor = (Professor) evento.getComponent().getAttributes().get("linhaSelecionada");
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
			professor = (Professor) evento.getComponent().getAttributes().get("linhaSelecionada");

			ProfessorDAO professorDAO = new ProfessorDAO();
			professorDAO.excluir(professor);

			// atualizando a lista depois da exclusão
			professores = professorDAO.listar();

			// usando o omnifaces
			Messages.addGlobalInfo("Professor excluído com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar excluir o professor!");
			erro.printStackTrace();
		}
	}
}
