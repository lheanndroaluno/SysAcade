package br.com.app.sysacade.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import br.com.app.sysacade.domain.Aluno;
import br.com.app.sysacade.util.HibernateUtil;

public class AlunoDAO extends GenericDAO<Aluno>{
	@SuppressWarnings("unchecked")
	public List<Aluno> listarOrdenado() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Aluno.class);
			consulta.createAlias("pessoa", "p");
			consulta.addOrder(Order.asc("p.nome"));
			List<Aluno> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
}
