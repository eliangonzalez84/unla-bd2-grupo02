package db2.grupo02.model;

import java.time.LocalDate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
		
		Laboratorio l1 = new Laboratorio(1, "Bayern");
		Laboratorio l2 = new Laboratorio(2, "Syntex");
		Laboratorio l3 = new Laboratorio(3, "Roemmers");
		
		TipoProducto tp1 = new TipoProducto(1, "medicamento");
		TipoProducto tp2 = new TipoProducto(2, "perfumeria");
		
		Producto p1 = new Producto(1, "aspirina", 200.00f, tp1, l1);
		Producto p2 = new Producto(2, "jarabe", 150.00f, tp1, l2);
		Producto p3 = new Producto(3, "desodorante", 400.00f, tp2);
		Producto p4 = new Producto(4, "jabon", 75.00f, tp2);
		
		Domicilio d1 = new Domicilio(1, "Roca", 232, "Burzaco", "Buenos Aires");
		Domicilio d2 = new Domicilio(2, "Quintana", 723, "Lomas", "Buenos Aires");
		Domicilio d3 = new Domicilio(3, "Alsina", 1252, "Banfield", "Buenos Aires");
		Domicilio d4 = new Domicilio(4, "Hipolito Yrigoyen", 16928, "Banfield", "Buenos Aires");
		
		ObraSocial os1 = new ObraSocial(1, "Swiss medical", 12343);
		ObraSocial os2 = new ObraSocial(2, "Osde", 4322);

		Empleado e1 = new Empleado(6654789, "216654789", "Lopez", "Juan", false, os1, d1);
		Empleado e2 = new Empleado(3234354, "173234354", "Perez", "Maria", true, os2, d2);
	
		Cliente c1 = new Cliente(543987, "Rodriguez", "Franco", d3);
		
		Sucursal s1 = new Sucursal(1, "sucursal 1", d4);
		
		Venta v1 = new Venta(1, "efvo", LocalDate.now(), 0f, c1, e1,e2, s1);
		v1.agregar(p1, 2);
		v1.agregar(p2, 4);
		v1.agregar(p4, 7);
		v1.agregar(p1, 3);
		System.out.println(gson.toJson(v1));
	}

}
