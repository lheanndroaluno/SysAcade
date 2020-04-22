package br.com.app.sysacade.enums;

public enum TiposDeTreino {
	HIPERTROFIA,
	FORTALECIMENTO_MUSCULAR,
	RESISTENCIA,
	ESTETICA,
	TERAPEUTICA,
	PROLIFATICA,
	COMPETITIVA,
	GRUPOS_ESPECIAIS;
	
public String toString(){
		
		switch (this){
			case HIPERTROFIA:
				return "Hipertrofia";
			case FORTALECIMENTO_MUSCULAR:
				return "Fortalecimento Muscular";
			case RESISTENCIA:
				return "Resistência";
			case ESTETICA:
				return "Estética";
			case TERAPEUTICA:
				return "Terapêutica";
			case PROLIFATICA:
				return "Prolifática";
			case COMPETITIVA:
				return "Competitiva";
			case GRUPOS_ESPECIAIS:
				return "Grupos Especiais";
			default:
				return null;
		}
	}
	
}
