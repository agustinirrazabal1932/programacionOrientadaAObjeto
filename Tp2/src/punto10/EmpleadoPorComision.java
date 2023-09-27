package punto10;

import java.time.LocalDate;

public class EmpleadoPorComision extends Empleado {
    private int cantVentas;
    private float ValorDeVenta;
    private int porcentajeBruto;

    public EmpleadoPorComision(String nombre, String apellido, String te, String cuil, LocalDate fecha){
        setNombre(nombre);
        setApellido(apellido);
        setTe(te);
        setCuil(cuil);
        setFechaCumpleaños(fecha);
    }

    @Override
    public void calcularSueldo() {
        float sueldoDelMes;
        float totalVentas=cantVentas*ValorDeVenta;
        sueldoDelMes=(totalVentas*porcentajeBruto)/100;

        LocalDate fechaActual=LocalDate.now();
        if (getFechaCumpleaños().getMonth().equals(fechaActual.getMonth())){
            sueldoDelMes+=2000;
            double sumaDeRegalo= (totalVentas*0.5) /100;
            sueldoDelMes+=sumaDeRegalo;
            System.out.println("se le dio el regalo del mes del cumpleaños");
        }
        System.out.println("el sueldo de "+getNombre()+" "+getApellido()+" es de: "+sueldoDelMes);
    }

    public float getValorDeVenta() {
        return ValorDeVenta;
    }

    public void setValorDeVenta(float valorDeVenta) {
        ValorDeVenta = valorDeVenta;
    }

    public int getCantVentas() {
        return cantVentas;
    }

    public void setCantVentas(int cantVentas) {
        this.cantVentas = cantVentas;
    }

    public int getPorcentajeBruto() {
        return porcentajeBruto;
    }

    public void setPorcentajeBruto(int porcentajeBruto) {
        this.porcentajeBruto = porcentajeBruto;
    }
}
