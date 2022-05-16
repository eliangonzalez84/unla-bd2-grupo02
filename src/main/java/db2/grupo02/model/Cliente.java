package db2.grupo02.model;

public class Cliente {

    private long dni;
    private String apellido;
    private String nombre;
    private ObraSocial obraSocial;
    private Domicilio domicilio;
    
    public Cliente() {}
    
	public Cliente(long dni, String apellido, String nombre, ObraSocial obraSocial, Domicilio domicilio) {
		super();
		this.dni = dni;
		this.apellido = apellido;
		this.nombre = nombre;
		this.obraSocial = obraSocial;
		this.domicilio = domicilio;
	}

	public Cliente(long dni, String apellido, String nombre, Domicilio domicilio) {
		super();
		this.dni = dni;
		this.apellido = apellido;
		this.nombre = nombre;
		this.obraSocial = null;
		this.domicilio = domicilio;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ObraSocial getObraSocial() {
		return obraSocial;
	}

	public void setObraSocial(ObraSocial obraSocial) {
		this.obraSocial = obraSocial;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", apellido=" + apellido + ", nombre=" + nombre + ", obraSocial=" + obraSocial
				+ ", domicilio=" + domicilio + "]";
	}
}