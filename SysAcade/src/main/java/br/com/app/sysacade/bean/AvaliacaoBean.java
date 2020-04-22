package br.com.app.sysacade.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.app.sysacade.dao.AlunoDAO;
import br.com.app.sysacade.dao.AvaliacaoDAO;
import br.com.app.sysacade.domain.Aluno;
import br.com.app.sysacade.domain.Avaliacao;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class AvaliacaoBean implements Serializable {

	private Avaliacao avaliacao;
	private List<Avaliacao> avaliacoes;

	private List<Aluno> alunos;

	/**
	 * Métodos Getters e Setters
	 * 
	 * @return
	 */
	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public void novo() {
		try {
			avaliacao = new Avaliacao();

			// populando alista de alunos
			AlunoDAO alunoDAO = new AlunoDAO();
			alunos = alunoDAO.listarOrdenado();

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar cadastrar um novo registro!");
			erro.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	public void salvar() {
		try {
			AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
			avaliacaoDAO.merge(avaliacao);

			// limpando os dados
			Avaliacao avaliacao = new Avaliacao();

			// populando alista de alunos
			AlunoDAO alunoDAO = new AlunoDAO();
			alunos = alunoDAO.listarOrdenado();

			avaliacoes = avaliacaoDAO.listar();

			// usando o omnifaces
			Messages.addGlobalInfo("Registro salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar um novo registro!");
			erro.printStackTrace();
		}
	}

	@PostConstruct
	public void listar() {
		try {
			AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
			avaliacoes = avaliacaoDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar todos os registros!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			avaliacao = (Avaliacao) evento.getComponent().getAttributes().get("linhaSelecionada");

			// populando alista de alunos
			AlunoDAO alunoDAO = new AlunoDAO();
			alunos = alunoDAO.listarOrdenado();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar atualizar o registro!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			avaliacao = (Avaliacao) evento.getComponent().getAttributes().get("linhaSelecionada");
			
			AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
			avaliacaoDAO.excluir(avaliacao);
			
			// atualizando a lista depois da exclusão
			avaliacoes = avaliacaoDAO.listar();
			
			Messages.addGlobalInfo("Registro excluído com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar excluir o registro selecionado!");
			erro.printStackTrace();
		}
		
	}

}
