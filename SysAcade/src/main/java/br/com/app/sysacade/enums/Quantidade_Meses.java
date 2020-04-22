package br.com.app.sysacade.enums;

public enum Quantidade_Meses {
	UM_MES, DOIS_MESES, TRES_MESES, QUATRO_MESES, CINCO_MESES, SEIS_MESES, SETE_MESES, OITO_MESES, NOVE_MESES,
	DEZ_MESES, ONZE_MESES, DOZE_MESES, UM_ANO, DOIS_ANOS;

	public String toString() {

		switch (this) {
		case UM_MES:
			return "1 - Mês";
		case DOIS_MESES:
			return "2 - MESES";
		case TRES_MESES:
			return "3 - MESES";
		case QUATRO_MESES:
			return "4 - MESES";
		case CINCO_MESES:
			return "5 - MESES";
		case SEIS_MESES:
			return "6 - MESES";
		case SETE_MESES:
			return "7 - MESES";
		case OITO_MESES:
			return "8 - MESES";
		case NOVE_MESES:
			return "9 - MESES";
		case DEZ_MESES:
			return "10 - MESES";
		case ONZE_MESES:
			return "11 - MESES";
		case DOZE_MESES:
			return "12 - MESES";
		case UM_ANO:
			return "1 - Ano";
		case DOIS_ANOS:
			return "2 - Anos";
		default:
			return null;
		}
	}
}
