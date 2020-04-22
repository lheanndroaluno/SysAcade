package br.com.app.sysacade.enums;

public enum Ombro {
	ELEVACAO_LATERAL, ELEVACAO_FRONTAL, PULL_DOWN, REMADA_ALTA, ENCOLHIMENTO, DESENVOLVIMENTO_ARNOLD,
	DESENVOLVIMENTO_ARTICULADO, DESENVOLVIMENTO_FRENTE, DESENVOLVIMENTO_COSTAS, FLEXAO_HINDU;

	public String toString() {

		switch (this) {
		case ELEVACAO_LATERAL:
			return "Elevação Lateral";
		case ELEVACAO_FRONTAL:
			return "Elevação Frontal";
		case PULL_DOWN:
			return "Pull Down";
		case REMADA_ALTA:
			return "Remada Alta";
		case ENCOLHIMENTO:
			return "Encolhimento";
		case DESENVOLVIMENTO_ARNOLD:
			return "Des. Arnold";
		case DESENVOLVIMENTO_ARTICULADO:
			return "Des. Articulado";
		case DESENVOLVIMENTO_FRENTE:
			return "Des. Frente";
		case DESENVOLVIMENTO_COSTAS:
			return "Des. Costas";
		case FLEXAO_HINDU:
			return "Flexão Hindu";
		default:
			return null;
		}
	}
}
