package punto12;


import java.time.LocalDate;
import java.util.ArrayList;

public class SistemaBilleteraNueva {
    private ArrayList<Usuario> listaDeClientes= new ArrayList<Usuario>();

    private boolean clienteEsta(String dniCliente){
        boolean estaCliente=false;
        for (int i = 0; i < listaDeClientes.size(); i++) {
            Usuario clienteAux=listaDeClientes.get(i);
            if (clienteAux.getDni().equals(dniCliente)){
                estaCliente=true;
            }
        }
        return estaCliente;
    }

    public String agregarClienteConCuenta(String nombre,String apellido,String dni){
        boolean estaCliente=clienteEsta(dni);
        if (!estaCliente){
            CuentaNormal cuentaNueva= new CuentaNormal(0,30000);
            Usuario clienteNuevo=new Usuario(nombre,apellido,dni,cuentaNueva);
            listaDeClientes.add(clienteNuevo);
            System.out.println("se agrego correctamente el nuevo cliente");
        }
        return dni;
    }
    public String agregarClienteConCuentaYCuentaCredito(String nombre,String apellido,String dni){
        boolean estaCliente=clienteEsta(dni);
        if (!estaCliente){
            CuentaNormal cuentaNueva= new CuentaNormal(0,30000);
            CuentaCredito cuentaCreditoNueva= new CuentaCredito(60000);
            Usuario clienteNuevo=new Usuario(nombre,apellido,dni,cuentaNueva,cuentaCreditoNueva);
            listaDeClientes.add(clienteNuevo);
            System.out.println("se agrego correctamente el nuevo cliente");
        }
        return dni;
    }
    public void agregarCajaDeAhorro(String dni){
        boolean estaCliente=clienteEsta(dni);
        if (estaCliente){
            CajaDeAhorro cajaDeAhorroNueva=new CajaDeAhorro(20000d);
            System.out.println("se cargo correctamente la caja de ahorro");
        }

    }

    public void realizarCompraCuentaSinGirar(String dni,double monto,LocalDate fecha) {
        if (clienteEsta(dni)){
            for (int i = 0; i < listaDeClientes.size(); i++) {
                Usuario clienteAux=listaDeClientes.get(i);
                if (clienteAux.getDni().equals(dni)){
                    clienteAux.realizarGasto(monto);
                }
            }
        }
    }
    public void realizarCompraCuentaNormal(String dni,double monto) {
        if (clienteEsta(dni)){
            for (int i = 0; i < listaDeClientes.size(); i++) {
                Usuario clienteAux=listaDeClientes.get(i);
                if (clienteAux.getDni().equals(dni)){
                    clienteAux.realizarGastoYGirar(monto);
                }
            }
        }
    }
    public void realizarPagoCuenta(String dni,double monto) {
        if (clienteEsta(dni)){
            for (int i = 0; i < listaDeClientes.size(); i++) {
                Usuario clienteAux=listaDeClientes.get(i);
                if (clienteAux.getDni().equals(dni)){
                    clienteAux.realizarPagoDeuda(monto);
                }
            }
        }
    }
    public void realizarInversionCuenta(String dni,double monto,LocalDate fecha) {
        if (clienteEsta(dni)){
            for (int i = 0; i < listaDeClientes.size(); i++) {
                Usuario clienteAux=listaDeClientes.get(i);
                if (clienteAux.getDni().equals(dni)){
                    clienteAux.realizaInversion(monto,fecha);
                }
            }
        }
    }
    public void realizarVerificacionInversionCuenta(String dni, LocalDate fechaR) {
        if (clienteEsta(dni)){
            for (int i = 0; i < listaDeClientes.size(); i++) {
                Usuario clienteAux=listaDeClientes.get(i);
                if (clienteAux.getDni().equals(dni)){
                    clienteAux.VerificarSiPuedoRetirar(fechaR);
                }
            }
        }
    }

    public void realizarCompraCuentaCredito(String dni,double monto) {
        if (clienteEsta(dni)){
            for (int i = 0; i < listaDeClientes.size(); i++) {
                Usuario clienteAux=listaDeClientes.get(i);
                if (clienteAux.getDni().equals(dni)){
                    clienteAux.realizarGastoCuentaCredito(monto);
                }
            }
        }
    }
    public void realizarPagoCuentaCredito(String dni,double monto,int indice) {
        if (clienteEsta(dni)){
            for (int i = 0; i < listaDeClientes.size(); i++) {
                Usuario clienteAux=listaDeClientes.get(i);
                if (clienteAux.getDni().equals(dni)){
                    clienteAux.realizarPago(monto,indice);
                }
            }
        }
    }
    public void VerLasCuentasUsuario(String dni){
        if (clienteEsta(dni)){
            for (int i = 0; i < listaDeClientes.size(); i++) {
                Usuario clienteAux=listaDeClientes.get(i);
                if (clienteAux.getDni().equals(dni)){
                    clienteAux.mostrarEstado();
                }
            }
        }
    }
    public void activarPreCancelar(String dni){
        if (clienteEsta(dni)){
            for (int i = 0; i < listaDeClientes.size(); i++) {
                Usuario clienteAux=listaDeClientes.get(i);
                if (clienteAux.getDni().equals(dni)){
                    clienteAux.activarPreCancelar();
                }
            }
        }
    }

    public void realizarCompraCajaDeAhorro(String dni,double monto) {
        if (clienteEsta(dni)) {
            for (int i = 0; i < listaDeClientes.size(); i++) {
                Usuario clienteAux = listaDeClientes.get(i);
                if (clienteAux.getDni().equals(dni)) {
                    clienteAux.realizarCompraCaja(monto);
                }
            }
        }
    }
    public void realizarPagoCajaDeAhorro(String dni,double monto){
        if (clienteEsta(dni)) {
            for (int i = 0; i < listaDeClientes.size(); i++) {
                Usuario clienteAux = listaDeClientes.get(i);
                if (clienteAux.getDni().equals(dni)) {
                    clienteAux.realizarPagoCaja(monto);
                }
            }
        }
    }
    public void realizarInversionCuentaCaja(String dni,double monto,LocalDate fecha) {
        if (clienteEsta(dni)){
            for (int i = 0; i < listaDeClientes.size(); i++) {
                Usuario clienteAux=listaDeClientes.get(i);
                if (clienteAux.getDni().equals(dni)){
                    clienteAux.realizarInversionCaja(monto,fecha);
                }
            }
        }
    }
    public void realizarVerificacionInversionCuentaCaja(String dni, LocalDate fechaR) {
        if (clienteEsta(dni)){
            for (int i = 0; i < listaDeClientes.size(); i++) {
                Usuario clienteAux=listaDeClientes.get(i);
                if (clienteAux.getDni().equals(dni)){
                    clienteAux.verificarInversionCaja(fechaR);
                }
            }
        }
    }

    public void activarPreCancelarCaja(String dni){
        if (clienteEsta(dni)){
            for (int i = 0; i < listaDeClientes.size(); i++) {
                Usuario clienteAux=listaDeClientes.get(i);
                if (clienteAux.getDni().equals(dni)){
                    clienteAux.activarPrecancelarCaja();
                }
            }
        }
    }
}
