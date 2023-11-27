package ar.edu.unlu.juego.vista.consola;

import ar.edu.unlu.juego.controlador.Controlador;
import ar.edu.unlu.juego.modelo.Jugador;

public class FlujoCargaJugador extends Flujo{
    enum estados {
        INGRESE_NOMBRE,
        INGRESE_APELLIDO,
        INGRESE_ID
    }
    private estados estadoActual=estados.INGRESE_NOMBRE;
    private String nombre;
    private String apellido;

    private String idPrincipal;
    public FlujoCargaJugador(ConsolaGrafica vista, Controlador controlador,String idDelPrincipal) {
        super(vista, controlador);
        this.idPrincipal=idDelPrincipal;
    }

    @Override
    public Flujo procesarEntrada(String entrada) {
        switch (estadoActual){
            case INGRESE_NOMBRE-> procesarNombre(entrada);
            case INGRESE_APELLIDO -> procesarApellido(entrada);
            case INGRESE_ID -> {
                return procesarID(entrada);
            }
        }
        return this;
    }

    private Flujo procesarID(String entrada) {
        boolean estaElId=false;
        if (entrada.isEmpty()){
            vista.println("no se puede ingresar un nombre vacio.");
            vista.println("vuelva a intentarlo...");
        }else {
         for (Jugador jugadorAux: controlador.listaDeJugadoresCargados()) {
             if (jugadorAux.getId().equals(entrada)) {
                 estaElId=true;
                 vista.println("El ID ya fue registrado");
                 vista.println("vuelva a intentarlo...");
             }
         }

         if (!estaElId) {
             controlador.cargarUsuario(nombre, apellido, entrada);
             vista.println("el jugador ya se cargo correctamente");
             return new FlujoMenuPrincipal(vista, controlador, idPrincipal);
         }


        }
        return this;
    }

    private void procesarApellido(String entrada) {
        if (entrada.isEmpty()){
            vista.println("no se puede ingresar un nombre vacio.");
            vista.println("vuelva a intentarlo...");
        }else {
            apellido = entrada;
            estadoActual = estados.INGRESE_ID;
        }
    }

    private void procesarNombre(String entrada) {
        if (entrada.isEmpty()){
            vista.println("no se puede ingresar un nombre vacio.");
            vista.println("vuelva a intentarlo...");
        }else {
            nombre = entrada;
            estadoActual = estados.INGRESE_APELLIDO;
        }

    }

    @Override
    public void mostarSiguienteTexto() {
        switch (estadoActual){
            case INGRESE_NOMBRE -> {
                vista.println("----------------------------------------------");
                vista.println("---Ingrese los Datos del Nuevo Jugador---");
                vista.println("ingrese el nombre: ");

            }
            case INGRESE_APELLIDO -> {
                vista.println("Ingrese el Apellido:");
            }
            case INGRESE_ID -> vista.println("Ingrese su ID:");
        }

    }
}
