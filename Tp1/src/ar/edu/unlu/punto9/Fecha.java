package ar.edu.unlu.punto9;

import java.time.LocalDate;

public class Fecha {
    private LocalDate fecha= null;


    public void agregarFecha(int dia, int mes, int año){
        if (dia>0 && dia<=31){
            if (mes>0 && mes<=12){
                if (mes==2 && dia>=28){
                    System.out.println("el mes y la fecha no concuerda.");
                    return;
                }
                if (mes== 4||mes== 6||mes== 9||mes== 11 && dia==31){
                    System.out.println("el mes y la fecha no concuerda.");
                    return;
                }
                if (año>2000 && año<=2030){
                    this.fecha = LocalDate.of(año,mes,dia);
                    System.out.println("se cargo correctamente la fecha");

                }
                else {
                    System.out.println("el año no esta en el rango de 2000 al 2030");
                }

            }
            else {
                System.out.println("el mes no esta en el rango de 1 al 12");
            }

        }
        else {
            System.out.println("el dia no esta en el rango de 1 al 31");
        }

    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void esMayorLaFecha(Fecha fecha2){

        if ( fecha.isBefore(fecha2.getFecha())){
            System.out.println("esta fecha es menor a la que se ingreso por parametro");
        }
        else{
            System.out.println("esta fecha es mayor a la que se ingreso por parametro");
        }
    }
}
