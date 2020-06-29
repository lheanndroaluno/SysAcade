package br.com.app.sysacade.enums;

public enum TipoComida {
	ONE("One"),
	TWO("Two"), 
	THREE("Three");

    private final String descricao;
    
    private TipoComida(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
