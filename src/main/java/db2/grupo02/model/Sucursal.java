package db2.grupo02.model;
import java.util.List;

public class Sucursal {
    
    private int id;
    private String descripcion;
    private Domicilio domicilio;
    private List<Empleado> empleados;
    
	public Sucursal(int id, String descripcion, Domicilio domicilio, List<Empleado> empleados) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.domicilio = domicilio;
		this.empleados = empleados;
	}

	public Sucursal(int id, String descripcion, Domicilio domicilio) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.domicilio = domicilio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
   
}
