package db2.grupo02.model;
public class Item {
	
	private int cantidad;
	private Producto producto;
	
	public Item() {}
	
	public Item(int cantidad, Producto producto) {
		super();
		this.cantidad = cantidad;
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public float calcularSubTotal() {
		return this.getProducto().getPrecio()*this.cantidad;
	}
	
	public boolean equals(Item item) {
		return (this.producto.equals(item.getProducto())) && (this.cantidad == item.getCantidad());
	}

	@Override
	public String toString() {
		return "Item [cantidad=" + cantidad + ", producto=" + producto + "]";
	}
}
