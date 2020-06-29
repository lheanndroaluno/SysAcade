package br.com.app.sysacade.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.app.sysacade.dao.TipoDeTreinoDAO;
import br.com.app.sysacade.domain.TipoDeTreino;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class TipoDeTreinoBean implements Serializable {

	private TipoDeTreino tipoDeTreino;
	private List<TipoDeTreino> tiposDeTreinos;

	public TipoDeTreino getTipoDeTreino() {
		return tipoDeTreino;
	}

	public void setTipoDeTreino(TipoDeTreino tipoDeTreino) {
		this.tipoDeTreino = tipoDeTreino;
	}

	public List<TipoDeTreino> getTiposDeTreinos() {
		return tiposDeTreinos;
	}

	public void setTiposDeTreinos(List<TipoDeTreino> tiposDeTreinos) {
		this.tiposDeTreinos = tiposDeTreinos;
	}

	public void novo() {
		tipoDeTreino = new TipoDeTreino();
	}

	public void salvar() {
		try {
			TipoDeTreinoDAO tipoDeTreinoDAO = new TipoDeTreinoDAO();
			tipoDeTreinoDAO.merge(tipoDeTreino);

			this.novo();

			tiposDeTreinos = tipoDeTreinoDAO.listar();

			Messages.addGlobalInfo("Registro salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalInfo("Ocorreu um erro ao tentar salvar um novo registro!");
			erro.printStackTrace();
		}
	}

	@PostConstruct
	public void listar() {
		try {
			TipoDeTreinoDAO tipoDeTreinoDAO = new TipoDeTreinoDAO();
			tiposDeTreinos = tipoDeTreinoDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar todos os registros!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		tipoDeTreino = (TipoDeTreino) evento.getComponent().getAttributes().get("linhaSelecionada");
	}

	public void excluir(ActionEvent evento) {
		try {
			tipoDeTreino = (TipoDeTreino) evento.getComponent().getAttributes().get("linhaSelecionada");

			TipoDeTreinoDAO tipoDeTreinoDAO = new TipoDeTreinoDAO();
			tipoDeTreinoDAO.excluir(tipoDeTreino);

			tiposDeTreinos = tipoDeTreinoDAO.listar();

			Messages.addGlobalInfo("Registro excluído com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar excluir o registro!");
			erro.printStackTrace();
		}
	}

}
