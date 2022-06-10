package db2.grupo02.model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
	
	public Venta() {}
	
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
		this.items = new ArrayList<Item>();
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
	
	public void setTotal() {
		this.total = calcularTotal();
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

	public float calcularTotal() {
		float total = 0;
		for (Item item: this.items) total += item.calcularSubTotal();
		return total;
	}
		
	 public Item traerItem(Producto producto) {
		Item item = null;
		boolean encontrado = false;
		int i = 0, cantidad = this.items.size();
		while((i < cantidad) && (!encontrado)){			
		    if (this.items.get(i).getProducto().equals(producto)) {
		    	item = this.items.get(i);
		    	encontrado = true;
		    }
		    i++;
		}
		return item;
	}
	 
	public boolean agregar(Producto producto, int cantidad) {
		boolean agregar = false;
		Item item = traerItem(producto);
		if ( item == null) {
			agregar = this.items.add(new Item(cantidad, producto));
			this.setTotal(this.getTotal()+producto.getPrecio()*cantidad);
		}
		else{
			item.setCantidad(cantidad + item.getCantidad());
			agregar = true;
			this.setTotal(this.calcularTotal());
		}
		return agregar;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", formaPago=" + formaPago + ", fecha=" + fecha + ", total=" + total + ", cliente="
				+ cliente + ", empleadoAtencion=" + empleadoAtencion + ", empleadoCobro=" + empleadoCobro
				+ ", sucursal=" + sucursal + ", items=" + items + "]";
	}
	
}