package punto11;

import java.time.LocalDate;
import java.util.ArrayList;

public class SistemaAgenciaDeAuto {
    private ArrayList<Auto> listaDeAutos=new ArrayList<Auto>();
    private ArrayList<Cliente> listaDeClientes= new ArrayList<Cliente>();
    private ArrayList<Alquiler> listaDeAlquileres= new ArrayList<Alquiler>();
    private ArrayList<Presupuesto> listasDePresopuesto= new ArrayList<Presupuesto>();
    private int cantPresupuesto=0;


    public void verMontoDelSistema(){
        double monto=0;
        for (int i = 0; i < listaDeAlquileres.size(); i++) {
            Alquiler alquilerAux=listaDeAlquileres.get(i);
            monto+=alquilerAux.getPresupuesto().getPrecioAlquiler();
        }
        System.out.println("El total de todos los alquileres del sistema es de: "+monto);
    }
    public void mostrarAlquileresDeUnCliente(String dniCliente){
        System.out.println("---Mostrar Alquileres---");
        for (int i = 0; i < listaDeAlquileres.size(); i++) {
            Alquiler alquilerAux=listaDeAlquileres.get(i);
            if (alquilerAux.getCliente().getDni().equals(dniCliente)){
                System.out.println(alquilerAux);
            }
        }
    }
    public void confirmarPresupuesto(String dniCliente,int idPresupuesto){
        Cliente estaCliente=null;
        Presupuesto estaPresupuesto=null;
        for (int i = 0; i < listaDeClientes.size(); i++) {
            Cliente clienteAux=listaDeClientes.get(i);
            if (clienteAux.getDni().equals(dniCliente)){
                estaCliente=clienteAux;
            }
        }
        if (estaCliente!=null){
            for (int i = 0; i <listasDePresopuesto.size() ; i++) {
                Presupuesto presupuestoAux=listasDePresopuesto.get(i);
                if (presupuestoAux.getId()==idPresupuesto){
                    estaPresupuesto=presupuestoAux;
                }
            }
            if (estaPresupuesto!=null){
                String patente=estaPresupuesto.getPatenteAlquilar();
                Auto autoEsta=null;
                for (int i = 0; i < listaDeAutos.size(); i++) {
                    Auto autoAux=listaDeAutos.get(i);
                    if (autoAux.getPatente().equals(patente) && autoAux.isDisponible()){
                        autoEsta=autoAux;
                    }
                }
                if (autoEsta!=null) {
                    Alquiler alquilerNuevo = new Alquiler(estaCliente, estaPresupuesto);
                    listaDeAlquileres.add(alquilerNuevo);
                    autoEsta.seAlquilo();
                    System.out.println("el alquiler se hizo correctamente");
                }
            }
        }

    }
    public int hacerPresupuesto(String patente,String dniCliente,LocalDate fechaInicio,LocalDate fechaFinal){
        boolean estaCliente=false;
        int idPresupuesto=0;
        for (int i = 0; i < listaDeClientes.size(); i++) {
            Cliente clienteAux=listaDeClientes.get(i);
            if (clienteAux.getDni().equals(dniCliente)){
                estaCliente=true;
            }
        }
        Auto autoDePatente=null;
        if (estaCliente){
            for (int i = 0; i < listaDeAutos.size(); i++) {
                Auto autoAux=listaDeAutos.get(i);
                if (autoAux.getPatente().equals(patente) && autoAux.isDisponible()){
                    autoDePatente=autoAux;
                }
            }
            if (autoDePatente!=null){
                double precio=autoDePatente.calcularMontoFinal(fechaInicio,fechaFinal);
                this.cantPresupuesto++;
                Presupuesto presupuestoNuevo=new Presupuesto(fechaInicio,fechaFinal,patente,precio,cantPresupuesto);
                listasDePresopuesto.add(presupuestoNuevo);
                idPresupuesto=cantPresupuesto;

            }
        }

        return idPresupuesto;

    }
    public String cargarCliente(String nombre,String apellido,String dni){
        Cliente clienteNuevo= new Cliente(nombre,apellido,dni);
        listaDeClientes.add(clienteNuevo);
        return dni ;
    }
    private boolean verificarPatente(String patente){
        boolean estaPatente=false;
        for (int i = 0; i < listaDeAutos.size(); i++) {
            Auto autoAux=listaDeAutos.get(i);
            if (autoAux.getPatente().equals(patente)){
                estaPatente=true;
            }
        }
        return estaPatente;
    }
    public void cargarAutoPasajero(String patente,boolean siEsVip,int cantAsientos){
        if (!verificarPatente(patente)) {
            AutoPasajero autoPasajeroNuevo = new AutoPasajero(siEsVip, cantAsientos, patente, true);
            listaDeAutos.add(autoPasajeroNuevo);
        }
    }
    public void cargarAutoCombi(String patente,int precioBase){
        if (!verificarPatente(patente)) {
            Combi combiNueva = new Combi(precioBase, patente, true);
            listaDeAutos.add(combiNueva);
        }
    }
    public void cargarCamionetaFlete(String patente,int pesoPat,int precioAdicional){
        if (!verificarPatente(patente)) {
            CamionetaFlete camionetaFleteNueva = new CamionetaFlete(pesoPat, precioAdicional, patente, true);
            listaDeAutos.add(camionetaFleteNueva);
        }

    }
    public void cargarCamion(String patente,int precioBase){
        if (!verificarPatente(patente)) {
            Camion camionNuevo = new Camion(precioBase, patente, true);
            listaDeAutos.add(camionNuevo);
        }
    }
}
