package br.com.app.sysacade.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.app.sysacade.dao.FornecedorDAO;
import br.com.app.sysacade.dao.ProdutoDAO;
import br.com.app.sysacade.domain.Fornecedor;
import br.com.app.sysacade.domain.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProdutoBean2 implements Serializable {

	private Produto produto;
	private List<Produto> produtos;
	private List<Fornecedor> fornecedores;
	private Long codigoProduto;
	private ProdutoDAO produtoDAO;
	private FornecedorDAO fornecedorDAO;

	/**
	 * Métodos Getters e Setters
	 * 
	 * @return
	 */
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Long getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public FornecedorDAO getFornecedorDAO() {
		return fornecedorDAO;
	}

	public void setFornecedorDAO(FornecedorDAO fornecedorDAO) {
		this.fornecedorDAO = fornecedorDAO;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public ProdutoDAO getProdutoDAO() {
		return produtoDAO;
	}

	public void setProdutoDAO(ProdutoDAO produtoDAO) {
		this.produtoDAO = produtoDAO;
	}

	@PostConstruct
	public void iniciar() {
		produtoDAO = new ProdutoDAO();
		fornecedorDAO = new FornecedorDAO();
	}

	public void listar() {
		try {
			produtos = produtoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar os produtos!");
			erro.printStackTrace();
		}
	}

	public void carregarEdicao() {
		try {
			produto = produtoDAO.buscar(codigoProduto);
			fornecedores = fornecedorDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar os dados para edição!");
			erro.printStackTrace();
		}
	}

}
