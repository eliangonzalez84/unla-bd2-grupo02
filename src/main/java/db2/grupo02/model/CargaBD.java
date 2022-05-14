package db2.grupo02.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import dataAccessObject.VentaDao;

public class CargaBD {
	public static void main(String[] args) {

		// SE CARGA LA OBRA SOCIAL A LA BASE DE DATOS
		ObraSocial galeno = new ObraSocial(1, "Galeno");
		ObraSocial sancor = new ObraSocial(2, "Sancor Salud");
		ObraSocial medicus = new ObraSocial(3, "Medicus");
		ObraSocial privado = new ObraSocial(4, "PRIVADO");

		// SE CARGAN LOS CLIENTES EN LA BASE DE DATOS
		Cliente c1 = new Cliente(42000001, "Andres", "franco",
				new Domicilio("Av Corrientes ", 521, "CABA", "Buenos Aires"), galeno);

		Cliente c2 = new Cliente(42000002, "apellido", "Chino", new Domicilio("Maipu ", 128, "CABA", "Buenos Aires"),
				medicus);

		// EMPLEADOS SE CREAN EMPLEADOS

		Empleado e1 = new Empleado(11111111, 102000011, "Gonzales", "Adres", false, sancor,
				new Domicilio("Chacabuco", 112, "CABA", "Buenos Aires"));
		Empleado e2 = new Empleado(22222222, 102000012, "Scarola", "leo", true, medicus,
				new Domicilio("Alem", 1122, "Monte Grande", "Buenos Aires"));

		// SE CREAN LABORATORIOS

		Laboratorio bayer = new Laboratorio(1, "Laboratorio Bayer");
		Laboratorio bago = new Laboratorio(2, "Laboratorio Bago");
		Laboratorio ch = new Laboratorio(3, "CH Carolina Herrera");
		Laboratorio elite = new Laboratorio(4, "Elite");

		// SE CREAN TIPOS DE PRODUCTOS

		TipoProducto farmacia = new TipoProducto(1, "Farmacia");
		TipoProducto perfumeria = new TipoProducto(2, "Perfumeria");

		// SE CREAN PRODUCTOS EN GONDOLA
		Producto p1 = new Producto(1, "BayaAspirina", 100.0f, farmacia, bayer);
		Producto p2 = new Producto(2, "Actron600", 200.0f, farmacia, bayer);
		Producto p3 = new Producto(3, "Doricina", 300.0f, farmacia, bayer);
		Producto p4 = new Producto(4, "Loratadina", 400.0f, farmacia, bago);
		Producto p5 = new Producto(5, "Calcium", 500.0f, farmacia, bago);
		Producto p6 = new Producto(6, "Misoprostol", 100.0f, farmacia, bago);
		Producto p7 = new Producto(7, "CafiaAspirina", 100.0f, farmacia, bago);
		Producto p8 = new Producto(8, "Jabon", 300.0f, farmacia, ch);
		Producto p9 = new Producto(9, "Shampoo Plusbelle", 400.0f, farmacia, ch);
		Producto p10 = new Producto(10, "Panuelos descartables Elite", 50.0f, farmacia, elite);
		Producto[] productos = { p1, p2, p3, p4, p5, p6, p7, p8, p9, p10 };

		/*
		 * // METODO DE PAGO EFECTIVO-CREDITO-DEBITO
		 * 
		 * FormaDePago efectivo = new FormaDePago(1, "EFECTIVO"); FormaDePago credito =
		 * new FormaDePago(2, "CREDITO"); FormaDePago debito = new FormaDePago(3,
		 * "DEBITO"); FormaDePago[] formasDePago = { efectivo, credito, debito };
		 */
		// SUCURSALES CABA---LANUS---ONCE

		Sucursal s1 = new Sucursal(1, "Sucursl CABA", new Domicilio("Av de Mayo", 510, "CABA", "Buenos Aires"),
				Arrays.asList(e1, e2));

		Sucursal s2 = new Sucursal(2, "Sucursal Lanus", new Domicilio("Mitre", 200, "Lanus", "Buenos Aires"),
				Arrays.asList(e1, e2));

		Sucursal s3 = new Sucursal(3, "Sucursal Once", new Domicilio("Av. Puerreydon", 750, "CABA", "CABA"),
				Arrays.asList(e1));

		// SE DEFINES LAS VENTAS PARA QUE SEAN ENTRE ENERO DESDE EL 2021 HASTA LA FECHA
		// ACTUAL

		List<Venta> ventas = new ArrayList<Venta>();

		// SE REALIZA 30 VENTAS ALEATORIAS PARA LA SUCURSAL DE LANUS
		ventas.addAll(generarVentas(s1, new Cliente[] { c1, c2 }, "efectivo", productos, LocalDate.of(2021, 01, 01),
				LocalDate.now(), 30));
		// SE REALIZA 25 VENTAS ALEATORIAS PARA LA SUCURSAL DE LANUS
		ventas.addAll(generarVentas(s2, new Cliente[] { c1, c2 }, "debito", productos, LocalDate.of(2021, 01, 01),
				LocalDate.now(), 25));
		// SE REALIZA 35 VENTAS ALEATORIAS PARA LA SUCURSAL DE ONCE
		ventas.addAll(generarVentas(s3, new Cliente[] { c1, c2 }, "efectivo", productos, LocalDate.of(2021, 01, 01),
				LocalDate.now(), 35));

		// GUARDO LAS VENTAS COMO UNA COLECCION EN LA BASE DE DATOS
		try {
			String uri = "mongodb://localhost:27017";
			MongoClient mongoClient = new MongoClient(new MongoClientURI(uri));
			//mongoClient.dropDatabase("farmacia"); // Elimina la base de datos si existe
			VentaDao.getInstance();
			for (Venta venta : ventas) {
				VentaDao.agregar(venta);
			}
			System.out.println("\nATENCION : Se cargo de manera adecuadad la Base de datos.");
		} catch (Exception e) {
			System.out.println("\nERROR!, hubo problemas en la carga de los datos.");
			e.printStackTrace();
		}
	}

