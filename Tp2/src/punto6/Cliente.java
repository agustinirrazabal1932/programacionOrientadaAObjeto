package punto6;

public class Cliente {
    private String patente;
    private String nombre;
    private String apellido;

    public Cliente(String patente, String nombre, String apellido) {
        this.patente = patente;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
