package db2.grupo02.model;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
		
		//TIPOS DE PRODUCTOS
		TipoProducto tp1 = new TipoProducto(1, "medicamento");
		TipoProducto tp2 = new TipoProducto(2, "perfumeria");
		
		
		//LABORATORIOS
		Laboratorio l1 = new Laboratorio(1, "bayern");
		Laboratorio l2 = new Laboratorio(2, "syntex");
		Laboratorio l3 = new Laboratorio(3, "roemmers");
				
		
		//PRODUCTOS
		Producto p1 = new Producto(1, "aspirina", 200.00f, tp1, l1);
		Producto p2 = new Producto(2, "jarabe", 750.00f, tp1, l2);
		Producto p3 = new Producto(3, "desodorante", 400.00f, tp2);
		Producto p4 = new Producto(4, "jabon", 150.00f, tp2);
		Producto p5 = new Producto(5, "perfume", 3075.00f, tp2);
		Producto p6 = new Producto(6, "peine", 250.00f, tp2);
		Producto p7 = new Producto(7, "lapiz labial", 1200.00f, tp2);
				
		
		//DOMICILIOS DE SUCURSALES
		Domicilio ds1 = new Domicilio(1, "roca", 801, "burzaco", "buenos aires");
		Domicilio ds2 = new Domicilio(2, "meeks", 298, "lomas de zamora", "buenos aires");
		Domicilio ds3 = new Domicilio(3, "alsina", 515, "banfield", "buenos aires");
	
		//DOMICILIOS DE CLIENTES
		Domicilio dc1 = new Domicilio(4, "domingo peron", 859, "burzaco", "buenos aires");
		Domicilio dc2 = new Domicilio(5, "bynnon", 1598, "adrogue", "buenos aires");
		Domicilio dc3 = new Domicilio(6, "la rosa", 522, "adrogue", "buenos aires");
	
		//DOMICILIOS DE EMPLEADOS
		Domicilio de1 = new Domicilio(7, "frias", 2070, "marmol", "buenos aires");
		Domicilio de2 = new Domicilio(8, "cangallo", 300, "temperley", "buenos aires");
		Domicilio de3 = new Domicilio(9, "canale", 1802, "adrogue", "buenos aires");
		Domicilio de4 = new Domicilio(10, "las piedras", 187, "lomas de zamora", "buenos aires");
		Domicilio de5 = new Domicilio(11, "loria", 642, "lomas de zamora", "buenos aires");
		Domicilio de6 = new Domicilio(12, "gorriti", 791, "lomas de zamora", "buenos aires");
		Domicilio de7 = new Domicilio(13, "medrano", 272, "banfield", "buenos aires");
		Domicilio de8 = new Domicilio(14, "azara", 1161, "banfield", "buenos aires");
		Domicilio de9 = new Domicilio(15, "peña", 955, "banfield", "buenos aires");
		
		
		//OBRAS SOCIALES DE CLIENTES
		ObraSocial oc1 = new ObraSocial(10, "Medicus", 1658);
		
		//OBRAS SOCIALES DE EMPLEADOS
		ObraSocial oe1 = new ObraSocial(1, "Swiss medical", 12343);
		ObraSocial oe2 = new ObraSocial(2, "Osde", 4322);
		ObraSocial oe3 = new ObraSocial(3, "Omint", 7653);
		ObraSocial oe4 = new ObraSocial(4, "Medicus", 1232);
		ObraSocial oe5 = new ObraSocial(5, "Osde", 3214);
		ObraSocial oe6 = new ObraSocial(6, "Omint", 4568);
		ObraSocial oe7 = new ObraSocial(7, "Osde", 8753);
		ObraSocial oe8 = new ObraSocial(8, "Swiss medical", 5421);
		ObraSocial oe9 = new ObraSocial(9, "Osde", 1234);
		
				
		//SURCURSALES
		Sucursal s1 = new Sucursal(1, "sucursal burzaco", ds1);
		Sucursal s2 = new Sucursal(2, "sucursal lomas", ds2);
		Sucursal s3 = new Sucursal(3, "sucursal banfield", ds3);
		
				
		//CLIENTES
		Cliente c1 = new Cliente(18499041, "Bueno", "Axel", dc1);
		Cliente c2 = new Cliente(28242342, "Frutos", "Manel", dc2);
		Cliente c3 = new Cliente(30001300, "Alamo", "Maria", oc1, dc3);
		
				
		//EMPLEADOS BURZACO
		Empleado e1 = new Empleado(20851126, "27-20851126-8", "Bilal", "Loria", true, oe1, de1);
		Empleado e2 = new Empleado(34617681, "20-34617681-5", "Jara", "Alan", false, oe2, de2);
		Empleado e3 = new Empleado(34247685, "27-34247685-1", "Valeria", "Denis", false, oe3, de3);
		
		//EMPLEADOS LOMAS
		Empleado e4 = new Empleado(27664830, "20-27664830-7", "Recio", "Vicente", true, oe4, de4);
		Empleado e5 = new Empleado(17875519, "20-17875519-7", "Amor", "Daniel", false, oe5, de5);
		Empleado e6 = new Empleado(39984203, "20-39984203-5", "Cervera", "Alexander", false, oe6, de6);

		//EMPLEADOS BANFIELD
		Empleado e7 = new Empleado(16289534, "20-16289534-7", "Tellez", "Ian", true, oe7, de7);
		Empleado e8 = new Empleado(18753338, "20-18753338-5", "Vicente", "Elias", false, oe8, de8);
		Empleado e9 = new Empleado(39199680, "27-39199680-1", "Esteve", "Judith", false, oe9, de9);

		
		//VENTAS SUCURSAL BURZACO
		Venta v1 = new Venta(1, "efectivo", LocalDate.of(2022, 5, 5), 0f, c1, e1, e1, s1);
		Venta v2 = new Venta(2, "tarjeta", LocalDate.of(2022, 5, 23), 0f, c1, e2, e3, s1);
		Venta v3 = new Venta(3, "efectivo", LocalDate.of(2022, 5, 12), 0f, c2, e3, e1, s1);
		
		//VENTAS SUCURSAL LOMAS
		Venta v4 = new Venta(4, "efectivo", LocalDate.of(2022, 5, 2), 0f, c2, e4, e6, s2);
		Venta v5 = new Venta(5, "debito", LocalDate.of(2022, 5, 7), 0f, c1, e4, e5, s2);
		Venta v6 = new Venta(6, "efectivo", LocalDate.of(2022, 5, 26), 0f, c3, e6, e5, s2);
		
		//VENTAS SUCURSAL BANFIELD
		Venta v7 = new Venta(7, "tarjeta", LocalDate.of(2022, 5, 9), 0f, c1, e7, e8, s3);
		Venta v8 = new Venta(8, "efectivo", LocalDate.of(2022, 5, 13), 0f, c3, e8, e8, s3);
		Venta v9 = new Venta(9, "debito", LocalDate.of(2022, 5, 17), 0f, c3, e9, e7, s3);
		Venta v10 = new Venta(10, "tarjeta", LocalDate.of(2022, 5, 30), 0f, c2, e8, e9, s3);
	
		
		v1.agregar(p2, 3);
		v1.agregar(p1, 1);
		
		v2.agregar(p3, 5);
		v2.agregar(p1, 2);
		v2.agregar(p2, 4);
		
		v3.agregar(p5, 2);
		v3.agregar(p7, 1);
		
		v4.agregar(p7, 2);
		v4.agregar(p6, 3);
		v4.agregar(p4, 1);
		
		v5.agregar(p7, 4);
		v5.agregar(p1, 3);
		v5.agregar(p2, 2);
		
		v6.agregar(p5, 2);
		
		v7.agregar(p3, 4);
		v7.agregar(p4, 2);
		
		v8.agregar(p3, 2);
		v8.agregar(p2, 1);
		v8.agregar(p1, 3);
		
		v9.agregar(p7, 3);
		v9.agregar(p5, 1);
		
		v10.agregar(p1, 2);
		v10.agregar(p2, 1);
		v10.agregar(p4, 3);
		v10.agregar(p6, 1);
		
		List<Venta> ventas = new ArrayList<Venta>();
		ventas.add(v1);
		ventas.add(v2);
		ventas.add(v3);
		ventas.add(v4);
		ventas.add(v5);
		ventas.add(v6);
		ventas.add(v7);
		ventas.add(v8);
		ventas.add(v9);
		ventas.add(v10);
		
		//System.out.println(gson.toJson(v1));
		
		
		// GUARDO LAS VENTAS COMO UNA COLECCION EN LA BASE DE DATOS
		/*
		try {
			MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
			mongoClient.dropDatabase("farmacia"); // Elimina la base de datos si existe
			VentaDao.getInstance();			
			for(Venta venta: ventas) {
				VentaDao.agregar(venta);
			}
					System.out.println("\nATENCION : Se cargo de manera adecuadad la Base de datos.");
		} 
		catch (Exception e) {
			System.out.println("\nERROR!, hubo problemas en la carga de los datos.");
			e.printStackTrace();
		}
		*/
	}

}
