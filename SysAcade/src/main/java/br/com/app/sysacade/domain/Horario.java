package br.com.app.sysacade.domain;

import java.util.Date;

import br.com.app.sysacade.enums.DiaDaSemana;

public class Horario {
	private Date horarioInicio;
	private Date horarioFim;
	private DiaDaSemana diaSemana;
	private Horario turno;
	
	/**
	 * Metodos Getters e Setters
	 * @return
	 */
	public Date getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(Date horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public Date getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(Date horarioFim) {
		this.horarioFim = horarioFim;
	}

	public DiaDaSemana getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(DiaDaSemana diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Horario getTurno() {
		return turno;
	}

	public void setTurno(Horario turno) {
		this.turno = turno;
	}

}
