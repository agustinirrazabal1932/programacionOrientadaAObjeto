package punto10;

import java.time.LocalDate;
import java.util.ArrayList;

public class appEmpleados {
    private ArrayList<Empleado> listaDeEmpleados=new ArrayList<Empleado>();

    public void mostraSueldos(){
        for (int i = 0; i < listaDeEmpleados.size(); i++) {
            Empleado empleadoAux=listaDeEmpleados.get(i);
            empleadoAux.calcularSueldo();
        }
    }
    public String cargarEmpleadoPorHora(String nombre,String apellido,String te,String cuil,LocalDate fecha){
        EmpleadoPorHora empleadoPorHoraNuevo=new EmpleadoPorHora(nombre,apellido,te,cuil,fecha);
        listaDeEmpleados.add(empleadoPorHoraNuevo);
        return cuil;
    }
    public void FinDeMesEmpleadoPorHora(String cuil,int cantHoras,float valorHora){
        for (int i = 0; i < listaDeEmpleados.size(); i++) {
            Empleado empleadoAux=listaDeEmpleados.get(i);
            if (empleadoAux.getCuil().equals(cuil)){
                EmpleadoPorHora empleadoPorHoraAux=(EmpleadoPorHora) empleadoAux;
                empleadoPorHoraAux.setCantHoras(cantHoras);
                empleadoPorHoraAux.setValorDeHora(valorHora);
            }
        }
    }
    public String cargarEmpleadoPorComision(String nombre, String apellido, String te, String cuil, LocalDate fecha){
        EmpleadoPorComision empleadoNuevo=new EmpleadoPorComision(nombre,apellido,te,cuil,fecha);
        listaDeEmpleados.add(empleadoNuevo);
        return cuil;
    }

    public void FinDeMesEmpleadoPorComision(String cuil,int cantVentas,float valorVenta,int porcentajeBruto){
        for (int i = 0; i < listaDeEmpleados.size(); i++) {
            Empleado empleadoAux=listaDeEmpleados.get(i);
            if (empleadoAux.getCuil().equals(cuil)){
                EmpleadoPorComision empleadoPorComisionAux=(EmpleadoPorComision) empleadoAux;
                empleadoPorComisionAux.setCantVentas(cantVentas);
                empleadoPorComisionAux.setValorDeVenta(valorVenta);
                empleadoPorComisionAux.setPorcentajeBruto(porcentajeBruto);
            }
        }
    }
    public String cargarEmpleadoPorComisionConSalario(String nombre,String apellido,String te,String cuil,LocalDate fecha){
        EmpleadoPorComisionConSalarioBase empleadoNuevo=new EmpleadoPorComisionConSalarioBase(nombre,apellido,te,cuil,fecha);
        listaDeEmpleados.add(empleadoNuevo);
        return cuil;
    }
    public void FinDeMesEmpleadoPorComisionConSalario(String cuil,int cantVentas,float montoFijo,int porcentajeBruto,float valorVenta){
        for (int i = 0; i < listaDeEmpleados.size(); i++) {
            Empleado empleadoAux = listaDeEmpleados.get(i);
            if (empleadoAux.getCuil().equals(cuil)) {
                EmpleadoPorComisionConSalarioBase empleadoPorComisionConSalarioBaseAux=(EmpleadoPorComisionConSalarioBase)empleadoAux;
                empleadoPorComisionConSalarioBaseAux.setCantVentas(cantVentas);
                empleadoPorComisionConSalarioBaseAux.setPorcentajeBruto(porcentajeBruto);
                empleadoPorComisionConSalarioBaseAux.setMontoFijo(montoFijo);
                empleadoPorComisionConSalarioBaseAux.setValorDeVenta(valorVenta);
            }
        }
    }
    public String cargarEmpleadoAsalariado(String nombre,String apellido,String te,String cuil,LocalDate fecha){
        EmpleadoAsalariado empleadoNuevo=new EmpleadoAsalariado(nombre,apellido,te,cuil,fecha);
        listaDeEmpleados.add(empleadoNuevo);
        return cuil;
    }
    public void FinDeMesEmpleadoAsalariado(String cuil,float montoFijo){
        for (int i = 0; i < listaDeEmpleados.size(); i++) {
            Empleado empleadoAux = listaDeEmpleados.get(i);
            if (empleadoAux.getCuil().equals(cuil)) {
                EmpleadoAsalariado empleadoAsalariadoAux=(EmpleadoAsalariado)empleadoAux;
                empleadoAsalariadoAux.setSumaMes(montoFijo);
            }
        }
    }


}
