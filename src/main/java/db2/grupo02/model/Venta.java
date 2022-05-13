package db2.grupo02.model;
import java.time.LocalDate;
import java.util.List;

import clasesPojos.Item;

public class Venta{

	private int id;
	private String formaPago;
	private LocalDate fecha;
	private float total;
	private Cliente cliente;
	private Empleado empleadoAtencion;
	private Empleado empleadoCobro;
	private Sucursal sucursal;
	private List<Item> items;
	
	public Venta(int id, String formaPago, LocalDate fecha, float total, Cliente cliente, Empleado empleadoAtencion,
			Empleado empleadoCobro, Sucursal sucursal) {
		super();
		this.id = id;
		this.formaPago = formaPago;
		this.fecha = fecha;
		this.total = total;
		this.cliente = cliente;
		this.empleadoAtencion = empleadoAtencion;
		this.empleadoCobro = empleadoCobro;
		this.sucursal = sucursal;
	}

	public Venta(int id, String formaPago, LocalDate fecha, float total, Cliente cliente, Empleado empleadoAtencion,
			Empleado empleadoCobro, Sucursal sucursal, List<Item> items) {
		super();
		this.id = id;
		this.formaPago = formaPago;
		this.fecha = fecha;
		this.total = total;
		this.cliente = cliente;
		this.empleadoAtencion = empleadoAtencion;
		this.empleadoCobro = empleadoCobro;
		this.sucursal = sucursal;
		this.items = items;
	}

	public Venta(String formaPago, LocalDate fecha, Cliente cliente, Empleado empleadoAtencion,
			Empleado empleadoCobro, Sucursal sucursal, List<Item> items) {
		super();
		this.formaPago = formaPago;
		this.fecha = fecha;
		this.total = calcularTotal();
		this.cliente = cliente;
		this.empleadoAtencion = empleadoAtencion;
		this.empleadoCobro = empleadoCobro;
		this.sucursal = sucursal;
		this.items = items;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleadoAtencion() {
		return empleadoAtencion;
	}

	public void setEmpleadoAtencion(Empleado empleadoAtencion) {
		this.empleadoAtencion = empleadoAtencion;
	}

	public Empleado getEmpleadoCobro() {
		return empleadoCobro;
	}

	public void setEmpleadoCobro(Empleado empleadoCobro) {
		this.empleadoCobro = empleadoCobro;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	private float calcularTotal() {
		float total = 0;
		for(Item item: items) {
			total += item.getCantidad() * item.getProducto().getPrecio();
		}
		return total;
	}
	
}