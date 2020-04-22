package br.com.app.sysacade.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@SuppressWarnings("serial")
@Entity
public class Venda extends GenericDomain {
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date horarioVenda;
	
	@Column(nullable = false, precision = 12, scale = 2)
	private BigDecimal valorTotal;
	
	@ManyToOne
	@JoinColumn(nullable = true)
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Funcionario funcionario;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "venda")
	@Fetch(FetchMode.SUBSELECT)
	private List<ItemVenda> itensDaVenda;

	/**
	 * Métodos Getters e Setters
	 * 
	 * @return
	 */
	public Date getHorarioVenda() {
		return horarioVenda;
	}

	public void setHorarioVenda(Date horarioVenda) {
		this.horarioVenda = horarioVenda;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<ItemVenda> getItensDaVenda() {
		return itensDaVenda;
	}

	public void setItensDaVenda(List<ItemVenda> itensDaVenda) {
		this.itensDaVenda = itensDaVenda;
	}

}
