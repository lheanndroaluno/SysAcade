package br.com.app.sysacade.enums;

public enum Peitoral {
	SUPINO_RETO ("SUPINO RETO"),
	SUPINO_45GRAUS("SUPINO 45º"),
	SUPINO_VERTICAL("SUPINO VERTICAL"),
	SUPINO_DECLINADO("SUPINO DECLINADO"),
	CRUCIFIXO("CRICIFIXO"),
	CROSS_OVER("CROSS OVER"),
	PULL_OVER("PULL OVER"),
	VOADOR("VOADOR"),
	SUPINO_COM_ALTERES("SUPINO COM ALTERES");
	
	private String descricao;

	private Peitoral(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
