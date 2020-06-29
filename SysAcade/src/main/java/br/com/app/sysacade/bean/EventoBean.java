package br.com.app.sysacade.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import br.com.app.sysacade.dao.EventoDAO;
import br.com.app.sysacade.dao.UsuarioDAO;
import br.com.app.sysacade.domain.Evento;
import br.com.app.sysacade.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EventoBean implements Serializable {

	private ScheduleModel eventoModelo;
	private Evento evento;
	private List<Evento> listaEventos;
	private List<Usuario> usuarios;
	private EventoDAO eventoDAO;

	public ScheduleModel getEventoModelo() {
		return eventoModelo;
	}

	public void setEventoModelo(ScheduleModel eventoModelo) {
		this.eventoModelo = eventoModelo;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public List<Evento> getListaEventos() {
		return listaEventos;
	}

	public void setListaEventos(List<Evento> listaEventos) {
		this.listaEventos = listaEventos;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public EventoDAO getEventoDAO() {
		return eventoDAO;
	}

	public void setEventoDAO(EventoDAO eventoDAO) {
		this.eventoDAO = eventoDAO;
	}

	/**
	 * Método construtor
	 */
	@PostConstruct
	public void inicializar() {
		eventoModelo = new DefaultScheduleModel();
		eventoDAO = new EventoDAO();
		evento = new Evento();

		try {

			listaEventos = eventoDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao inicializar evento!");
			erro.printStackTrace();
		}

		for (Evento ev : listaEventos) {
			DefaultScheduleEvent dse = new DefaultScheduleEvent();

			dse.setTitle(ev.getTitulo());
			dse.setDescription(ev.getDescricao());
			dse.setStartDate(ev.getInicioEvento());
			dse.setEndDate(ev.getFimEvento());
			dse.setData(ev.getCodigo());

			dse.setAllDay(true);// posso estender a data do evento
			dse.setEditable(true);// posso editar evento

			eventoModelo.addEvent(dse);

		}

	}

	/**
	 * Método novo
	 */

	public void novo(SelectEvent selectEvento) {
		evento = new Evento();

		evento.setInicioEvento((Date) selectEvento.getObject());

		evento.setFimEvento((Date) selectEvento.getObject());

		// listando os usuários no selectOneMenu
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarios = usuarioDAO.listar();

	}

	public void salvar() {
		if (evento.getCodigo() == null) {
			if (evento.getInicioEvento().getTime() <= evento.getFimEvento().getTime()) {
				eventoDAO = new EventoDAO();
				
				try {
					eventoDAO.merge(evento);
					this.inicializar();

					Messages.addGlobalInfo("Evento salvo com sucesso!");
				} catch (RuntimeException erro) {
					Messages.addGlobalError("Ocorreu um erro ao tentar salvar um novo evento!");
					erro.printStackTrace();
				}

				evento = new Evento();

			} else {
				Messages.addGlobalError("Data inicial não pode ser maior que a data final!");
			}
		}

	}

	public void selecionado(SelectEvent selectEvento) {
		try {
			ScheduleEvent scheduleEvento = (ScheduleEvent) selectEvento.getObject();

			for (Evento ev : listaEventos) {
				if (ev.getCodigo().equals(scheduleEvento.getData())) {
					evento = ev;
					break;
				}
			}

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarios = usuarioDAO.listar();

		} catch (RuntimeException erro) {
			erro.printStackTrace();
		}
	}

	public void movido(ScheduleEntryMoveEvent scheduleEntryMoveEvent) {
		for (Evento ev : listaEventos) {
			if (ev.getCodigo().equals(scheduleEntryMoveEvent.getScheduleEvent().getData())) {
				evento = ev;
				eventoDAO = new EventoDAO();
				try {
					eventoDAO.merge(evento);
					this.inicializar();
					
					Messages.addGlobalInfo("Evento Movido!");
				} catch (RuntimeException erro) {
					Messages.addFlashGlobalError("Erro ao tentar salvar o evento modificado!");
					erro.printStackTrace();
				}

				break;
			}
		}
	}

	public void redimensionar(ScheduleEntryResizeEvent scheduleEntryResizeEvent) {
		for (Evento ev : listaEventos) {
			if (ev.getCodigo().equals(scheduleEntryResizeEvent.getScheduleEvent().getData())) {
				evento = ev;
				eventoDAO = new EventoDAO();
				try {
					eventoDAO.merge(evento);
					this.inicializar();
					
					Messages.addGlobalInfo("Evento redimensionado!");
				} catch (RuntimeException erro) {
					Messages.addFlashGlobalError("Erro ao tentar salvar o evento modificado!");
					erro.printStackTrace();
				}

				break;
			}
		}
	}

}
