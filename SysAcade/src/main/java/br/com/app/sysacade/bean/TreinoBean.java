package br.com.app.sysacade.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.app.sysacade.dao.AlunoDAO;
import br.com.app.sysacade.dao.PersonalDAO;
import br.com.app.sysacade.dao.TreinoDAO;
import br.com.app.sysacade.domain.Aluno;
import br.com.app.sysacade.domain.Personal;
import br.com.app.sysacade.domain.Treino;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class TreinoBean implements Serializable {

	private Treino treino;
	private List<Treino> treinos;
	private List<Aluno> alunos;
	private List<Personal> personals;

	/**
	 * Métodos Getters e Setters
	 * 
	 * @return
	 */
	public Treino getTreino() {
		return treino;
	}

	public void setTreino(Treino treino) {
		this.treino = treino;
	}

	public List<Treino> getTreinos() {
		return treinos;
	}

	public void setTreinos(List<Treino> treinos) {
		this.treinos = treinos;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Personal> getPersonals() {
		return personals;
	}

	public void setPersonals(List<Personal> personals) {
		this.personals = personals;
	}

	public void novo() {
		try {
			treino = new Treino();

			// populando a lista
			AlunoDAO alunoDAO = new AlunoDAO();
			alunos = alunoDAO.listar();

			PersonalDAO personalDAO = new PersonalDAO();
			personals = personalDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar criar um novo treino!");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			TreinoDAO treinoDAO = new TreinoDAO();
			treinoDAO.merge(treino);

			treino = new Treino();

			AlunoDAO alunoDAO = new AlunoDAO();
			alunos = alunoDAO.listar();

			PersonalDAO personalDAO = new PersonalDAO();
			personals = personalDAO.listar();

			treinos = treinoDAO.listar();

			Messages.addGlobalInfo("Treino salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar salvar um novo treino!");
			erro.printStackTrace();
		}
	}

	@PostConstruct
	public void listar() {
		try {
			TreinoDAO treinoDAO = new TreinoDAO();
			treinos = treinoDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar listar todos os treinos!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			treino = (Treino) evento.getComponent().getAttributes().get("linhaSelecionada");

			AlunoDAO alunoDAO = new AlunoDAO();
			alunos = alunoDAO.listar();

			PersonalDAO personalDAO = new PersonalDAO();
			personals = personalDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar atualizar o treino!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			treino = (Treino) evento.getComponent().getAttributes().get("linhaSelecionada");

			TreinoDAO treinoDAO = new TreinoDAO();
			treinoDAO.excluir(treino);

			treinos = treinoDAO.listar();

			Messages.addGlobalInfo("Treino excluído com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar excluir o treino!");
			erro.printStackTrace();
		}
	}

}
