package com.webservice.ws;

public class CalculadoraConsumer {

	public static void main(String[] args) {
		CalculadoraImplService cs = new CalculadoraImplService();
		ICalculadora c = cs.getCalculadoraImplPort();
		System.out.println("Suma");
		System.out.println(c.operacion(1, 5, 8));
		System.out.println("Resta");
		System.out.println(c.operacion(2, 5, 8));
		System.out.println("Multiplicacion");
		System.out.println(c.operacion(3, 5, 8));
		System.out.println("Division");
		System.out.println(c.operacion(4, 5, 8));
		
	}

}
