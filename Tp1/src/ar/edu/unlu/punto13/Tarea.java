package ar.edu.unlu.punto13;
import java.time.LocalDate;

public class Tarea {
    private Object descripcion;
    private String estado;
    private String prioridad;
    private LocalDate fecha;
    private LocalDate fechaFinalizacion;

    private Colaborador colaboradorFinaliza;

    public void setDescripcion(Object descripcion){
        this.descripcion=descripcion;
    }
    public void setEstado(String estado){
        this.estado=estado;
    }

    public void setFecha(LocalDate fecha){
        this.fecha=fecha;
    }

    public Object getDescripcion(){
        return descripcion;
    }
    public String getEstado(){
        return estado;
    }
    public LocalDate getFecha(){
        return fecha;
    }

    public void setFechaFinalizacion(LocalDate fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public LocalDate getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public Colaborador getColaboradorFinaliza() {
        return colaboradorFinaliza;
    }

    public void setColaboradorFinaliza(Colaborador colaboradorFinaliza) {
        this.colaboradorFinaliza = colaboradorFinaliza;
    }
}
