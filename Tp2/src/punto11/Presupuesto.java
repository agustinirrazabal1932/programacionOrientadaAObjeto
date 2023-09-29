package punto11;

import java.time.LocalDate;

public class Presupuesto {
    private int id;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private String patenteAlquilar;
    private double precioAlquiler;

    public Presupuesto(LocalDate fechaInicio, LocalDate fechaFinal, String patenteAlquilar,double precioAlquiler,int id) {
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.patenteAlquilar = patenteAlquilar;
        this.precioAlquiler=precioAlquiler;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getPatenteAlquilar() {
        return patenteAlquilar;
    }

    public void setPatenteAlquilar(String patenteAlquilar) {
        this.patenteAlquilar = patenteAlquilar;
    }
}
