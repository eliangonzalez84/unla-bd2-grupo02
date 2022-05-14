package consultas;

import java.time.LocalDate;

import dataAccessObject.VentaDao;
import db2.grupo02.model.Sucursal;

public class Consulta1 {
     public static void main(String[] args) {
          LocalDate fechaDesde = LocalDate.of(2021, 6, 1);
          LocalDate fechaHasta = LocalDate.now();
          try {
               VentaDao.getInstance();
               // TODAS LAS CADENAS
               String resp1 = VentaDao.detallesYTotalesDeVentas(fechaDesde, fechaHasta);
               System.out.println("\n1. Un reporte con dos resultados, por un lado el total de la cantidad de ventas de toda la\n"
                  		+ "  cadena completa (todas las sucursales) y por otro lado las cantidades de ventas agrupadas por\n"
                  		+ "  sucursales. Todo esto debe ocurrir entre dos fechas pasadas como parámetros (fecha desde y\n"
                  		+ "  fecha hasta).");
                    
               System.out.println("\nTotales y detalles de ventas para toda la cadena");
               System.out.println(resp1);
               
               Sucursal sucursal1 = new Sucursal();  
               sucursal1.setId(1);
               String resp2 = VentaDao.detallesYTotalesDeVentas(fechaDesde, fechaHasta, sucursal1);
               System.out.println("\nTotales y detalles de ventas para la sucursal 1");
               System.out.println(resp2);
          } catch (Exception e) {
               e.printStackTrace();
          }
     }
}