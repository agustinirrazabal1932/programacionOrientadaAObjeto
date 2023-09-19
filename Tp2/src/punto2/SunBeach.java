package punto2;

import java.time.LocalDate;
import java.util.ArrayList;

public class SunBeach {
    private ArrayList<Provedores> provedoresDeTransporte= new ArrayList<Provedores>();
    private ArrayList<Provedores> provedoresDeHospedaje= new ArrayList<Provedores>();
    private ArrayList<Provedores> provedoresDeExcursiones= new ArrayList<Provedores>();
    private ArrayList<Paquete> paquetes= new ArrayList<Paquete>();
    private ArrayList<Cliente> clientes= new ArrayList<Cliente>();
    private ArrayList<Compras> compras= new ArrayList<Compras>();


    public void agregarProvedores(String nombre,String clasificacion,String descrip){
        Provedores provedores=new Provedores(nombre,clasificacion,descrip);
        if(provedores.getClasificacion().equals("medioTransporte")){
            provedoresDeTransporte.add(provedores);
        } else if (provedores.getClasificacion().equals("hospedaje")){
            provedoresDeHospedaje.add(provedores);
        } else{
            provedoresDeExcursiones.add(provedores);
        }
    }
    public void agregarDestino(String destino){
        int nroPaquete= paquetes.size()+1;
        Provedores provedoresTrans=provedoresDeTransporte.get(nroPaquete-1);
        Provedores provedoresHospedaje=provedoresDeHospedaje.get(nroPaquete-1);
        Paquete paquete = new Paquete(nroPaquete,destino,provedoresTrans,provedoresHospedaje,true);
        for (int i = 0; i < provedoresDeExcursiones.size(); i++) {
            Provedores provedorActual=provedoresDeExcursiones.get(i);
            if (provedorActual.getDescripcion().indexOf(destino)!=-1){
                paquete.agregarExcursiones(provedorActual);
            }
        }
        paquetes.add(paquete);
    }
    public void mostrarPaquetes(){
        System.out.println("--- MOSTRAR PAQUETES DE LA AGENCIA--");
        for (int i = 0; i < paquetes.size(); i++) {
            Paquete paqueteActual=paquetes.get(i);
            if (paqueteActual.getEstadoDePaaquete()) {
                System.out.println("PAQUETE NRO " + paqueteActual.getNroDePaquete());
                System.out.println("Destino: " + paqueteActual.getDestino());
                System.out.println("Medio de transporte: " + paqueteActual.getMedioTransporte().getNombreDeLaEmpresa());
                System.out.println("Hospedaje: " + paqueteActual.getHospedaje().getNombreDeLaEmpresa());
                paqueteActual.mostrarExcursion();
            }
        }
    }

    public void agregarClienteYsuCompra(String nombre, String apellido, String dni, LocalDate fecha,int nroPaquete){
        Cliente clienteNuevo = new Cliente(nombre,apellido,dni);
        Paquete paquete = paquetes.get(nroPaquete - 1);
        Compras compra = new Compras(clienteNuevo, fecha, paquete);
        boolean bandera=true;

        for (int i = 0; i < clientes.size(); i++) {
            Cliente clienteActual=clientes.get(i);
            if (clienteActual.getDni().equals(clienteNuevo.getDni())){
                bandera=false;
            }
        }
        if (bandera) {

            clientes.add(clienteNuevo);
            compras.add(compra);

        }else {
            compras.add(compra);
            System.out.println("el cliente ya esta cargado,solo cargo la commpra");
        }
    }
    public void mostrarComprasDeCliente(){
        System.out.println("---MOSTRAR COMPRAS DEL CLIENTE --");
        for (int i = 0; i < clientes.size(); i++) {
            Cliente clienteActual=clientes.get(i);
            System.out.println("--El cliente--");
            System.out.println("Nombre: "+clienteActual.getNombre());
            System.out.println("Apellido: "+clienteActual.getApellido());
            System.out.println("Dni: "+clienteActual.getDni());
            for (int j = 0; j < compras.size(); j++) {
                Compras comprasActual=compras.get(j);
                if (comprasActual.getCliente().getDni().equals(clienteActual.getDni())){
                    System.out.println("Fecha de compra: "+comprasActual.getFechaDeCompra());
                    System.out.println("Destino del Paquete: "+comprasActual.getPaquete().getDestino());
                    System.out.println("nro del Paquete: "+comprasActual.getPaquete().getNroDePaquete());
                }
            }
        }
    }
    private ArrayList<Compras> ordenarComprasPorDestino(){
        ArrayList<Compras> listaNueva=new ArrayList<Compras>();
        for (int i = 0; i < paquetes.size(); i++) {
            Paquete paqueteActual=paquetes.get(i);
            for (int j = 0; j < this.compras.size(); j++) {
                Compras comprasActual=compras.get(j);
                if (paqueteActual.getNroDePaquete()==comprasActual.getPaquete().getNroDePaquete()){
                    listaNueva.add(comprasActual);
                }
            }
        }

        return listaNueva;
    }

