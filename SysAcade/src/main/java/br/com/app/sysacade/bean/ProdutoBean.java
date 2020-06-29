package br.com.app.sysacade.bean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import br.com.app.sysacade.dao.FornecedorDAO;
import br.com.app.sysacade.dao.ProdutoDAO;
import br.com.app.sysacade.domain.Fornecedor;
import br.com.app.sysacade.domain.Produto;
import br.com.app.sysacade.util.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable {
	private Produto produto;
	private List<Produto> produtos;
	private List<Fornecedor> fornecedores;
	private StreamedContent stream;

	/**
	 * Métodos Getters e Setters
	 * 
	 * @return
	 */
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public StreamedContent getStream() {
		return stream;
	}

	public void setStream(StreamedContent stream) {
		this.stream = stream;
	}

	/**
	 * Método do botão novo
	 */
	public void novo() {
		try {
			produto = new Produto();

			// populando a lista de fornecedores
			FornecedorDAO fornecedorDAO = new FornecedorDAO();
			fornecedores = fornecedorDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro tentar cadastrar um no produto!");
			erro.printStackTrace();
		}
	}

	/**
	 * Método salvar um novo registro no banco de dados
	 */
	public void salvar() {
		try {

			if (produto.getCaminho() == null) {
				Messages.addGlobalError("O campo 'Upload Foto' é obrigatório");
				return;
			}

			ProdutoDAO produtoDAO = new ProdutoDAO();
			Produto produtoRetorno = produtoDAO.merge(produto);

			Path origem = Paths.get(produto.getCaminho());

			Path destino = Paths.get("C:\\Workspace\\UploadsProdutos\\" + produtoRetorno.getCodigo() + ".jpg");

			Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);

			// limpando os dados do produto
			produto = new Produto();

			FornecedorDAO fornecedorDAO = new FornecedorDAO();
			fornecedores = fornecedorDAO.listar();

			produtos = produtoDAO.listar();

			// usando o omnifaces
			Messages.addGlobalInfo("Produto salvo com sucesso!");
		} catch (RuntimeException | IOException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar um novo produto!");
			erro.printStackTrace();
		}
	}

	/**
	 * Método para listar todos os registros do bando de dados
	 */
	@PostConstruct
	public void listar() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtos = produtoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar os produtos!");
			erro.printStackTrace();
		}
	}

	/**
	 * Método para atualizar um registro do bando de dados
	 * 
	 * @param evento
	 */
	public void editar(ActionEvent evento) {
		try {
			produto = (Produto) evento.getComponent().getAttributes().get("linhaSelecionada");
			produto.setCaminho("C:\\Workspace\\UploadsProdutos\\" + produto.getCodigo() + ".jpg");

			// populando a lista de produtos
			FornecedorDAO fornecedorDAO = new FornecedorDAO();
			fornecedores = fornecedorDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar atualizar o produto!");
			erro.printStackTrace();
		}
	}

	/**
	 * Método para excluir um registro do banco de dados
	 * 
	 * @param evento
	 */
	public void excluir(ActionEvent evento) {
		try {
			produto = (Produto) evento.getComponent().getAttributes().get("linhaSelecionada");

			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.excluir(produto);

			Path arquivo = Paths.get("C:/Workspace/UploadsProdutos/" + produto.getCodigo() + ".jpg");

			Files.deleteIfExists(arquivo);

			// atualizando a lista depois da exclusão
			produtos = produtoDAO.listar();

			// usando o omnifaces
			Messages.addGlobalInfo("Produto excluído com sucesso!");
		} catch (RuntimeException | IOException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar excluir o produto!");
			erro.printStackTrace();
		}
	}

	public void upload(FileUploadEvent evento) {
		try {
			UploadedFile arquivoUpload = evento.getFile();
			// criar arquivo temporário dentro do sistema operacional
			Path arquivoTemp = Files.createTempFile(null, null);
			// copiar o arquivoUpload para o arquivoTemp
			Files.copy(arquivoUpload.getInputstream(), arquivoTemp, StandardCopyOption.REPLACE_EXISTING);

			produto.setCaminho(arquivoTemp.toString());

			Messages.addGlobalInfo("Upload realizado com sucesso!");

			System.out.println(produto.getCaminho());
		} catch (IOException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao tentar realizar o upload de arquivo!");
			erro.printStackTrace();
		}
	}

	public void imprimir() {
		try {
			DataTable tabela = (DataTable) Faces.getViewRoot().findComponent("formLista:tabela");

			Map<String, Object> filtros = tabela.getFilters();

			String descricao = (String) filtros.get("descricao");
			
			String razaoSocial = (String) filtros.get("fornecedor.razaoSocial");

			// caminho para o relatório
			String caminho = Faces.getRealPath("/reports/produtos.jasper");

			// caminho do banner(logo) do relatório
			String caminhoBanner = Faces.getRealPath("/resources/images/personal.png");

			Map<String, Object> parametros = new HashMap<>();

			parametros.put("CAMINHO_BANNER", caminhoBanner);

			if (descricao == null) {
				parametros.put("DESCRICAO_ITEM", "%%");
			} else {
				parametros.put("DESCRICAO_ITEM", "%" + descricao + "%");
			}
			
			if (razaoSocial == null) {
				parametros.put("RAZAO_SOCIAL", "%%");
			} else {
				parametros.put("RAZAO_SOCIAL", "%" + razaoSocial + "%");
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

	public void download(ActionEvent evento) {
		try {
			produto = (Produto) evento.getComponent().getAttributes().get("linhaSelecionada");

			InputStream inputStream = new FileInputStream(
					"C:/Workspace/UploadsProdutos/" + produto.getCodigo() + ".jpg");

			stream = new DefaultStreamedContent(inputStream, "imagem/jpg", produto.getCodigo() + ".jpg");

			Messages.addGlobalInfo("Download realizado com sucesso!");
		} catch (FileNotFoundException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar realizar download da imagem!");
			erro.printStackTrace();
		}
	}

}
