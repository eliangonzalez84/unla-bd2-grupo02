package db2.grupo02.model;

public class Empleado {

    private int dni;
    private int cuil;
    private String apellido;
    private String nombre;
    private Boolean encargado;
    private ObraSocial obraSocial;
    private Domicilio domicilio;
    
	public Empleado(int dni, int cuil, String apellido, String nombre, Boolean encargado, ObraSocial obraSocial,
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

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getCuil() {
		return cuil;
	}

	public void setCuil(int cuil) {
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
	
}
