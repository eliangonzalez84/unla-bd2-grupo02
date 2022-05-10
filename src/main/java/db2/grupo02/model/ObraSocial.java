package db2.grupo02.model;
public class ObraSocial {
	
    private int id;
    private String nombre;
    private int nro_afiliado;
    
    public ObraSocial(int id, String nombre, int nro_afiliado) {
        this.id = id;
        this.nombre = nombre;
        this.nro_afiliado = nro_afiliado;
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

    public int getNro_afiliado() {
        return nro_afiliado;
    }

    public void setNro_afiliado(int nro_afiliado) {
        this.nro_afiliado = nro_afiliado;
    }

}
