package br.com.app.sysacade.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.app.sysacade.dao.CidadeDAO;
import br.com.app.sysacade.dao.EnderecoDAO;
import br.com.app.sysacade.dao.EstadoDAO;
import br.com.app.sysacade.dao.PessoaDAO;
import br.com.app.sysacade.domain.Cidade;
import br.com.app.sysacade.domain.Endereco;
import br.com.app.sysacade.domain.Estado;
import br.com.app.sysacade.domain.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PessoaBean implements Serializable {
	private Pessoa pessoa;
	private List<Pessoa> pessoas;

	private Estado estado;
	private List<Estado> estados;

	private Cidade cidade;
	private List<Cidade> cidades;

	private Endereco endereco;
	private List<Endereco> enderecos;

	/**
	 * Métodos Getters e Setters
	 * 
	 * @return
	 */
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	/**
	 * Método do botão novo
	 */
	public void novo() {
		try {
			pessoa = new Pessoa();

			estado = new Estado();

			cidade = new Cidade();

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listarPorCampoOrdenacao("nome");

			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listarPorCampoOrdenacao("nome");

			enderecos = new ArrayList<>();

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar cadastrar uma nova pessoa!");
			erro.printStackTrace();
		}
	}

	/**
	 * Método salvar um novo regsotro no banco de dados
	 */
	public void salvar() {
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.merge(pessoa);

			// limpando as dados da pessoa
			pessoa = new Pessoa();

			estado = new Estado();

			cidade = new Cidade();

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listarPorCampoOrdenacao("nome");

			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listarPorCampoOrdenacao("nome");

			enderecos = new ArrayList<>();

			pessoas = pessoaDAO.listarPorCampoOrdenacao("nome");

			// usando o omnifaces
			Messages.addGlobalInfo("Pessoa salva com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar uma nova pessoa!");
			erro.printStackTrace();
		}
	}

	@PostConstruct
	public void listar() {
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listarPorCampoOrdenacao("nome");

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar as pessoas!");
			erro.printStackTrace();
		}
	}

	/**
	 * Método para atualizar um registro do bando de dados
	 */
	public void editar(ActionEvent evento) {
		try {
			pessoa = (Pessoa) evento.getComponent().getAttributes().get("linhaSelecionada");

			estado = pessoa.getEndereco().getCidade().getEstado();

			cidade = pessoa.getEndereco().getCidade();

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listarPorCampoOrdenacao("nome");

			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listarPorCampoOrdenacao("nome");

			EnderecoDAO enderecoDAO = new EnderecoDAO();
			enderecos = enderecoDAO.listarPorCampoOrdenacao("nomeEnd");

			cidades = cidadeDAO.buscarPorEstado(estado.getCodigo());

			enderecos = enderecoDAO.buscarPorCidade(cidade.getCodigo());

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar atualizar a pessoa!");
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
			pessoa = (Pessoa) evento.getComponent().getAttributes().get("linhaSelecionada");

			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.excluir(pessoa);

			// atualizando a lista depois da exclusão
			pessoas = pessoaDAO.listar();

			// usando o omnifaces
			Messages.addGlobalInfo("Pessoa excluída com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar excluir a pessoa!");
			erro.printStackTrace();
		}
	}

	public void popularCidade() {
		try {
			if (estado != null) {
				CidadeDAO cidadeDAO = new CidadeDAO();
				cidades = cidadeDAO.buscarPorEstado(estado.getCodigo());
			} else {
				cidades = new ArrayList<>();
			}

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar filtrar os registros!");
			erro.printStackTrace();
		}
	}

	public void popularEndereco() {
		try {
			if (cidade != null) {
				EnderecoDAO enderecoDAO = new EnderecoDAO();
				enderecos = enderecoDAO.buscarPorCidade(cidade.getCodigo());

			} else {
				enderecos = new ArrayList<>();
			}

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar filtrar os registros!");
			erro.printStackTrace();
		}
	}
}
