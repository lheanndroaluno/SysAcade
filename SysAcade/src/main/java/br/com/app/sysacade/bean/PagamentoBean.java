package br.com.app.sysacade.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.app.sysacade.dao.AlunoDAO;
import br.com.app.sysacade.dao.FuncionarioDAO;
import br.com.app.sysacade.dao.PagamentoDAO;
import br.com.app.sysacade.dao.PlanoDAO;
import br.com.app.sysacade.domain.Aluno;
import br.com.app.sysacade.domain.Funcionario;
import br.com.app.sysacade.domain.Pagamento;
import br.com.app.sysacade.domain.Plano;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PagamentoBean implements Serializable {

	private Pagamento pagamento;
	private List<Pagamento> pagamentos;
	private List<Aluno> alunos;
	private List<Plano> planos;
	private List<Funcionario> funcionarios;

	/**
	 * Métodos Getters e Setters
	 * 
	 * @return
	 */
	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Plano> getPlanos() {
		return planos;
	}

	public void setPlanos(List<Plano> planos) {
		this.planos = planos;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public void novo() {
		try {
			pagamento = new Pagamento();
			
			pagamento.setHorario(new Date());
			
			// populando a lista de alunos cadastrados
			AlunoDAO alunoDAO = new AlunoDAO();
			alunos = alunoDAO.listar();

			// populando a lista de planos cadastrados
			PlanoDAO planoDAO = new PlanoDAO();
			planos = planoDAO.listar();

			// populando a lista de funcionários
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarios = funcionarioDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar realizar um novo pagamento!");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			PagamentoDAO pagamentoDAO = new PagamentoDAO();
			pagamentoDAO.merge(pagamento);

			// limpando as dados
			pagamento = new Pagamento();

			AlunoDAO alunoDAO = new AlunoDAO();
			alunos = alunoDAO.listar();

			PlanoDAO planoDAO = new PlanoDAO();
			planos = planoDAO.listar();
			
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarios = funcionarioDAO.listar();

			pagamentos = pagamentoDAO.listar();
			
			Messages.addGlobalInfo("Pagamento realizado com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao efetuar o pagamento do aluno!");
			erro.printStackTrace();
		}
	}

	@PostConstruct
	public void listar() {
		try {
			PagamentoDAO pagamentoDAO = new PagamentoDAO();
			pagamentos = pagamentoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar todos os registros!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			pagamento = (Pagamento) evento.getComponent().getAttributes().get("linhaSelecionada");

			AlunoDAO alunoDAO = new AlunoDAO();
			alunos = alunoDAO.listar();

			PlanoDAO planoDAO = new PlanoDAO();
			planos = planoDAO.listar();
			
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarios = funcionarioDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar atualizar o registro!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			pagamento = (Pagamento) evento.getComponent().getAttributes().get("linhaSelecionada");

			PagamentoDAO pagamentoDAO = new PagamentoDAO();
			pagamentoDAO.excluir(pagamento);

			pagamentos = pagamentoDAO.listar();

			Messages.addGlobalInfo("Registro excluído com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar excluir o registro!");
			erro.printStackTrace();
		}
	}

}
