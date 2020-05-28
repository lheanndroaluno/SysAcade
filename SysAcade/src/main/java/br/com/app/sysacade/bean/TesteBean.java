package br.com.app.sysacade.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.app.sysacade.dao.TesteDAO;
import br.com.app.sysacade.domain.Teste;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class TesteBean implements Serializable {

	private Teste teste;
	private List<Teste> testes;

	public Teste getTeste() {
		return teste;
	}

	public void setTeste(Teste teste) {
		this.teste = teste;
	}

	public List<Teste> getTestes() {
		return testes;
	}

	public void setTestes(List<Teste> testes) {
		this.testes = testes;
	}

	/**
	 * Método para criar um novo registro
	 */
	public void novo() {
		try {
			teste = new Teste();

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar cadastrar uma novo registro!");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			TesteDAO testeDAO = new TesteDAO();
			testeDAO.merge(teste);

			teste = new Teste();// limpando as dados de cidade

			testes = testeDAO.listar();

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
			TesteDAO testeDAO = new TesteDAO();
			testes = testeDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar todos os registros!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			teste = (Teste) evento.getComponent().getAttributes().get("linhaSelecionada");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar atualizar um registro!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			teste = (Teste) evento.getComponent().getAttributes().get("linhaSelecionada");

			TesteDAO testeDAO = new TesteDAO();
			testeDAO.excluir(teste);

			Messages.addGlobalInfo("Registro excluído com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar excluir o registro!");
			erro.printStackTrace();
		}
	}
}
