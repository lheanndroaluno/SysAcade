package br.com.app.sysacade.enums;

public enum Costas {
	BARRA_FIXA_CHINUP,
	REMADA_CURVADA,
	BARRA_FIXA_PEGADA_LARGA,
	REMADA_UNILATERAL,
	PULLOVER_HALTERE,
	REMADA_BAIXA,
	REMADA_EM_PE_BARRA_T,
	REMADA_CURVADA_PEGADA_INVERTIDA,
	REMADA_SMITH_PEGADA_INVERTIDA,
	PULL_DOWN_PEGADA_FECHADA,
	LAT_PULL_DOWN,
	REMADA_BANCO_INCLINADO_HALTERES,
	ELEVACAO_LATERAL_DEITADO,
	LEVANTAMENTO_TERRA_BARRA,
	AGACHAMENTO_FRONTAL;
	
	public String toString() {

		switch (this) {
		case BARRA_FIXA_CHINUP:
			return "Barra Fixa (Chinup)";
		case REMADA_CURVADA:
			return "Remada Curvada";
		case BARRA_FIXA_PEGADA_LARGA:
			return "Barra Fixa Pegada Larga";
		case REMADA_UNILATERAL:
			return "Remada Unilateral";
		case PULLOVER_HALTERE:
			return "Pull Over c/ Halteres";
		case REMADA_BAIXA:
			return "Remada Baixa";
		case REMADA_EM_PE_BARRA_T:
			return "Remada Barra T";
		case REMADA_CURVADA_PEGADA_INVERTIDA:
			return "Remada Curvada Pegada Invertida";
		case REMADA_SMITH_PEGADA_INVERTIDA:
			return "Remada Smith Pegada Invertida";
		case PULL_DOWN_PEGADA_FECHADA:
			return "Pull Down Pegada Fechada";
		case LAT_PULL_DOWN:
			return "Lat Pull Down";
		case REMADA_BANCO_INCLINADO_HALTERES:
			return "Remada Banco Inclinado c/ Halteres";
		case ELEVACAO_LATERAL_DEITADO:
			return "Elevação Lateral Deitado";
		case LEVANTAMENTO_TERRA_BARRA:
			return "Levantamento Terra Barra";
		case AGACHAMENTO_FRONTAL:
			return "Agachamento Frontal";
		default:
			return null;
		}
	}
	
	
}
