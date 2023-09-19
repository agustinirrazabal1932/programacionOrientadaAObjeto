package punto1;

public class Actividad {
    private String nombre;
    private String tipoDeActividad;

    public Actividad(String nombre,String tipoDeActividad){
        setNombre(nombre);
        setTipoDeActividad(tipoDeActividad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDeActividad() {
        return tipoDeActividad;
    }

    public void setTipoDeActividad(String tipoDeActividad) {
        this.tipoDeActividad = tipoDeActividad;
    }
}
