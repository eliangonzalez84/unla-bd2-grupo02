package db2.grupo02.model;

public class Empleado {

    private long dni;
    private String cuil;
    private String apellido;
    private String nombre;
    private Boolean encargado;
    private ObraSocial obraSocial;
    private Domicilio domicilio;
    
    public Empleado() {}
    
	public Empleado(long dni, String cuil, String apellido, String nombre, Boolean encargado, ObraSocial obraSocial,
			Domicilio domicilio) {
		super();
		this.dni = dni;
		this.cuil = cuil;
		this.apellido = apellido;
		this.nombre = nombre;
		this.encargado = encargado;
		this.obraSocial = obraSocial;
		this.domicilio = domicilio;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
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

	public Boolean getEncargado() {
		return encargado;
	}

	public void setEncargado(Boolean encargado) {
		this.encargado = encargado;
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
		return "Empleado [dni=" + dni + ", cuil=" + cuil + ", apellido=" + apellido + ", nombre=" + nombre
				+ ", encargado=" + encargado + ", obraSocial=" + obraSocial + ", domicilio=" + domicilio + "]";
	}
}
