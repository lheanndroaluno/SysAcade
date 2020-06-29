package br.com.app.sysacade.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.app.sysacade.dao.TipoDeMusculoDAO;
import br.com.app.sysacade.domain.TipoDeMusculo;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class TipoDeMusculoBean implements Serializable {

	private TipoDeMusculo tipoDeMusculo;
	private List<TipoDeMusculo> tiposDeMusculos;

	public TipoDeMusculo getTipoDeMusculo() {
		return tipoDeMusculo;
	}

	public void setTipoDeMusculo(TipoDeMusculo tipoDeMusculo) {
		this.tipoDeMusculo = tipoDeMusculo;
	}

	public List<TipoDeMusculo> getTiposDeMusculos() {
		return tiposDeMusculos;
	}

	public void setTiposDeMusculos(List<TipoDeMusculo> tiposDeMusculos) {
		this.tiposDeMusculos = tiposDeMusculos;
	}

	public void novo() {
		tipoDeMusculo = new TipoDeMusculo();
	}

	public void salvar() {
		try {
			TipoDeMusculoDAO tipoDeMusculoDAO = new TipoDeMusculoDAO();
			tipoDeMusculoDAO.merge(tipoDeMusculo);

			this.novo();

			tiposDeMusculos = tipoDeMusculoDAO.listar();

			Messages.addGlobalInfo("Registro salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalInfo("Ocorreu um erro ao tentar salvar um novo registro!");
			erro.printStackTrace();
		}
	}

	@PostConstruct
	public void listar() {
		try {
			TipoDeMusculoDAO tipoDeMusculoDAO = new TipoDeMusculoDAO();
			tiposDeMusculos = tipoDeMusculoDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar todos os registros!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		tipoDeMusculo = (TipoDeMusculo) evento.getComponent().getAttributes().get("linhaSelecionada");
	}

	public void excluir(ActionEvent evento) {
		try {
			tipoDeMusculo = (TipoDeMusculo) evento.getComponent().getAttributes().get("linhaSelecionada");

			TipoDeMusculoDAO tipoDeMusculoDAO = new TipoDeMusculoDAO();
			tipoDeMusculoDAO.excluir(tipoDeMusculo);

			tiposDeMusculos = tipoDeMusculoDAO.listar();

			Messages.addGlobalInfo("Registro excluído com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar excluir o registro!");
			erro.printStackTrace();
		}
	}

}
