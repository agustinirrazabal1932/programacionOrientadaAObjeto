package punto8;

public class Socio {
    private String nombre;
    private String apellido;
    private String telefono;
    private int id;

    public Socio(String nommbre,String apellido, String telefono,int id){
        setNombre(nommbre);
        setApellido(apellido);
        setTelefono(telefono);
        setId(id);
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
