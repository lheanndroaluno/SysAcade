package br.com.app.sysacade.dao;

import java.util.List;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Ignore;
import org.junit.Test;

import br.com.app.sysacade.domain.Pessoa;
import br.com.app.sysacade.domain.Usuario;
import br.com.app.sysacade.enums.TipoUsuario;

public class UsuarioDAOTeste {

	@Test
	@Ignore
	public void salvar() {
		Long codigoPessoa = 3L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);
		
		Usuario usuario = new Usuario();
		usuario.setPessoa(pessoa);
		usuario.setAtivo(true);
		usuario.setTipoUsuario(TipoUsuario.GERENTE);
		usuario.setSenhaSemCriptografia("123456");
		
		SimpleHash hash = new SimpleHash("md5", usuario.getSenhaSemCriptografia());
		usuario.setSenha(hash.toHex());

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);

		System.out.println("Registro salvo com sucesso!");
		System.out.println("Código : " + usuario.getCodigo());
		System.out.println("Nome : " + usuario.getPessoa().getNome());
		System.out.println("CPF : " + usuario.getPessoa().getCpf());
		System.out.println("Ativo : " + usuario.getAtivo());
		System.out.println("Tipo : " + usuario.getTipoUsuario());
		System.out.println("Senha : " + usuario.getSenha());
	}

	@Test
	@Ignore
	public void editar() {
		Long codigoPessoa = 1L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);

		Long codigoUsuario = 1L;
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigoUsuario);

		if (pessoa == null || usuario == null) {
			System.out.println("Pessoa e/ou Usuário não encontrado!");
		} else {
			System.out.println("Pessoa a ser editada:");
			System.out.println("Código : " + usuario.getCodigo());
			System.out.println("Nome : " + usuario.getPessoa().getNome());
			System.out.println("CPF : " + usuario.getPessoa().getCpf());
			System.out.println("Ativo : " + usuario.getAtivo());
			System.out.println("Tipo : " + usuario.getTipoUsuario());
			System.out.println("Senha : " + usuario.getSenha());
			System.out.println("---------------------------------------------------------------------------------");
			
			usuario.setPessoa(pessoa);
			usuario.setAtivo(true);
			usuario.setTipoUsuario(TipoUsuario.ADMINISTRADOR);
			usuario.setSenha("abc123456def");

			usuarioDAO.editar(usuario);

			System.out.println("Registro editado:");
			System.out.println("Código : " + usuario.getCodigo());
			System.out.println("Nome : " + usuario.getPessoa().getNome());
			System.out.println("CPF : " + usuario.getPessoa().getCpf());
			System.out.println("Ativo : " + usuario.getAtivo());
			System.out.println("Tipo : " + usuario.getTipoUsuario());
			System.out.println("Senha : " + usuario.getSenha());
		}
	}

	@Test
	@Ignore
	public void listar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> resultado = usuarioDAO.listar();

		if (resultado == null) {
			System.out.println("Lista vazia, nenhum registro encontrado!");
		} else {
			System.out.println("Registros encontrados:");
			for (Usuario usuario : resultado) {
				System.out.println("Código : " + usuario.getCodigo());
				System.out.println("Nome : " + usuario.getPessoa().getNome());
				System.out.println("CPF : " + usuario.getPessoa().getCpf());
				System.out.println("Ativo : " + usuario.getAtivo());
				System.out.println("Tipo : " + usuario.getTipoUsuario());
				System.out.println("Senha : " + usuario.getSenha());
				System.out.println("----------------------------------------------------------------");
			}
		}

	}

	@Test
	@Ignore
	public void buscar() {
		Long codigoUsuario = 5L;
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigoUsuario);

		if (usuario == null) {
			System.out.println("Registro não encontrado!");
		} else {
			System.out.println("Registro encontrado:");
			System.out.println("Código : " + usuario.getCodigo());
			System.out.println("Nome : " + usuario.getPessoa().getNome());
			System.out.println("CPF : " + usuario.getPessoa().getCpf());
			System.out.println("Ativo : " + usuario.getAtivo());
			System.out.println("Tipo : " + usuario.getTipoUsuario());
			System.out.println("Senha : " + usuario.getSenha());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigoUsuario = 2L;
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigoUsuario);

		if (usuario == null) {
			System.out.println("Registro não encontrado!");
		} else {
			usuarioDAO.excluir(usuario);
			System.out.println("Registro excluído:");
			System.out.println("Código : " + usuario.getCodigo());
			System.out.println("Nome : " + usuario.getPessoa().getNome());
			System.out.println("CPF : " + usuario.getPessoa().getCpf());
			System.out.println("Ativo : " + usuario.getAtivo());
			System.out.println("Tipo : " + usuario.getTipoUsuario());
			System.out.println("Senha : " + usuario.getSenha());
		}
	}
	
	@Test
	@Ignore
	public void autenticar() {
		String cpf = "000.000.000-05";
		String senha = "123456";
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.autenticar(cpf, senha);
		
		System.out.println("Usuario autenticado: " + usuario);
	}

}
