package punto8;

public class Autor {
    private String nombre;
    private String apellido;

    public Autor(String nombre, String apellido){
        setNombre(nombre);
        setApellido(apellido);
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

    @Override
    public String toString() {
        String cadena="";
        cadena+=getNombre()+"\n";
        cadena+=getApellido();
        return cadena;
    }
}
