package punto11;

import java.time.LocalDate;

public class Alquiler {
    private Cliente cliente;
    private Presupuesto presupuesto;

    public Alquiler(Cliente cliente, Presupuesto presupuesto) {
        this.cliente = cliente;
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {
        String cadena="";
        cadena+="nombre: "+cliente.getNombre()+"\n"+"apellido: "+cliente.getApellido()+"\n";
        cadena+="patente: "+presupuesto.getPatenteAlquilar()+"\n"+"fecha de inicio: "+presupuesto.getFechaInicio()+"\n"+"fecha final: "+presupuesto.getFechaFinal()+"\n"+"monto a pagar: "+presupuesto.getPrecioAlquiler();
        return cadena;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Presupuesto getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Presupuesto presupuesto) {
        this.presupuesto = presupuesto;
    }
}
