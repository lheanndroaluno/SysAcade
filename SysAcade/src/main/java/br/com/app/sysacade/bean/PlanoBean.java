package br.com.app.sysacade.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.app.sysacade.dao.PlanoDAO;
import br.com.app.sysacade.domain.Plano;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PlanoBean implements Serializable {

	private Plano plano;
	private List<Plano> planos;

	/**
	 * Métodos Getters e Setters
	 * 
	 * @return
	 */
	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public List<Plano> getPlanos() {
		return planos;
	}

	public void setPlanos(List<Plano> planos) {
		this.planos = planos;
	}

	public void novo() {
		plano = new Plano();
	}

	public void salvar() {
		try {
			PlanoDAO planoDAO = new PlanoDAO();
			planoDAO.merge(plano);
			novo();
			planos = planoDAO.listar();

			// usando o omnifaces
			Messages.addGlobalInfo("Registro salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o registro!");
			erro.printStackTrace();
		}
	}

	@PostConstruct
	public void listar() {
		try {
			PlanoDAO planoDAO = new PlanoDAO();
			planos = planoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar todos os registros!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		plano = (Plano) evento.getComponent().getAttributes().get("linhaSelecionada");
	}

	public void excluir(ActionEvent evento) {
		try {
			plano = (Plano) evento.getComponent().getAttributes().get("linhaSelecionada");

			PlanoDAO planoDAO = new PlanoDAO();
			planoDAO.excluir(plano);

			// atualizando a lista depois da exclusão
			planos = planoDAO.listar();

			// usando o omnifaces
			Messages.addGlobalInfo("Registro excluído com sucesso!");
		} catch (Exception erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir o registro!");
			erro.printStackTrace();
		}
	}

}