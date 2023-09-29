package punto11;

import java.time.LocalDate;

public class AutoPasajero extends Auto{
    private boolean esVip;
    private int cantAsientos;

    public AutoPasajero(boolean esVip, int cantAsientos,String patente,boolean estado){
        setPatente(patente);
        setDisponible(estado);
        this.esVip = esVip;
        this.cantAsientos = cantAsientos;
    }

    @Override
    public double calcularMontoFinal(LocalDate fechaInicio, LocalDate fechaFinal) {
        boolean bandera=true;
        LocalDate fechaContador=fechaInicio;
        int adicional;
        double monto=0;
        while (bandera){

            if (fechaContador.isEqual(fechaFinal)){
                bandera=false;
            }
            else {
                monto+=3000;
                if (this.esVip){
                    adicional=cantAsientos*500;
                    monto+=adicional;
                }else{
                    adicional=cantAsientos*300;
                    monto+=adicional;
                }
                fechaContador=fechaContador.plusDays(1);
            }
        }
        return monto;
    }

    public boolean isEsVip() {
        return esVip;
    }

    public void setEsVip(boolean esVip) {
        this.esVip = esVip;
    }

    public int getCantAsientos() {
        return cantAsientos;
    }

    public void setCantAsientos(int cantAsientos) {
        this.cantAsientos = cantAsientos;
    }

}
