package br.com.app.sysacade.enums;

public enum TipoEvento {

	/**
	 * Tipo de evento - CSS
	 */
	PADRAO("Padrão", ""), URGENTE("Urgente", "urgente"), CANCELADO("Cancelado", "cancelado");

	private final String descricao;
	private final String css;

	private TipoEvento(String descricao, String css) {
		this.css = css;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getCss() {
		return css;
	}

}
