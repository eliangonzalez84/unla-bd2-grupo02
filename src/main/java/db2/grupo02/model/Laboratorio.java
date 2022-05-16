package db2.grupo02.model;
public class Laboratorio {
	
    private int id;
    private String nombre;

    public Laboratorio() {}
    
    public Laboratorio(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Laboratorio [id=" + id + ", nombre=" + nombre + "]";
	}
}
