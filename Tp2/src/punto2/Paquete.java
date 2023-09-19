package punto2;

import java.util.ArrayList;

public class Paquete {
    private int nroDePaquete;
    private String destino;
    private Provedores medioTransporte;
    private Provedores hospedaje;
    private boolean EstadoDePaaquete;
    private ArrayList<Provedores> listaDeExcursiones= new ArrayList<Provedores>();

    public Paquete(int nroDePaquete,String destino,Provedores medioTransporte,Provedores hospedaje,boolean estadoDePaaquete){
        setNroDePaquete(nroDePaquete);
        setDestino(destino);
        setHospedaje(hospedaje);
        setMedioTransporte(medioTransporte);
        setEstadoDePaaquete(estadoDePaaquete);
    }
    public void agregarExcursiones(Provedores excursion){
        listaDeExcursiones.add(excursion);
    }
    public void mostrarExcursion(){
        if (listaDeExcursiones.size()!=0) {
            System.out.println("Excursion:");
            for (int i = 0; i < listaDeExcursiones.size(); i++) {
                Provedores excursion = listaDeExcursiones.get(i);
                System.out.println("Nombre: " + excursion.getNombreDeLaEmpresa());
                System.out.println("Actividad: " + excursion.getDescripcion());
            }
        }
    }

    public int getNroDePaquete() {
        return nroDePaquete;
    }

    public void setNroDePaquete(int nroDePaquete) {
        this.nroDePaquete = nroDePaquete;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Provedores getMedioTransporte() {
        return medioTransporte;
    }

    public void setMedioTransporte(Provedores medioTransporte) {
        this.medioTransporte = medioTransporte;
    }

    public Provedores getHospedaje() {
        return hospedaje;
    }

    public void setHospedaje(Provedores hospedaje) {
        this.hospedaje = hospedaje;
    }

    public boolean getEstadoDePaaquete() {
        return EstadoDePaaquete;
    }

    public void setEstadoDePaaquete(boolean estadoDePaaquete) {
        EstadoDePaaquete = estadoDePaaquete;
    }
}
