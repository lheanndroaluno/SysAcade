package br.com.app.sysacade.enums;

public enum TipoDeTreino {
	TREINO_A,
	TREINO_B,
	TREINO_C,
	TREINO_D;
	
	public String toString() {

		switch (this) {
		case TREINO_A:
			return "TREINO - A";
		case TREINO_B:
			return "TREINO - B";
		case TREINO_C:
			return "TREINO - C";
		case TREINO_D:
			return "TREINO - D";
		
		default:
			return null;
		}
	}
}
