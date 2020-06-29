package br.com.app.sysacade.enums;

public enum Peitoral {
	SUPINO_RETO,
	SUPINO_45º,
	SUPINO_VERTICAL,
	SUPINO_DECLINADO,
	CRUCIFIXO,
	CROSS_OVER,
	PULL_OVER,
	VOADOR,
	SUPINO_COM_HALTERES;
	
	public String toString() {

		switch (this) {
		case SUPINO_RETO:
			return "Supino Reto";
		case SUPINO_45º:
			return "Supino 45º";
		case SUPINO_VERTICAL:
			return "Supino Vertical";
		case SUPINO_DECLINADO:
			return "Supino Declinado";
		case CRUCIFIXO:
			return "Crucifixo";
		case CROSS_OVER:
			return "Cross Over";
		case PULL_OVER:
			return "Pull Over";
		case VOADOR:
			return "Voador";
		case SUPINO_COM_HALTERES:
			return "Supino c/ Halteres";
		default:
			return null;
		}
	}
}
