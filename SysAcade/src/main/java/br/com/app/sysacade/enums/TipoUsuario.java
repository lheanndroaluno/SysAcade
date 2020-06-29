package br.com.app.sysacade.enums;

public enum TipoUsuario {
	ADMINISTRADOR("ADMINISTRADOR"),
	GERENTE("GERENTE"), 
	BALCONISTA("BALCONISTA");
	
	private String descricao;

	private TipoUsuario(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
