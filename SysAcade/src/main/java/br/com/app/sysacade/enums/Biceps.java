package br.com.app.sysacade.enums;

public enum Biceps {
	ROSCA_DIRETA, ROSCA_SCOTT, ROSCA_ALTERNADA, ROSCA_MARTELO, ROSCA_INVERSA, ROSCA_45GRAUS, ROSCA_CONCETRADA,
	ROSCA_INVERTIDA;

	public String toString() {

		switch (this) {
		case ROSCA_DIRETA:
			return "Rosca Direta";
		case ROSCA_SCOTT:
			return "Rosca Scott";
		case ROSCA_ALTERNADA:
			return "Rosca Alternada";
		case ROSCA_MARTELO:
			return "Rosca Martelo";
		case ROSCA_INVERSA:
			return "Rosca Inversa";
		case ROSCA_45GRAUS:
			return "Rosca 45º";
		case ROSCA_CONCETRADA:
			return "Rosca Comcentrada";
		case ROSCA_INVERTIDA:
			return "Rosca Invertida";
		default:
			return null;
		}
	}
}
