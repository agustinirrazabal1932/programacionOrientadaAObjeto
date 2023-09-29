package punto11;


public class Cliente {
    private String nombre;
    private String apellido;
    private String dni;
    public Cliente(String nombre, String apellido, String dni){
        setDni(dni);
        setNombre(nombre);
        setApellido(apellido);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
