package br.com.app.sysacade.enums;

public enum FormaDePagamento {
	A_VISTA,
	DEBITO,
	CREDITO,
	CARNE,
	BOLETO;
	
	public String toString(){
		
		switch (this){
			case A_VISTA:
				return "À VISTA";
			case DEBITO:
				return "DÉBITO";
			case CREDITO:
				return "CRÉDITO";
			default:
				return null;
		}
	}
}
