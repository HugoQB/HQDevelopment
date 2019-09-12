package com.webservice.ws;

import javax.jws.WebService;

@WebService(endpointInterface="com.webservice.ws.ICalculadora")
public class CalculadoraImpl implements ICalculadora{

	@Override
	public double operacion(int opcion, int valor1, int valor2) {
		
		int resultado = 0;
		switch(opcion) {
		
		case 1: 
			resultado = valor1 + valor2;
			break;
		case 2:
			resultado = valor1 - valor2;
			break;
		case 3: 
			resultado = valor1 * valor2;
			break;
		case 4: 
			resultado = valor1 / valor2;
			break;
		}
		
		return resultado;
	}

}
