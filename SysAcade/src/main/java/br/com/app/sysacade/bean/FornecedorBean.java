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
import br.com.app.sysacade.dao.FornecedorDAO;
import br.com.app.sysacade.domain.Cidade;
import br.com.app.sysacade.domain.Endereco;
import br.com.app.sysacade.domain.Estado;
import br.com.app.sysacade.domain.Fornecedor;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FornecedorBean implements Serializable {
	private Fornecedor fornecedor;
	private List<Fornecedor> fornecedores;

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
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
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
			fornecedor = new Fornecedor();

			estado = new Estado();

			cidade = new Cidade();

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listarPorCampoOrdenacao("nome");

			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listarPorCampoOrdenacao("nome");

			enderecos = new ArrayList<>();

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar cadastrar um novo fornecedor!");
			erro.printStackTrace();
		}
	}

	/**
	 * Método salvar um novo registro no banco de dados
	 */
	public void salvar() {
		try {
			FornecedorDAO fornecedorDAO = new FornecedorDAO();
			fornecedorDAO.merge(fornecedor);

			// limpando as dados do fornecedor
			fornecedor = new Fornecedor();

			estado = new Estado();

			cidade = new Cidade();

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listarPorCampoOrdenacao("nome");

			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listarPorCampoOrdenacao("nome");

			enderecos = new ArrayList<>();

			fornecedores = fornecedorDAO.listarPorCampoOrdenacao("razaoSocial");

			// usando o omnifaces
			Messages.addGlobalInfo("Fornecedor  salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar um novo fornecedor!");
			erro.printStackTrace();
		}
	}

	/**
	 * Método para listar todos os registros do banco de dados
	 */
	@PostConstruct
	public void listar() {
		try {
			FornecedorDAO fornecedorDAO = new FornecedorDAO();
			fornecedores = fornecedorDAO.listarPorCampoOrdenacao("razaoSocial");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar os fornecedores!");
			erro.printStackTrace();
		}
	}

	/**
	 * Método para atualizar um registro do banco de dados
	 */
	public void editar(ActionEvent evento) {
		try {
			fornecedor = (Fornecedor) evento.getComponent().getAttributes().get("linhaSelecionada");

			estado = fornecedor.getEndereco().getCidade().getEstado();

			cidade = fornecedor.getEndereco().getCidade();

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listarPorCampoOrdenacao("nome");

			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listarPorCampoOrdenacao("nome");

			EnderecoDAO enderecoDAO = new EnderecoDAO();
			enderecos = enderecoDAO.listarPorCampoOrdenacao("nomeEnd");

			cidades = cidadeDAO.buscarPorEstado(estado.getCodigo());

			enderecos = enderecoDAO.buscarPorCidade(cidade.getCodigo());

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar atualizar o fornecedor!");
			erro.printStackTrace();
		}
	}
	
	public void mostrarDadosFornecedor(ActionEvent evento) {
		try {
			fornecedor = (Fornecedor) evento.getComponent().getAttributes().get("linhaSelecionada");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar mostrar os dados do fornecedor!");
			erro.printStackTrace();
		}
	}

	/**
	 * Método para excluir um registro do banco de dados
	 */
	public void excluir(ActionEvent evento) {
		try {
			fornecedor = (Fornecedor) evento.getComponent().getAttributes().get("linhaSelecionada");

			FornecedorDAO fornecedorDAO = new FornecedorDAO();
			fornecedorDAO.excluir(fornecedor);

			// atualizando a lista depois da exclusão
			fornecedores = fornecedorDAO.listar();

			// usando o omnifaces
			Messages.addGlobalInfo("Fornecedor excluído com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir o fornecedor!");
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
