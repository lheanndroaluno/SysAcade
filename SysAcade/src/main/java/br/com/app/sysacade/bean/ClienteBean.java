package br.com.app.sysacade.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.primefaces.component.datatable.DataTable;

import br.com.app.sysacade.dao.ClienteDAO;
import br.com.app.sysacade.dao.PessoaDAO;
import br.com.app.sysacade.domain.Cliente;
import br.com.app.sysacade.domain.Pessoa;
import br.com.app.sysacade.util.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {
	private Cliente cliente;
	private List<Cliente> clientes;
	private List<Pessoa> pessoas;

	/**
	 * Métodos Getters e Setters
	 * 
	 * @return
	 */
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
			cliente = new Cliente();

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
			ClienteDAO clienteDAO = new ClienteDAO();
			clientes = clienteDAO.listarPorCampoOrdenacao("dataCadastro");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar os clientes!");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.merge(cliente);

			cliente = new Cliente();

			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listarPorCampoOrdenacao("nome");

			clientes = clienteDAO.listar();

			// usando o omnifaces
			Messages.addGlobalInfo("Cliente salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar um novo cliente!");
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
			cliente = (Cliente) evento.getComponent().getAttributes().get("linhaSelecionada");

			// populando a lista de pessoas
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listarPorCampoOrdenacao("nome");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar atualizar o cliente!");
			erro.printStackTrace();
		}
	}

	public void mostrarDadosCliente(ActionEvent evento) {
		try {
			cliente = (Cliente) evento.getComponent().getAttributes().get("linhaSelecionada");
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
			cliente = (Cliente) evento.getComponent().getAttributes().get("linhaSelecionada");

			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.excluir(cliente);

			// atualizando a lista depois da exclusão
			clientes = clienteDAO.listar();

			// usando o omnifaces
			Messages.addGlobalInfo("Cliente excluído com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar excluir o cliente!");
			erro.printStackTrace();
		}
	}
	
	public void imprimir() {
		try {
			DataTable tabela = (DataTable) Faces.getViewRoot().findComponent("formLista:tabela");

			Map<String, Object> filtros = tabela.getFilters();

			@SuppressWarnings("unused")
			String nome = (String) filtros.get("nome");
			
			//caminho para o relatório
			String caminho = Faces.getRealPath("/reports/clientes.jasper");
			
			//caminho do banner(logo) do relatório
			String caminhoBanner = Faces.getRealPath("/resources/images/personal.png");
			
			Map<String, Object> parametros = new HashMap<>();
			
			parametros.put("CAMINHO_BANNER", caminhoBanner);
			
			Connection conexao = HibernateUtil.getConexao();

			JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros, conexao);

			// imprimindo o relatorio
			JasperPrintManager.printReport(relatorio, true);
		} catch (JRException erro) {
			Messages.addFlashGlobalError("Erro ao tentar gerar relatório!");
			erro.printStackTrace();
		}
	}

}
