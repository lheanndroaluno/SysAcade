package br.com.app.sysacade.enums;

public enum Abdominal {
	PRANCHA("Prancha"), 
	SUPRA_SOLO("Supra Solo"), 
	OBLIQUO_SOLO("Obliquo Solo"), 
	OBLIQUO_POLIA("Obliquo Polia"), 
	CANIVETE("Canivete"), 
	INFRA("Infra"), 
	BANCO_LOMBAR("Banco Lombar"), 
	PARALELA("Paralela");

	private String descricao;
	
	Abdominal(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
