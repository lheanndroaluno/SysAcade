package br.com.app.sysacade.enums;

public enum Triceps {
	TRICEPS_PULLEY, TRICEPS_CORDA, TRICEPS_TESTA, TRICEPS_FRANCES, TRICEPS_PALMAR, TRICEPS_SENTADO, TRICEPS_MERGULHO,
	TRICEPS_SUPINADO;

	public String toString() {

		switch (this) {
		case TRICEPS_PULLEY:
			return "Triceps Pulley";
		case TRICEPS_CORDA:
			return "Triceps Corda";
		case TRICEPS_TESTA:
			return "Triceps Testa";
		case TRICEPS_FRANCES:
			return "Triceps Francês";
		case TRICEPS_PALMAR:
			return "Triceps Palmar";
		case TRICEPS_SENTADO:
			return "Triceps Sentado";
		case TRICEPS_MERGULHO:
			return "Triceps Mergulho";
		case TRICEPS_SUPINADO:
			return "Triceps Supinado";
		default:
			return null;
		}
	}
}
