package punto1;

import java.time.LocalDate;

public class Socio {
    private String nombre;
    private String apellido;
    private int edad;
    private String dni;
    private String correoElectronico;
    private String dirrecion;
    private int credencial;
    private String suscripcion;
    private LocalDate fechaDeSuscripcion;


    public Socio(String nombre,String apellido,String dni,String correoElectronico,String dirrecion,int edad){
        setNombre(nombre);
        setApellido(apellido);
        setDni(dni);
        setEdad(edad);
        setCorreoElectronico(correoElectronico);
        setDirrecion(dirrecion);
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDirrecion() {
        return dirrecion;
    }

    public void setDirrecion(String dirrecion) {
        this.dirrecion = dirrecion;
    }

    public int getCredencial() {
        return credencial;
    }

    public void setCredencial(int credencial) {
        this.credencial = credencial;
    }

    public String getSuscripcion() {
        return suscripcion;
    }

    public void setSuscripcion(String suscripcion) {
        this.suscripcion = suscripcion;
    }

    public LocalDate getFechaDeSuscripcion() {
        return fechaDeSuscripcion;
    }

    public void setFechaDeSuscripcion(LocalDate fechaDeSuscripcion) {
        this.fechaDeSuscripcion = fechaDeSuscripcion;
    }
}
