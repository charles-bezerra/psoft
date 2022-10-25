package main;

import main.facades.Facade;

public class Sistema {

	public static void main(String[] args) {

		String jsonP1 = "{\"name\":\"Leite integral\", \"manufacturing\":\"Parmalat\", \"price\":10.5}";

		Facade mercadoFacade = new Facade();

		// Adicionando produto ao cat�logo
		String idP1 = mercadoFacade.createProduct(jsonP1);

		String jsonL1 = "{\"idProduct\":\"" + idP1 + "\", \"amount\":10}";
		;

		// Adicionando lote ao cat�logo
		mercadoFacade.createAlloment(jsonL1);

		// Lista produtos no cat�logo
		System.out.println(mercadoFacade.getAllProduct());

		// Lista lotes no cat�logo
		System.out.println(mercadoFacade.getAllAlloment());
	}
}
