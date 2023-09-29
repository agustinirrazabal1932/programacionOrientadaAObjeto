package punto11;

import java.time.LocalDate;

public class Camion extends Auto{
    private int precioBase;

    public Camion(int precioBase,String patente,boolean disponible) {
        this.precioBase = precioBase;
        setPatente(patente);
        setDisponible(disponible);
    }

    @Override
    public double calcularMontoFinal(LocalDate fechaInicio, LocalDate fechaFinal) {
        boolean bandera=true;
        LocalDate fechaContador=fechaInicio;
        double monto=0;
        int contador=0;
        while (bandera){

            if (fechaContador.isEqual(fechaFinal)){
                bandera=false;
            } else {
                contador++;
                fechaContador=fechaContador.plusDays(1);
            }
        }
        if (contador<=30){
            monto+=precioBase;
        }else {
            monto+=(contador*7500);
        }
        return monto;
    }

    public int getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(int precioBase) {
        this.precioBase = precioBase;
    }

}
