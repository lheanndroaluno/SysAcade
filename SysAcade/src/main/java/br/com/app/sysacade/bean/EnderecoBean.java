package br.com.app.sysacade.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.app.sysacade.dao.CidadeDAO;
import br.com.app.sysacade.dao.EnderecoDAO;
import br.com.app.sysacade.dao.LogradouroDAO;
import br.com.app.sysacade.domain.Cidade;
import br.com.app.sysacade.domain.Endereco;
import br.com.app.sysacade.domain.Logradouro;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EnderecoBean implements Serializable {
	private Endereco endereco;
	private List<Endereco> enderecos;
	private List<Logradouro> logradouros;
	private List<Cidade> cidades;

	/**
	 * Métodos Getters e Setters
	 * 
	 * @return
	 */
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

	public List<Logradouro> getLogradouros() {
		return logradouros;
	}

	public void setLogradouros(List<Logradouro> logradouros) {
		this.logradouros = logradouros;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	/**
	 * Método do botão novo
	 */
	public void novo() {
		try {
			endereco = new Endereco();

			LogradouroDAO logradouroDAO = new LogradouroDAO();
			logradouros = logradouroDAO.listarPorCampoOrdenacao("descricao");
			
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listarPorCampoOrdenacao("nome");
			
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar cadastrar um novo registro!");
			erro.printStackTrace();
		}
	}

	/**
	 * Método salvar um novo regsotro no banco de dados
	 */
	public void salvar() {
		try {
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			enderecoDAO.merge(endereco);

			// limpando as dados de cidade
			endereco = new Endereco();

			LogradouroDAO logradouroDAO = new LogradouroDAO();
			logradouros = logradouroDAO.listarPorCampoOrdenacao("descricao");
			
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listarPorCampoOrdenacao("nome");

			enderecos = enderecoDAO.listar();

			// usando o omnifaces
			Messages.addGlobalInfo("Registro salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar um novo registro!");
			erro.printStackTrace();
		}

	}

	/**
	 * Método para listar todos os registros do bando de dados
	 */
	@PostConstruct
	public void listar() {
		try {
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			enderecos = enderecoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar todos os registros!");
			erro.printStackTrace();
		}
	}

	/**
	 * Método para atualizar um registro do bando de dados
	 */
	public void editar(ActionEvent evento) {
		try {
			endereco = (Endereco) evento.getComponent().getAttributes().get("linhaSelecionada");

			LogradouroDAO logradouroDAO = new LogradouroDAO();
			logradouros = logradouroDAO.listarPorCampoOrdenacao("descricao");
			
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listarPorCampoOrdenacao("nome");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar atualizar o registro!");
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
			endereco = (Endereco) evento.getComponent().getAttributes().get("linhaSelecionada");

			EnderecoDAO enderecoDAO = new EnderecoDAO();
			enderecoDAO.excluir(endereco);

			// atualizando a lista depois da exclusão
			enderecos = enderecoDAO.listar();

			// usando o omnifaces
			Messages.addGlobalInfo("Registro excluído com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar excluir o registro!");
			erro.printStackTrace();
		}
	}
}
