package ar.edu.unlu.juego.vista.consola;

import ar.edu.unlu.juego.controlador.Controlador;

public class FlujoMenuInicial extends Flujo{
    
    private enum estados{
        INGRESAR_ID, INGRESAR_REGISTRO, INGRESAR_APELLIDO, INGRESAR_NUEVO_ID, MENSAJE_ENTRADA
    }
    
    private estados estadosActual=estados.MENSAJE_ENTRADA;
    private String nombre;
    private String apellido;
    public FlujoMenuInicial(ConsolaGrafica vista, Controlador controlador) {
        super(vista, controlador);
    }
    
    @Override
    public Flujo procesarEntrada(String string) {
        switch (estadosActual){
            case MENSAJE_ENTRADA -> procesarSiEstaRegistrado(string);
            case INGRESAR_ID -> {
               return procesarID(string);
            }
            case INGRESAR_REGISTRO -> procesarRegistro(string);
            case INGRESAR_APELLIDO -> procesarApellido(string);
            case INGRESAR_NUEVO_ID -> {
                return procesarNuevoID(string);
            }
        }
        return this;
    }

    private Flujo procesarNuevoID(String string) {

        if (string.isEmpty()){
            vista.println("----- NO PUEDE INGRESAR ID VACIO -----");
            estadosActual=estados.INGRESAR_NUEVO_ID;
        }else {
            boolean isJugador=controlador.encontrarJugador(string);
            if (isJugador){
                vista.println("----- EL ID ESTA REGISTRADO POR OTRO JUGADOR EN EL JUEGO -----");
            }else {
                vista.println("----- SE CARGO PERFECTAMENTE EL ID -----");
                controlador.cargarUsuario(nombre,apellido,string);
                return new FlujoMenuPrincipal(vista,controlador,string);
            }
        }
        return this;
    }

    private void procesarApellido(String string) {
        if (string.isEmpty()) {
            vista.println("----- NO PUEDE INGRESAR APELLIDO VACIO -----");
            estadosActual = estados.INGRESAR_REGISTRO;
        }
        else{
            vista.println("----- SE CARGO PERFECTAMENTE EL APELLIDO -----");
            apellido=string;
            estadosActual=estados.INGRESAR_NUEVO_ID;
        }
    }

    private void procesarRegistro(String string) {
        if (string.isEmpty()) {
            vista.println("----- NO PUEDE INGRESAR NOMBRE VACIO -----");
            estadosActual = estados.INGRESAR_REGISTRO;
        }
        else{
            vista.println("----- SE CARGO PERFECTAMENTE EL NOMBRE -----");
            nombre=string;
            estadosActual=estados.INGRESAR_APELLIDO;
        }
    }

    private Flujo procesarID(String string) {
        if (string.isEmpty()){
            vista.println("----- NO PUEDE INGRESAR ID VACIO -----");
            estadosActual=estados.INGRESAR_ID;
        }else {
            boolean isJugador=controlador.encontrarJugador(string);
            if (isJugador){
                vista.println("----- SE ENCONTRO PERFECTAMENTE EL ID -----");
                return new FlujoMenuPrincipal(vista,controlador,string);
            }else {
                vista.println("----- EL ID NO ESTA CARGADO EN EL JUEGO -----");
                estadosActual=estados.MENSAJE_ENTRADA;
                return this;
            }
        }
        return this;
    }

    private void procesarSiEstaRegistrado(String string) {
        switch (string) {
            case "1" -> {
                estadosActual=estados.INGRESAR_ID;
            }
            case "2" -> {
                estadosActual=estados.INGRESAR_REGISTRO;
            }
            default -> vista.println("Opción inválida");
        }
    }

    @Override
    public void mostarSiguienteTexto() {
        switch (estadosActual){
            case MENSAJE_ENTRADA -> {
                vista.println("----- BIENVENIDO AL JUEGO EL DOS -----");
                vista.println("----- ¿ESTA REGIISTRADO EN EL JUEGO? -----");
                vista.println("----- 1. SI");
                vista.println("----- 2. NO");
            }
            case INGRESAR_ID -> {
                vista.println("----- INGRESE SU ID ABAJO -----");
            }
            case INGRESAR_REGISTRO -> {
                vista.println("----- INGRESE SU NOMBRE ABAJO -----");
            }
            case INGRESAR_APELLIDO -> {
                vista.println("----- INGRESE SU APELLIDO ABAJO -----");
            }
            case INGRESAR_NUEVO_ID -> {
                vista.println("----- INGRESE EL ID QUE VA USAR ABAJO -----");
            }
        }
        
        

    }
}
