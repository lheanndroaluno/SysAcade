package br.com.app.sysacade.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.app.sysacade.domain.ItemVenda;
import br.com.app.sysacade.domain.Produto;
import br.com.app.sysacade.domain.Venda;
import br.com.app.sysacade.util.HibernateUtil;

public class VendaDAO extends GenericDAO<Venda> {
	public void salvar(Venda venda, List<ItemVenda> itensDaVenda) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(venda);
			for (int posicao = 0; posicao < itensDaVenda.size(); posicao++) {
				ItemVenda itemVenda = itensDaVenda.get(posicao);
				itemVenda.setVenda(venda);

				sessao.save(itemVenda);

				// capturando um produto
				Produto produto = itemVenda.getProduto();

				int quantidadeAtual = produto.getQuantidade() - itemVenda.getQuantidade();

				if (quantidadeAtual >= 0) {
					// covertendo string em short, porque short não aceita int, somente o string e
					// daí transforma string em short colocando new
					produto.setQuantidade(new Short(quantidadeAtual + ""));

					// atualizando o produto
					sessao.update(produto);
				} else {
					//forçando um erro que estar no DAO, para aparecer no BEAN
					throw new RuntimeException("Quantidade insuficiente em estoque!");
				}
			}
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}

	}
}
