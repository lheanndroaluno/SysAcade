package br.com.app.sysacade.enums;

public enum Abdominal {
	PRANCHA, SUPRA_SOLO, OBLIQUO_SOLO, OBLIQUO_POLIA, CANIVETE, INFRA, BANCO_LOMBAR, PARALELA;

	public String toString() {

		switch (this) {
		case PRANCHA:
			return "Prancha";
		case SUPRA_SOLO:
			return "Supra Solo";
		case OBLIQUO_SOLO:
			return "Obliquo Solo";
		case OBLIQUO_POLIA:
			return "Obliquo Polia";
		case CANIVETE:
			return "Canivete";
		case INFRA:
			return "Infra";
		case BANCO_LOMBAR:
			return "Banco Lombar";
		case PARALELA:
			return "Paralela";
		default:
			return null;
		}
	}
}
