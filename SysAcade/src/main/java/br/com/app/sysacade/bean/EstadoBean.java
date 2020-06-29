package br.com.app.sysacade.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.primefaces.component.datatable.DataTable;

import br.com.app.sysacade.dao.EstadoDAO;
import br.com.app.sysacade.domain.Estado;
import br.com.app.sysacade.util.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;

@SuppressWarnings("serial")
@ManagedBean // responsavel pelo controle
@ViewScoped // tempo de vida dele é view, fica ativa enquanto a tela estiver aberta
public class EstadoBean implements Serializable {
	
	private Estado estado;
	private List<Estado> estados;

	/**
	 * Métodos Getters e Setters
	 * 
	 * @return
	 */
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public void novo() {
		estado = new Estado();
	}

	public void salvar() {
		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.merge(estado);
			novo();
			estados = estadoDAO.listar();

			Messages.addGlobalInfo("Registro salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalInfo("Ocorreu um erro ao tentar salvar um novo registro!");
			erro.printStackTrace();
		}
	}

	@PostConstruct
	public void listar() {
		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar todos os registros!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		estado = (Estado) evento.getComponent().getAttributes().get("linhaSelecionada");

	}

	public void excluir(ActionEvent evento) {
		try {
			estado = (Estado) evento.getComponent().getAttributes().get("linhaSelecionada");

			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.excluir(estado);

			// atualizando a lista de registros depois da exclusão
			estados = estadoDAO.listar();

			Messages.addGlobalInfo("Registro excluído com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar excluir o registro!");
			erro.printStackTrace();
		}
	}

	public void imprimir() {
		try {
			DataTable tabela = (DataTable) Faces.getViewRoot().findComponent("formLista:tabela");

			Map<String, Object> filtros = tabela.getFilters();

			String nome = (String) filtros.get("nome");
			
			//caminho para o relatório
			String caminho = Faces.getRealPath("/reports/estados.jasper");
			
			//caminho do banner(logo) do relatório
			String caminhoBanner = Faces.getRealPath("/resources/images/personal.png");
			
			Map<String, Object> parametros = new HashMap<>();
			
			parametros.put("CAMINHO_BANNER", caminhoBanner);
			
			if (nome == null) {
				parametros.put("ESTADO_NOME", "%%");
			} else {
				parametros.put("ESTADO_NOME", "%" + nome + "%");
			}

			Connection conexao = HibernateUtil.getConexao();

			JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros, conexao);

			// imprimindo o relatorio
			JasperPrintManager.printReport(relatorio, true);
		} catch (JRException erro) {
			Messages.addFlashGlobalError("Erro ao tentar gerar relatório!");
			erro.printStackTrace();
		}
	}

}
