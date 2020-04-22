package br.com.app.sysacade.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.app.sysacade.domain.Endereco;
import br.com.app.sysacade.util.HibernateUtil;

public class EnderecoDAO extends GenericDAO<Endereco> {
	@SuppressWarnings("unchecked")
	public List<Endereco> buscarPorCidade(Long cidadeCodigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {
			Criteria consulta = sessao.createCriteria(Endereco.class);
			consulta.add(Restrictions.eq("cidade.codigo", cidadeCodigo));
			consulta.addOrder(Order.asc("nomeEnd"));
			List<Endereco> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
}
