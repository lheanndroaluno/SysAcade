package br.com.app.sysacade.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.app.sysacade.dao.FuncionarioDAO;
import br.com.app.sysacade.dao.PessoaDAO;
import br.com.app.sysacade.domain.Funcionario;
import br.com.app.sysacade.domain.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FuncionarioBean implements Serializable {
	private Funcionario funcionario;
	private List<Funcionario> funcionarios;
	private List<Pessoa> pessoas;

	/**
	 * Métodos Getters e Setters
	 * 
	 * @return
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
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
			funcionario = new Funcionario();

			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listarPorCampoOrdenacao("nome");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar criar um novo funcionário!");
			erro.printStackTrace();
		}
	}

	/**
	 * Método para listar todos os registros do banco de dados
	 */
	@PostConstruct
	public void listar() {
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarios = funcionarioDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar os funcionarios!");
			erro.printStackTrace();
		}
	}

	/**
	 * Método para salvar um novo registro no banco de dados
	 */
	public void salvar() {
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioDAO.merge(funcionario);

			funcionario = new Funcionario();

			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listarPorCampoOrdenacao("nome");

			funcionarios = funcionarioDAO.listar();

			// usando o omnifaces
			Messages.addGlobalInfo("Funcionário salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar um novo funcionário!");
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
			funcionario = (Funcionario) evento.getComponent().getAttributes().get("linhaSelecionada");

			// populando a lista de pessoas
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listarPorCampoOrdenacao("nome");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar atualizar o funcionário!");
			erro.printStackTrace();
		}
	}
	
	/**
	 * Método para mostrar os daddos pessoais
	 * @param evento
	 */
	public void mostrarDadosFuncionario(ActionEvent evento) {
		try {
			funcionario = (Funcionario) evento.getComponent().getAttributes().get("linhaSelecionada");
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
			funcionario = (Funcionario) evento.getComponent().getAttributes().get("linhaSelecionada");

			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioDAO.excluir(funcionario);

			// atualizando a lista depois da exclusão
			funcionarios = funcionarioDAO.listar();

			// usando o omnifaces
			Messages.addGlobalInfo("Funcionário excluído com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar excluir o funcionário!");
			erro.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	public void gerarMatrícula() {
		Random aleatorio = new Random();
		int numero = aleatorio.nextInt(100000);
	}
}
