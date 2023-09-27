package punto10;

import java.time.LocalDate;

public class EmpleadoPorHora extends Empleado{
    private int cantHoras;
    private float valorDeHora;

    public EmpleadoPorHora(String nombre, String apellido, String te, String cuil, LocalDate fecha){
        setNombre(nombre);
        setApellido(apellido);
        setTe(te);
        setCuil(cuil);
        setFechaCumpleaños(fecha);
    }

    @Override
    public void calcularSueldo() {
        float sueldoDelMes;
        if (cantHoras>=40) {
            float valorTotal= cantHoras * valorDeHora;
            valorTotal= (valorTotal*20)/100;
            sueldoDelMes = (cantHoras * valorDeHora)+valorTotal;
        }
        else {
            sueldoDelMes = cantHoras * valorDeHora;
        }

        LocalDate fechaActual=LocalDate.now();
        if (getFechaCumpleaños().getMonth().equals(fechaActual.getMonth())){
            sueldoDelMes+=2000;
            System.out.println("se le dio el regalo del mes del cumpleaños");
        }
        System.out.println("el sueldo de "+getNombre()+" "+getApellido()+" es de: "+sueldoDelMes);
    }

    public int getCantHoras() {
        return cantHoras;
    }

    public void setCantHoras(int cantHoras) {
        this.cantHoras = cantHoras;
    }

    public float getValorDeHora() {
        return valorDeHora;
    }

    public void setValorDeHora(float valorDeHora) {
        this.valorDeHora = valorDeHora;
    }
}
