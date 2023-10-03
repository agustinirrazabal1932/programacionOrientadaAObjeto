package punto6;

import java.time.LocalDate;
import java.util.ArrayList;

public class ControlDeVentas {

    private ArrayList<Cliente> listaDeClientes;
    private ArrayList<Empleado> listaDeEmpleados;
    private ArrayList<Surtidores> listaDeSurtidores;
    private ArrayList<Venta> listaDeVentas;
    private int cantSurtidores;

    public ControlDeVentas() {
        this.listaDeClientes =new ArrayList<Cliente>();
        this.listaDeEmpleados = new ArrayList<Empleado>();
        this.listaDeSurtidores = new ArrayList<Surtidores>();
        this.listaDeVentas = new ArrayList<Venta>();
        this.cantSurtidores = 0;
    }

    private void cargarClienteNuevo(String patente, String nombre, String apellido){
        Cliente clienteNuevo= new Cliente(patente,nombre,apellido);
        this.listaDeClientes.add(clienteNuevo);
    }
    public void cargarSurtidor(String tipoCombustible){
        this.cantSurtidores++;
        Surtidores surtidoresNuevo=new Surtidores(this.cantSurtidores,tipoCombustible);
        this.listaDeSurtidores.add(surtidoresNuevo);
    }

    public void cargarEmpleado(String nombre,String apellido,String dni){
        Empleado empleadoNuevo=new Empleado(nombre, apellido, dni);
        this.listaDeEmpleados.add(empleadoNuevo);
    }

    private boolean estaCliente(String patente){
        boolean estaCliente=false;
        for (int i = 0; i < listaDeClientes.size(); i++) {
            Cliente clienteAux=listaDeClientes.get(i);
            if (clienteAux.getPatente().equals(patente)){
                estaCliente=true;
            }
        }
        return estaCliente;
    }
    public void cargarVenta(double monto, String patente,String nombre,String apellido,String dniPlayero, int codigoSurtido, LocalDate fechaDeVenta){
        String tipoCombustible="";
        if (!estaCliente(patente)){
            cargarClienteNuevo(patente,nombre,apellido);
        }
        for (int i = 0; i < listaDeSurtidores.size(); i++) {
            Surtidores surtidoresAux=listaDeSurtidores.get(i);
            if (surtidoresAux.getCodigo()==codigoSurtido){
                tipoCombustible=surtidoresAux.getTipoCombustible();
            }
        }
        Venta venta=new Venta(monto,patente,dniPlayero,codigoSurtido,fechaDeVenta,tipoCombustible);
        this.listaDeVentas.add(venta);
    }

    public void listadoDeProporcionCombustible(){
        int totalDeVenta=this.listaDeVentas.size();
        int ventaDeNafta=0;
        int ventaDeGasoil=0;
        int ventaDeKerosene=0;
        for (int i = 0; i < listaDeVentas.size(); i++) {
            Venta ventaAux=listaDeVentas.get(i);
            if (ventaAux.getTipoCombustible().equals("nafta")){
                ventaDeNafta++;
            } else if (ventaAux.getTipoCombustible().equals("gasoil")) {
                ventaDeGasoil++;
            }else{
                ventaDeKerosene++;
            }
        }
        System.out.println("el porcentaje de la nafta es de: "+(ventaDeNafta*100/totalDeVenta) +"");
    }
}
