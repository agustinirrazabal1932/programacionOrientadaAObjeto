package punto11;

import java.time.LocalDate;

public class Auto {
    private String patente;
    private boolean disponible;


    public double calcularMontoFinal(LocalDate fechaInicio, LocalDate fechaFinal){

        return 0;
    }
    public void seAlquilo(){
        setDisponible(false);
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
