package br.com.app.sysacade.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.app.sysacade.dao.AlunoDAO;
import br.com.app.sysacade.dao.PessoaDAO;
import br.com.app.sysacade.dao.PlanoDAO;
import br.com.app.sysacade.domain.Aluno;
import br.com.app.sysacade.domain.Pessoa;
import br.com.app.sysacade.domain.Plano;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class AlunoBean implements Serializable {

	private Aluno aluno;
	private List<Aluno> alunos;
	private List<Pessoa> pessoas;
	private List<Plano> planos;

	/**
	 * Métodos Getters e Setters
	 * 
	 * @return
	 */
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<Plano> getPlanos() {
		return planos;
	}

	public void setPlanos(List<Plano> planos) {
		this.planos = planos;
	}

	public void novo() {
		try {
			aluno = new Aluno();

			// populando a lista de pessoas
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar();

			// populando a lista de planos
			PlanoDAO planoDAO = new PlanoDAO();
			planos = planoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar cadastrar um novo aluno!");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			AlunoDAO alunoDAO = new AlunoDAO();
			alunoDAO.merge(aluno);

			aluno = new Aluno();// limpando os dados de aluno

			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar();

			PlanoDAO planoDAO = new PlanoDAO();
			planos = planoDAO.listar();

			alunos = alunoDAO.listar();

			Messages.addGlobalInfo("Aluno salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar um novo aluno!");
			erro.printStackTrace();
		}
	}

	@PostConstruct
	public void listar() {
		try {
			AlunoDAO alunoDAO = new AlunoDAO();
			alunos = alunoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar todos os alunos!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			aluno = (Aluno) evento.getComponent().getAttributes().get("linhaSelecionada");

			// populando a lista de pessoas
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar();

			// populando a lista de planos
			PlanoDAO planoDAO = new PlanoDAO();
			planos = planoDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar atualizar o aluno selecionado!");
			erro.printStackTrace();
		}
	}

	public void mostrarDadosAluno(ActionEvent evento) {
		try {
			aluno = (Aluno) evento.getComponent().getAttributes().get("linhaSelecionada");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar mostrar dados do aluno!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			aluno = (Aluno) evento.getComponent().getAttributes().get("linhaSelecionada");

			AlunoDAO alunoDAO = new AlunoDAO();
			alunoDAO.excluir(aluno);

			// atualizando a lista depois da exclusão
			alunos = alunoDAO.listar();

			Messages.addGlobalInfo("Aluno excluído com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar excluir o aluno selecionado!");
			erro.printStackTrace();
		}
	}

	// metodo que retorna o intervalo de dias entre duas datas
	public static String contaDias(String dataInicial, String dataFinal) throws ParseException {
		DateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
		dataFormatada.setLenient(false);

		Date dataInicio = dataFormatada.parse(dataInicial);
		Date dataFim = dataFormatada.parse(dataFinal);
		long dt = (dataFim.getTime() - dataInicio.getTime()) + 3600000;
		Long diasCorridosAno = (dt / 86400000L);

		Integer diasCorridos = Integer.valueOf(diasCorridosAno.toString());
		String diasDecorridos = String.valueOf(diasCorridos);// Sem numeros formatados;

		return diasDecorridos;

	}

	// método para pegar a data do dia
	@SuppressWarnings({ "static-access", "unused" })
	public static String getDataDia() {
		GregorianCalendar calendario = new GregorianCalendar();
		int dia = calendario.get(calendario.DAY_OF_MONTH);
		int mes = calendario.get(calendario.MONTH);
		int ano = calendario.get(calendario.YEAR);

		String data = String.valueOf(dia + "/" + mes + "/" + ano);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String diaBR = df.format(new Date());
		return diaBR;
	}

	// agora para calcular a idade
	public static BigDecimal calculaIdade(String dataNascimento) throws ParseException {
		BigDecimal qtdDias = new BigDecimal(contaDias(dataNascimento, getDataDia()));
		BigDecimal ano = new BigDecimal(365.25);
		BigDecimal idade = qtdDias.divide(ano, 0, RoundingMode.DOWN);

		return idade;
	}
	
	public void calcularVencimento() {
		
	}

}
