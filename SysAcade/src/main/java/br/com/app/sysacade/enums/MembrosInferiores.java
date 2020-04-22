package br.com.app.sysacade.enums;

public enum MembrosInferiores {
	AGACHAMENTO, LEG_PRESS_180GRAUS, LEG_PRESS_45GRAUS, EXTENSORA, FLEXORA_VERTICAL, FLEXORA_HORIZONTAL,
	FLEXORA_SENTADA, CADEIRA_ADUTORA, CADEIRA_ABDUTORA, ADUCAO_LIVRE, ABDUCAO_LIVRE, FLEXAO_DE_QUADRIL,
	PANTURRILHA_LIVRE, BURRINHO;

	public String toString() {

		switch (this) {
		case AGACHAMENTO:
			return "Agachamento";
		case LEG_PRESS_180GRAUS:
			return "Leg Press 180º";
		case LEG_PRESS_45GRAUS:
			return "Leg Press 45º";
		case EXTENSORA:
			return "Extensora";
		case FLEXORA_VERTICAL:
			return "Flexora Vertical";
		case FLEXORA_HORIZONTAL:
			return "Flexora Horizontal";
		case FLEXORA_SENTADA:
			return "Flexora Sentada";
		case CADEIRA_ADUTORA:
			return "Cadeira Adutora";
		case CADEIRA_ABDUTORA:
			return "Cadeira Abdutora";
		case ADUCAO_LIVRE:
			return "Adução Livre";
		case ABDUCAO_LIVRE:
			return "Abdução Livre";
		case FLEXAO_DE_QUADRIL:
			return "Flexão de Quadril";
		case PANTURRILHA_LIVRE:
			return "Panturrilha";
		case BURRINHO:
			return "Burrinho";
		default:
			return null;
		}
	}
}
