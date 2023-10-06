package punto6;

import java.time.LocalDate;
import java.util.ArrayList;

public class ControlDeVentas {

    private ArrayList<Cliente> listaDeClientes;
    private ArrayList<Empleado> listaDeEmpleados;
    private ArrayList<Surtidores> listaDeSurtidores;
    private ArrayList<Venta> listaDeVentas;
    private int cantSurtidores;
    private ArrayList<String> listaDeClienteTop10;
    private ArrayList<String> empleadoTop10;

    public ControlDeVentas() {
        this.listaDeClientes =new ArrayList<Cliente>();
        this.listaDeEmpleados = new ArrayList<Empleado>();
        this.listaDeSurtidores = new ArrayList<Surtidores>();
        this.listaDeVentas = new ArrayList<Venta>();
        this.listaDeClienteTop10=new ArrayList<String>();
        this.empleadoTop10=new ArrayList<String>();
        this.cantSurtidores = 0;
    }

    private void cargarClienteNuevo(String patente, String nombre, String apellido){
        Cliente clienteNuevo= new Cliente(patente,nombre,apellido);
        this.listaDeClientes.add(clienteNuevo);
    }
    public void cargarSurtidor(String tipoCombustible,double valor1Litro){
        this.cantSurtidores++;
        Surtidores surtidoresNuevo=new Surtidores(this.cantSurtidores,tipoCombustible,valor1Litro);
        this.listaDeSurtidores.add(surtidoresNuevo);
    }

