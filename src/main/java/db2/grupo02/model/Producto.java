package db2.grupo02.model;

public class Producto {

    private long codNumerico;
    private String descripcion;
    private float precio;
    private TipoProducto tipoProducto;
    private Laboratorio laboratorio;
    
	public Producto(long codNumerico, String descripcion, float precio, TipoProducto tipoProducto,
			Laboratorio laboratorio) {
		super();
		this.codNumerico = codNumerico;
		this.descripcion = descripcion;
		this.precio = precio;
		this.tipoProducto = tipoProducto;
		this.laboratorio = laboratorio;
	}

	public Producto(long codNumerico, String descripcion, float precio, TipoProducto tipoProducto) {
		super();
		this.codNumerico = codNumerico;
		this.descripcion = descripcion;
		this.precio = precio;
		this.tipoProducto = tipoProducto;
	}

	public long getCodNumerico() {
		return codNumerico;
	}

	public void setCodNumerico(long codNumerico) {
		this.codNumerico = codNumerico;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}
   
	public boolean equals(Producto producto) {
		return this.codNumerico == producto.getCodNumerico();
	}

	@Override
	public String toString() {
		return "Producto [codNumerico=" + codNumerico + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", tipoProducto=" + tipoProducto + ", laboratorio=" + laboratorio + "]";
	}
}
