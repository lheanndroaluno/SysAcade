package br.com.app.sysacade.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.app.sysacade.dao.CidadeDAO;
import br.com.app.sysacade.dao.EstadoDAO;
import br.com.app.sysacade.domain.Cidade;
import br.com.app.sysacade.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CidadeBean implements Serializable {
	private Cidade cidade;
	private List<Cidade> cidades;
	private List<Estado> estados;

	/**
	 * Métodos Getters e Setters
	 * 
	 * @return
	 */
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

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	/**
	 * Método para criar um novo registro
	 */
	public void novo() {
		try {
			cidade = new Cidade();

			// populando a lista de estados
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listarPorCampoOrdenacao("nome");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar cadastrar uma nova cidade!");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.merge(cidade);

			cidade = new Cidade();// limpando as dados de cidade

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listarPorCampoOrdenacao("nome");

			cidades = cidadeDAO.listar();
			
			// usando o omnifaces
			Messages.addGlobalInfo("Registro salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar um  novo registro!");
			erro.printStackTrace();
		}

	}

	@PostConstruct
	public void listar() {
		try {
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar todos os registros!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			cidade = (Cidade) evento.getComponent().getAttributes().get("linhaSelecionada");

			// populando a lista de estados
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listarPorCampoOrdenacao("nome");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar atualizar um registro!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			cidade = (Cidade) evento.getComponent().getAttributes().get("linhaSelecionada");

			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.excluir(cidade);

			// atualizando a lista depois da exclusão
			cidades = cidadeDAO.listar();
			Messages.addGlobalInfo("Registro excluído com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar excluir o registro!");
			erro.printStackTrace();
		}
	}
}
