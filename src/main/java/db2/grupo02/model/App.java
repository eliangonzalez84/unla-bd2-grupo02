package db2.grupo02.model;

import com.google.gson.Gson;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		
		Producto prod = new Producto(1, "aspirina", 1032.52f, new TipoProducto(1, "medicamento"), new Laboratorio(1, "Bayern"));
		System.out.println(gson.toJson(prod));
		
	}

}
