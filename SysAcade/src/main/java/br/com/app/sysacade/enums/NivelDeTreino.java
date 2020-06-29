package br.com.app.sysacade.enums;

public enum NivelDeTreino {
	INICIANTE,
	INTERMEDIARIO,
	AVANCADO;
	
	public String toString() {

		switch (this) {
		case INICIANTE:
			return "Iniciante";
		case INTERMEDIARIO:
			return "Intermediário";
		case AVANCADO:
			return "Avançado";
		default:
			return null;
		}
	}
}
