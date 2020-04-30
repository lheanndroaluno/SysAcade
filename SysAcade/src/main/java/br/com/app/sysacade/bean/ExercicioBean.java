package br.com.app.sysacade.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.app.sysacade.dao.ExercicioDAO;
import br.com.app.sysacade.domain.Exercicio;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ExercicioBean implements Serializable {

	private Exercicio exercicio;
	private List<Exercicio> exercicios;

	public Exercicio getExercicio() {
		return exercicio;
	}

	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}

	public List<Exercicio> getExercicios() {
		return exercicios;
	}

	public void setExercicios(List<Exercicio> exercicios) {
		this.exercicios = exercicios;
	}

	public void novo() {
		try {
			exercicio = new Exercicio();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar cadastrar um novo exercício!");
			erro.printStackTrace();
		}

	}
	
	public void salvar() {
		try {
			ExercicioDAO exercicioDAO = new ExercicioDAO();
			exercicioDAO.merge(exercicio);
			
			this.novo();
			
			exercicios = exercicioDAO.listar();
			
			Messages.addGlobalInfo("Registro salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar um  novo registro!");
			erro.printStackTrace();
		}
	}
	
	@PostConstruct
	public void listar() {
		try {
			ExercicioDAO exercicioDAO = new ExercicioDAO();
			exercicios = exercicioDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar todos os registros!");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento) {
		try {
			exercicio = (Exercicio) evento.getComponent().getAttributes().get("linhaSelecionada");
			
			ExercicioDAO exercicioDAO = new ExercicioDAO();
			exercicios = exercicioDAO.listar();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar atualizar um registro!");
			erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento) {
		try {
			exercicio = (Exercicio) evento.getComponent().getAttributes().get("linhaSelecionada");
			
			ExercicioDAO exercicioDAO = new ExercicioDAO();
			exercicioDAO.excluir(exercicio);
			
			exercicios = exercicioDAO.listar();
			
			Messages.addGlobalInfo("Registro excluído com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar excluir o registro!");
			erro.printStackTrace();
		}
		
		
	}

}