    public String cargarEmpleado(String nombre,String apellido,String dni){
        Empleado empleadoNuevo=new Empleado(nombre, apellido, dni);
        this.listaDeEmpleados.add(empleadoNuevo);
        return dni;
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
    public void cargarVenta(double litros, String patente,String nombre,String apellido,String dniPlayero, int codigoSurtido, LocalDate fechaDeVenta,boolean senalDeDescuentoEmpleado){
        String tipoCombustible="";
        double monto=0;
        double montoOriginal=0;
        if (!estaCliente(patente)){
            cargarClienteNuevo(patente,nombre,apellido);
        }
        for (int i = 0; i < listaDeSurtidores.size(); i++) {
            Surtidores surtidoresAux=listaDeSurtidores.get(i);
            if (surtidoresAux.getCodigo()==codigoSurtido){
                tipoCombustible=surtidoresAux.getTipoCombustible();
                monto+=(litros*surtidoresAux.getValorDe1Litro());
                montoOriginal=monto;
            }
        }


        for (int i = 0; i < this.listaDeClienteTop10.size(); i++) {
            if (listaDeClienteTop10.get(i).equals(patente)){
                monto-= (montoOriginal*5/100);
                System.out.println("se le hizo el descuento de top 10 cliente.");
            }
        }

        for (int i = 0; i < this.empleadoTop10.size(); i++) {
            for (int j = 0; j < this.listaDeEmpleados.size(); j++) {
                Empleado empleadoAux = listaDeEmpleados.get(j);
                if (empleadoAux.getDni().equals(dniPlayero)) {
                    if (dniPlayero.equals(empleadoTop10.get(i)) && senalDeDescuentoEmpleado && empleadoAux.isDescuento()) {
                        monto -= (montoOriginal * 10 / 100);
                        empleadoAux.setDescuento(false);
                        System.out.println("se le hizo el descuento de top 10 empleado.");
                    }
                }
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
        System.out.println("el porcentaje de la nafta es de: %"+(ventaDeNafta*100/totalDeVenta));
        System.out.println("el porcentaje del gasoil es de: %"+(ventaDeGasoil*100/totalDeVenta));
        System.out.println("el porcentaje del keroseno es de: %"+(ventaDeKerosene*100/totalDeVenta));
    }
    public void ordenarSurtidoresVenta(){

        ArrayList<Double> ventaDeSurtidores=new ArrayList<Double>();
        ArrayList<Integer> listaDeCodigo=new ArrayList<Integer>();
        double monto=0;
        //carga en los nuevo array
        for (int i = 0; i < this.listaDeSurtidores.size(); i++) {
            Surtidores surtidoresAux=this.listaDeSurtidores.get(i);
            int codSurtidor=surtidoresAux.getCodigo();
            monto=0;
            for (int j = 0; j < this.listaDeVentas.size(); j++) {
                Venta ventaAux=this.listaDeVentas.get(j);
                if (ventaAux.getCodigoSurtido()==codSurtidor){
                    monto+=ventaAux.getMonto();
                }
            }
            ventaDeSurtidores.add(monto);
            listaDeCodigo.add(surtidoresAux.getCodigo());
        }

        //ordenar
        boolean bandera=true;
        while (bandera) {
            bandera=false;
            for (int i = 0; i < ventaDeSurtidores.size() - 1; i++) {
                if (ventaDeSurtidores.get(i) < ventaDeSurtidores.get(i + 1)) {
                    bandera=true;
                    double montoAux = ventaDeSurtidores.get(i + 1);
                    int codigoAux = listaDeCodigo.get(i + 1);
                    listaDeCodigo.set(i + 1, listaDeCodigo.get(i));
                    listaDeCodigo.set(i,codigoAux);
                    ventaDeSurtidores.set(i+1,ventaDeSurtidores.get(i));
                    ventaDeSurtidores.set(i,montoAux);

                }
            }
        }

        //mostrar en orden
        System.out.println("Ordenar Los Sutidores De Mayor a Menor en Monto de Venta:");
        for (int i = 0; i <ventaDeSurtidores.size(); i++) {
            System.out.println("el surtidor numero: "+listaDeCodigo.get(i)+", y el monto es de: "+ventaDeSurtidores.get(i));
        }

    }
    public void ordenarSurtidoresLitros(){
        ArrayList<Double> cantLitros=new ArrayList<Double>();
        ArrayList<Integer> listaDeCodigo=new ArrayList<Integer>();
        double litros=0;

        //cargar datos a la lista
        for (int i = 0; i < this.listaDeSurtidores.size(); i++) {
            Surtidores surtidoresAux=this.listaDeSurtidores.get(i);
            int codSurtidor=surtidoresAux.getCodigo();
            litros=0;

            //recorro la venta
            for (int j = 0; j < this.listaDeVentas.size(); j++) {
                Venta ventaAux=this.listaDeVentas.get(j);
                if (ventaAux.getCodigoSurtido()==codSurtidor){
                    litros+=ventaAux.getMonto()/surtidoresAux.getValorDe1Litro();
                }
            }

            //guardo en la lista nueva
            cantLitros.add(litros);
            listaDeCodigo.add(surtidoresAux.getCodigo());
        }

        //ordenar
        boolean bandera=true;
        while (bandera) {
            bandera=false;
            for (int i = 0; i < cantLitros.size() - 1; i++) {
                if (cantLitros.get(i) < cantLitros.get(i + 1)) {
                    bandera=true;
                    double litroAux = cantLitros.get(i + 1);
                    int codigoAux = listaDeCodigo.get(i + 1);
                    listaDeCodigo.set(i + 1, listaDeCodigo.get(i));
                    listaDeCodigo.set(i,codigoAux);
                    cantLitros.set(i+1,cantLitros.get(i));
                    cantLitros.set(i,litroAux);

                }
            }
        }

        //mostrar en orden
        System.out.println("Ordenar Los Sutidores De Mayor a Menor en Litros:");
        for (int i = 0; i <cantLitros.size(); i++) {
            System.out.println("el surtidor numero: "+listaDeCodigo.get(i)+", y el litro es de: "+cantLitros.get(i));
        }
    }

    public void verEmpleadoTop10YActualizar(){

        ordenarEmpleadoMonto();
        System.out.println("Ordenar Los Empleados De Mayor a Menor en Monto de Venta:");
        for (int i = 0; i <this.empleadoTop10.size(); i++) {

            for (int j = 0; j < this.listaDeEmpleados.size(); j++) {
                Empleado empleadoAux= this.listaDeEmpleados.get(j);

                if(empleadoAux.getDni().equals(empleadoTop10.get(i))){
                    System.out.println((i+1) + " empleado : " + empleadoAux.getNombre() + ", " + empleadoAux.getApellido());
                }
            }
        }
    }
    private void ordenarEmpleadoMonto(){

        ArrayList<Double> ventaDeEmpleados=new ArrayList<Double>();
        double monto;
        //carga en los nuevo array

        for (int i = 0; i < this.listaDeEmpleados.size(); i++) {
            Empleado empleadoAux=this.listaDeEmpleados.get(i);
            String dniEmpleado=empleadoAux.getDni();
            monto=0;

            //recorro la venta
            for (int j = 0; j < this.listaDeVentas.size(); j++) {
                Venta ventaAux=this.listaDeVentas.get(j);
                if (ventaAux.getDniPlayero().equals(dniEmpleado)){
                    monto+=ventaAux.getMonto();
                }
            }

            //guardo en la lista nueva
            ventaDeEmpleados.add(monto);
            empleadoTop10.add(dniEmpleado);
        }

        //ordenar
        boolean bandera=true;
        while (bandera) {
            bandera=false;
            for (int i = 0; i < ventaDeEmpleados.size() - 1; i++) {
                if (ventaDeEmpleados.get(i) < ventaDeEmpleados.get(i + 1)) {
                    bandera=true;
                    double montoAux = ventaDeEmpleados.get(i + 1);
                    String dniAux = empleadoTop10.get(i + 1);
                    empleadoTop10.set(i + 1, empleadoTop10.get(i));
                    empleadoTop10.set(i,dniAux);
                    ventaDeEmpleados.set(i+1,ventaDeEmpleados.get(i));
                    ventaDeEmpleados.set(i,montoAux);
                }
            }
        }

        //eliminar sobrantes;
        for (int i = 0; i <empleadoTop10.size(); i++) {
            if (i>9){
                empleadoTop10.remove(i);
            }
        }
    }

    public void verClienteTop10YActualizar(){
        ordenarClienteCompra();
        //mostrar en orden
        System.out.println("Ordenar Los 10 Clientes De Mayor a Menor en Monto de Compra:");
        for (int i = 0; i < listaDeClienteTop10.size(); i++) {
            for (int j = 0; j < this.listaDeClientes.size(); j++) {
                Cliente cliente = this.listaDeClientes.get(j);
                if (cliente.getPatente().equals(listaDeClienteTop10.get(i))) {
                    System.out.println((i+1)+" cliente : " + cliente.getNombre() + ", " + cliente.getApellido());
                }
            }
        }
    }
    private void ordenarClienteCompra(){

        ArrayList<Double> compraDeCliente=new ArrayList<Double>();

        double monto;
        //carga en los nuevo array

        for (int i = 0; i < this.listaDeClientes.size(); i++) {
            Cliente ClienteAux=this.listaDeClientes.get(i);
            String patenteCliente=ClienteAux.getPatente();
            monto=0;

            //recorro la venta
            for (int j = 0; j < this.listaDeVentas.size(); j++) {
                Venta ventaAux=this.listaDeVentas.get(j);
                if (ventaAux.getPatente().equals(patenteCliente)){
                    monto+=ventaAux.getMonto();
                }
            }

            //guardo en la lista nueva
            compraDeCliente.add(monto);
            this.listaDeClienteTop10.add(patenteCliente);
        }

        //ordenar
        boolean bandera=true;
        while (bandera) {
            bandera=false;
            for (int i = 0; i < compraDeCliente.size() - 1; i++) {
                if (compraDeCliente.get(i) < compraDeCliente.get(i + 1)) {
                    bandera=true;
                    double montoAux = compraDeCliente.get(i + 1);
                    String patenteAux = this.listaDeClienteTop10.get(i + 1);

                    this.listaDeClienteTop10.set(i + 1, this.listaDeClienteTop10.get(i));
                    this.listaDeClienteTop10.set(i,patenteAux);

                    compraDeCliente.set(i+1,compraDeCliente.get(i));
                    compraDeCliente.set(i,montoAux);
                }
            }
        }

        //eliminar extras
        int contador=0;
        for (int i = 0; i < this.listaDeClienteTop10.size(); i++) {
            if (i>9){
                this.listaDeClienteTop10.remove(i);
            }
        }

    }
}
