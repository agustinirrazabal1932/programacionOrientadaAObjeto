package punto11;

import java.time.LocalDate;

public class CamionetaFlete extends Auto{
    private int pat;
    private int valorAdicional;

    public CamionetaFlete(int pat, int valorAdicional,String patente,boolean disponible) {
        this.pat = pat;
        this.valorAdicional = valorAdicional;
        setPatente(patente);
        setDisponible(disponible);
    }

    @Override
    public double calcularMontoFinal(LocalDate fechaInicio, LocalDate fechaFinal) {
        boolean bandera=true;
        LocalDate fechaContador=fechaInicio;
        int adicional=pat*valorAdicional;
        double monto=0;
        while (bandera){

            if (fechaContador.isEqual(fechaFinal)){
                bandera=false;
            }else {
                monto+=3000;
                monto+=adicional;
                fechaContador=fechaContador.plusDays(1);
            }
        }
        return monto;
    }

    public int getPat() {
        return pat;
    }

    public void setPat(int pat) {
        this.pat = pat;
    }

    public int getValorAdicional() {
        return valorAdicional;
    }

    public void setValorAdicional(int valorAdicional) {
        this.valorAdicional = valorAdicional;
    }
}
