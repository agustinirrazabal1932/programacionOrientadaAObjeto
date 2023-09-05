package ar.edu.unlu.punto5;
import java.time.LocalDate;

public class Tarea {
    private Object descripcion;
    private String estado;
    private LocalDate fecha;
    private LocalDate fechaRecordatorio;

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
    public String getestado(){
        return estado;
    }
    public LocalDate getFecha(){
        return fecha;
    }

    public void setFechaRecordatorio(LocalDate fechaRecordatorio) {
        this.fechaRecordatorio = fechaRecordatorio;
    }

    public LocalDate getFechaRecordatorio() {
        return fechaRecordatorio;
    }
}
