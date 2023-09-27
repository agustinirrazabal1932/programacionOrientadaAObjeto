package punto10;

import java.time.LocalDate;

public class EmpleadoAsalariado extends Empleado{
    private float sumaMes;

    public EmpleadoAsalariado(String nombre, String apellido, String te, String cuil, LocalDate fecha){
        setNombre(nombre);
        setApellido(apellido);
        setTe(te);
        setCuil(cuil);
        setFechaCumpleaños(fecha);
    }

    @Override
    public void calcularSueldo() {
        float sueldoDelMes =getSumaMes();
        LocalDate fechaActual=LocalDate.now();
        if (getFechaCumpleaños().getMonth().equals(fechaActual.getMonth())){
            sueldoDelMes+=3000;
            System.out.println("se le dio el regalo del mes del cumpleaños");
        }
        System.out.println("el sueldo de "+getNombre()+" "+getApellido()+" es de: "+sueldoDelMes);

    }

    public float getSumaMes() {
        return sumaMes;
    }

    public void setSumaMes(float sumaMes) {
        this.sumaMes = sumaMes;
    }
}
