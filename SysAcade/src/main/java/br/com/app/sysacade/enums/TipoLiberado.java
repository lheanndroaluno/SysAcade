package br.com.app.sysacade.enums;

public enum TipoLiberado {
	SIM,
	NAO;
	
public String toString(){
		
		switch (this){
			case SIM:
				return "SIM";
			case NAO:
				return "NÃO";
			default:
				return null;
		}
	}
}