    public void informeDeFinDeMes(){
        LocalDate actualFecha= LocalDate.now();
        LocalDate unMesAnte= actualFecha.minusMonths(1);
        this.compras=ordenarComprasPorDestino();
        int numeroDePaqueteAnt=compras.get(0).getPaquete().getNroDePaquete();
        System.out.println("--- INFORME DEL MES--");
        for (int i = 0; i < compras.size(); i++){
            Compras comprasActual=compras.get(i);
            if (comprasActual.getPaquete().getNroDePaquete()==numeroDePaqueteAnt){
                if ( unMesAnte.isBefore(comprasActual.getFechaDeCompra()) && actualFecha.isAfter(comprasActual.getFechaDeCompra())){
                    System.out.println("Destino del Paquete: "+comprasActual.getPaquete().getDestino());
                    System.out.println("nro del Paquete: "+comprasActual.getPaquete().getNroDePaquete());
                    System.out.println("Nombre: "+comprasActual.getCliente().getNombre());
                    System.out.println("Apellido: "+comprasActual.getCliente().getApellido());
                    System.out.println("Dni: "+comprasActual.getCliente().getDni());
                    System.out.println("Fecha de compra: "+comprasActual.getFechaDeCompra());
                }
            }
            else {
                if ( unMesAnte.isBefore(comprasActual.getFechaDeCompra()) && actualFecha.isAfter(comprasActual.getFechaDeCompra())) {
                    System.out.println("Destino del Paquete: " + comprasActual.getPaquete().getDestino());
                    System.out.println("nro del Paquete: " + comprasActual.getPaquete().getNroDePaquete());
                    System.out.println("Nombre: " + comprasActual.getCliente().getNombre());
                    System.out.println("Apellido: " + comprasActual.getCliente().getApellido());
                    System.out.println("Dni: " + comprasActual.getCliente().getDni());
                    System.out.println("Fecha de compra: " + comprasActual.getFechaDeCompra());

                }
                numeroDePaqueteAnt=comprasActual.getPaquete().getNroDePaquete();
            }
        }
    }
    public void mostrarDestinoFavorito(){
        ArrayList<Integer> acumulador=new  ArrayList<Integer>();
        int sumador=0;
        this.compras=ordenarComprasPorDestino();
        String destinoAnt=compras.get(0).getPaquete().getDestino();
        for (int i = 0; i < compras.size(); i++) {
            Compras comprasActual = compras.get(i);
            if (comprasActual.getPaquete().getDestino().equals(destinoAnt)){
                sumador++;
            }
            else {
                acumulador.add(sumador);
                sumador = 0;
                destinoAnt=comprasActual.getPaquete().getDestino();
                sumador++;
            }
        }
        acumulador.add(sumador);

        int mayor=-1;
        String destinoFavorito = "";
        for (int i = 0; i < acumulador.size(); i++) {
            if (acumulador.get(i)>mayor){
                mayor=acumulador.get(i);
                destinoFavorito=paquetes.get(i).getDestino();
            }
        }
        System.out.println("---El destino favorito es: "+destinoFavorito+"---");

    }

}