	/**
	 * Genera un numero entero aleatorio entero en un rango
	 * 
	 * @param desde numero desde el cual se podrá generar (incluido)
	 * @param hasta numero hasta el cual se generará (excluido)
	 * @return numero aleatorio
	 */
	public static int numeroAleatorio(int desde, int hasta) {
		return (int) Math.floor(Math.random() * hasta + desde);
	}

	/**
	 * GENERA UNA FECHA ALEATORIA ENTRE DOS FECHAS
	 * 
	 * @param desde fecha desde la cual se genera
	 * @param hasta fecha hasta la cual se genera
	 * @return una fecha que se encuentra en el rango recibido
	 */
	public static LocalDate generarFechaAleatoria(LocalDate desde, LocalDate hasta) {
		long minDay = desde.toEpochDay();
		long maxDay = hasta.toEpochDay();
		long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
		return LocalDate.ofEpochDay(randomDay);
	}

	/**
	 * GENERA UNA LISTA DE VENTAS ALEATORIAS PARA UNA SUCURSAL
	 * 
	 * @param sucursal     sucursal para la cual se generan las ventas
	 * @param clientes     clientes que efecturan las compras
	 * @param formasDePago medios de pagos con los que se pagarán las compras
	 * @param productos    lista de productos que se venderan
	 * @param desde        fecha desde la cual se generan las ventas
	 * @param hasta        fecha hasta la cual se generan las ventas
	 * @param cantidad     cantidad de ventas a generar
	 * @return nueva lista de ventas
	 **/
	public static List<Venta> generarVentas(Sucursal sucursal, Cliente[] clientes, String formaDePago,
			Producto[] productos, LocalDate desde, LocalDate hasta, int cantidadDeVentas) {
		List<Venta> ventas = new ArrayList<Venta>();
		for (int i = 0; i < cantidadDeVentas; i++) {
			Empleado atencion = sucursal.getEmpleados().get(numeroAleatorio(0, sucursal.getEmpleados().size()));
			Empleado cobro = sucursal.getEmpleados().get(numeroAleatorio(0, sucursal.getEmpleados().size()));
			Cliente cliente = clientes[numeroAleatorio(0, clientes.length)];
			LocalDate fecha = generarFechaAleatoria(desde, hasta);
			List<Item> items = new ArrayList<Item>();

			// GENERA DESDE 1 A 3 ITEMS POR VENTAS

			for (int j = 0; j < numeroAleatorio(1, 4); j++) {
				Producto producto = productos[numeroAleatorio(0, productos.length)];
				int cantidadDeProducto = numeroAleatorio(1, 4);

				// CARGAM PRODUCTO ALEATORIAMENTE
				items.add(new Item(producto, cantidadDeProducto));
			}
			// String nroDeTicket = String.valueOf(sucursal.getId()) + "-" +
			// String.valueOf(i);
			ventas.add(new Venta(formaDePago, fecha, cliente, atencion, cobro, sucursal, items));

			// ventas.add(new Venta(nroDeTicket, fecha, atencion, cobro, sucursal, cliente,
			// items));
		}
		return ventas;
	}

	// SE CARGA LA BASE DE DATOS

}
