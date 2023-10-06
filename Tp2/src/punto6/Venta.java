package punto6;

import java.time.LocalDate;

public class Venta {

    private double monto;
    private String patente;
    private String dniPlayero;
    private int codigoSurtido;
    private LocalDate fechaVenta;
    private String tipoCombustible;

    public Venta(double monto, String patente, String dniPlayero, int codigoSurtido, LocalDate fechaVenta, String tipoCombustible) {
        this.monto =monto;
        this.patente = patente;
        this.dniPlayero = dniPlayero;
        this.codigoSurtido = codigoSurtido;
        this.fechaVenta = fechaVenta;
        this.tipoCombustible = tipoCombustible;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getDniPlayero() {
        return dniPlayero;
    }

    public void setDniPlayero(String dniPlayero) {
        this.dniPlayero = dniPlayero;
    }

    public int getCodigoSurtido() {
        return codigoSurtido;
    }

    public void setCodigoSurtido(int codigoSurtido) {
        this.codigoSurtido = codigoSurtido;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }
}
