package br.com.app.sysacade.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.app.sysacade.dao.ClienteDAO;
import br.com.app.sysacade.dao.FuncionarioDAO;
import br.com.app.sysacade.dao.ProdutoDAO;
import br.com.app.sysacade.dao.VendaDAO;
import br.com.app.sysacade.domain.Cliente;
import br.com.app.sysacade.domain.Funcionario;
import br.com.app.sysacade.domain.ItemVenda;
import br.com.app.sysacade.domain.Produto;
import br.com.app.sysacade.domain.Venda;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class VendaBean implements Serializable {
	private Venda venda;
	private List<Venda> vendas;
	private List<Produto> produtos;
	private List<ItemVenda> itensDaVenda;
	private List<Cliente> clientes;
	private List<Funcionario> funcionarios;

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

	public List<ItemVenda> getItensDaVenda() {
		return itensDaVenda;
	}

	public void setItensDaVenda(List<ItemVenda> itensDaVenda) {
		this.itensDaVenda = itensDaVenda;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	/**
	 * Método para listar todos os registros do bando de dados
	 */
	public void novo() {
		try {
			venda = new Venda();
			venda.setValorTotal(new BigDecimal("0.00"));

			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtos = produtoDAO.listarPorCampoOrdenacao("descricao");

			itensDaVenda = new ArrayList<>();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar as vendas!");
			erro.printStackTrace();
		}
	}

	public void listar() {
		VendaDAO vendaDAO = new VendaDAO();
		vendas = vendaDAO.listarPorCampoOrdenacao("codigo");
	}

	/**
	 * Método para adicionar um produto na cesta
	 * 
	 * @param evento
	 */
	public void adicionar(ActionEvent evento) {
		Produto produto = (Produto) evento.getComponent().getAttributes().get("linhaSelecionada");

		int achou = -1;// quer dizer que não achou o item, caso contrário achou o item
		for (int posicao = 0; posicao < itensDaVenda.size(); posicao++) {
			if (itensDaVenda.get(posicao).getProduto().equals(produto)) {
				achou = posicao;
			}
		}

		if (achou < 0) {
			// convertendo um produto em um item da venda
			ItemVenda itemVenda = new ItemVenda();
			itemVenda.setValorUnitario(produto.getPreco());
			itemVenda.setProduto(produto);
			itemVenda.setQuantidade(new Short("1"));

			itensDaVenda.add(itemVenda);
		} else {
			ItemVenda itemVenda = itensDaVenda.get(achou);
			itemVenda.setQuantidade(new Short(itemVenda.getQuantidade() + 1 + ""));
			itemVenda.setValorUnitario(produto.getPreco().multiply(new BigDecimal(itemVenda.getQuantidade())));
		}

		this.calcular();

	}

	/**
	 * Método para remover um produto da cesta
	 * 
	 * @param evento
	 */
	public void remover(ActionEvent evento) {
		ItemVenda itemVenda = (ItemVenda) evento.getComponent().getAttributes().get("linhaSelecionada");

		int achou = -1;// quer dizer que não achou o item, caso contrário achou o item
		for (int posicao = 0; posicao < itensDaVenda.size(); posicao++) {
			if (itensDaVenda.get(posicao).getProduto().equals(itemVenda.getProduto())) {
				achou = posicao;
			}
		}

		if (achou > -1) {
			itensDaVenda.remove(achou);
		} else {

		}

		this.calcular();

	}

	/**
	 * Método para calcular o valor total, tanto para somar, quanto para subtrair
	 */
	public void calcular() {
		venda.setValorTotal(new BigDecimal("0.00"));

		for (int posicao = 0; posicao < itensDaVenda.size(); posicao++) {
			ItemVenda itemVenda = itensDaVenda.get(posicao);
			venda.setValorTotal(venda.getValorTotal().add(itemVenda.getValorUnitario()));
		}
	}

	public void finalizar() {
		try {
			venda.setHorarioVenda(new Date());

			// limpa o funcionário e o cliente quando a venda não for realizada por algum
			// motivo
			venda.setCliente(null);
			venda.setFuncionario(null);

			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarios = funcionarioDAO.listarOrdenado();

			ClienteDAO clienteDAO = new ClienteDAO();
			clientes = clienteDAO.listarOrdenado();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar finalizar a venda!");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			if (venda.getValorTotal().signum() == 0) {
				Messages.addGlobalError("Informe pelo menos um item para a venda!");
				return;
			}

			// salvando a venda com os respectivos itens da venda
			VendaDAO vendaDAO = new VendaDAO();
			vendaDAO.salvar(venda, itensDaVenda);

			this.novo();// limpado a tela de vendas

			Messages.addGlobalInfo("Venda realizada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar a venda!");
		}
	}
}
