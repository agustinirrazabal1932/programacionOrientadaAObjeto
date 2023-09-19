package punto3;

public class Alumno {
    private String nombre;
    private String apellido;
    private String dni;
    private String teleffono;
    private int credencial;

    public Alumno(String nombre,String apellido,String dni,String telefono,int credencial){
        setNombre(nombre);
        setApellido(apellido);
        setDni(dni);
        setTeleffono(telefono);
        setCredencial(credencial);
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTeleffono() {
        return teleffono;
    }

    public void setTeleffono(String teleffono) {
        this.teleffono = teleffono;
    }

    public int getCredencial() {
        return credencial;
    }

    public void setCredencial(int credencial) {
        this.credencial = credencial;
    }
}
