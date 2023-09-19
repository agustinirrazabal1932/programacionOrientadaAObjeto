package punto2;

import java.time.LocalDate;

public class Compras {
    private Cliente cliente;
    private LocalDate fechaDeCompra;
    private Paquete paquete;

    public Compras(Cliente cliente,LocalDate fecha,Paquete paquete){
        setCliente(cliente);
        setFechaDeCompra(fecha);
        setPaquete(paquete);
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaDeCompra() {
        return fechaDeCompra;
    }

    public void setFechaDeCompra(LocalDate fechaDeCompra) {
        this.fechaDeCompra = fechaDeCompra;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }
}
