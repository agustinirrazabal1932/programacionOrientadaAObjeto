package punto11;

import java.time.LocalDate;

public class Combi extends Auto{
    private int precioBase;

    public Combi(int precioBase,String patente,boolean disponible) {
        this.precioBase = precioBase;
        setPatente(patente);
        setDisponible(disponible);
    }

    @Override
    public double calcularMontoFinal(LocalDate fechaInicio, LocalDate fechaFinal) {
        boolean bandera=true;
        LocalDate fechaContador=fechaInicio;
        double monto=0;
        while (bandera){

            if (fechaContador.isEqual(fechaFinal)){
                bandera=false;
            }else {
                monto+=precioBase;
                fechaContador=fechaContador.plusDays(1);
            }
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
