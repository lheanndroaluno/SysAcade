package br.com.app.sysacade.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

import br.com.app.sysacade.dao.CaixaDAO;
import br.com.app.sysacade.dao.FuncionarioDAO;
import br.com.app.sysacade.domain.Caixa;
import br.com.app.sysacade.domain.Funcionario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CaixaBean implements Serializable {

	private ScheduleModel listagemCaixas;

	private Caixa caixa;

	private List<Funcionario> funcionarios;

	/**
	 * Getters e Setters
	 * 
	 * @return
	 */
	public ScheduleModel getListagemCaixas() {
		return listagemCaixas;
	}

	public void setListagemCaixas(ScheduleModel listagemCaixas) {
		this.listagemCaixas = listagemCaixas;
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	/**
	 * Método novo
	 */
	public void novo(SelectEvent evento) {
		caixa = new Caixa();
		caixa.setDataAbertura((Date) evento.getObject());

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarios = funcionarioDAO.listar();
	}
	
	/**
	 * Método listar caixas
	 */
	@PostConstruct
	public void listarCaixas() {
		listagemCaixas = new DefaultScheduleModel();
	}

	/**
	 * Método salvar abertura de caixa
	 */
	public void salvar() {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(caixa.getDataAbertura());
		calendario.add(Calendar.DATE, 1);
		caixa.setDataAbertura(calendario.getTime());

		CaixaDAO caixaDAO = new CaixaDAO();
		caixaDAO.salvar(caixa);

		Messages.addGlobalInfo("Caixa aberto com sucesso!");
	}

	public void setCaixas(ScheduleModel listaCaixas) {
		this.listagemCaixas = listaCaixas;
	}

}
