package br.com.app.sysacade.teste;

import java.util.Random;

public class GeradorDeMatriculas {
	public static void main(String[] args) {
		Random aleatorio = new Random();
		int numero = aleatorio.nextInt(100000);
		System.out.println("Matrícula: MATRIZ01" + numero);
		}
	
}
