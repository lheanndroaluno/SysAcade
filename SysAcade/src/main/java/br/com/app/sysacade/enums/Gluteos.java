package br.com.app.sysacade.enums;

public enum Gluteos {
	GLUTEO_MAQUINA, GLUTEO_3APOIO, GLUTEO_POLIA, GLUTEO_GUIADO, STIFF, ELEVACAO_PELVICA, GRAVITON;

	public String toString() {

		switch (this) {
		case GLUTEO_MAQUINA:
			return "Glúteo Máquina";
		case GLUTEO_3APOIO:
			return "Glúteo 3 Apoio";
		case GLUTEO_POLIA:
			return "Glúteo Polia";
		case GLUTEO_GUIADO:
			return "Glúteo Guiado";
		case STIFF:
			return "Stiff";
		case ELEVACAO_PELVICA:
			return "Elevação Pélvica";
		case GRAVITON:
			return "Graviton";
		default:
			return null;
		}
	}
}
