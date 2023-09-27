package punto10;

import java.time.LocalDate;

public class Empleado {
    private String nombre;
    private String apellido;
    private String te;
    private String cuil;
    private LocalDate fechaCumpleaños;

    public void calcularSueldo(){

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

    public String getTe() {
        return te;
    }

    public void setTe(String te) {
        this.te = te;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public LocalDate getFechaCumpleaños() {
        return fechaCumpleaños;
    }

    public void setFechaCumpleaños(LocalDate fechaCumpleaños) {
        this.fechaCumpleaños = fechaCumpleaños;
    }
}
