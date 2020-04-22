package br.com.app.sysacade.enums;

public enum Dorsal {
	PUXADOR_COSTA, PUXADOR_FRENTE, REMADA_BAIXA, REMADA_UNILATERAL, REMADA_CURVADA, PULLEY_SUPINADA, PULLEY_NEUTRO,
	VOADOR_INVERSO, BARRA_FIXA;

	public String toString() {

		switch (this) {
		case PUXADOR_COSTA:
			return "Puxador Costa";
		case PUXADOR_FRENTE:
			return "Puxador Frente";
		case REMADA_BAIXA:
			return "Remada Baixa";
		case REMADA_UNILATERAL:
			return "Remada Unilateral";
		case REMADA_CURVADA:
			return "Remada Curvada";
		case PULLEY_SUPINADA:
			return "Pulley Supinada";
		case PULLEY_NEUTRO:
			return "Pulley Neutro";
		case VOADOR_INVERSO:
			return "Voador Inverso";
		case BARRA_FIXA:
			return "Barra Fixa";
		default:
			return null;
		}
	}

}
