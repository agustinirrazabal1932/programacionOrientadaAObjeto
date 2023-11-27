package ar.edu.unlu.juego.vista.consola;

import ar.edu.unlu.juego.controlador.Controlador;

public class FlujoIniciarJuego extends Flujo{
    private enum estados{
        INGRESE_JUGADOR2,
    }

    private estados estadoActual=estados.INGRESE_JUGADOR2;
    private String idPrincipal;
    public FlujoIniciarJuego(ConsolaGrafica vista, Controlador controlador,String ID) {
        super(vista, controlador);
        this.idPrincipal=ID;
    }

    @Override
    public Flujo procesarEntrada(String entrada) {
        switch (estadoActual) {
            case INGRESE_JUGADOR2 -> {
                return procesarIDjugador2(entrada);
            }

        }
        return this;
    }

    private Flujo procesarIDjugador2 (String ID){
        if (ID.isEmpty()) {
            vista.println("no se puede ingresar un ID vacio.");
            vista.println("vuelva a intentarlo...");

        } else {

            boolean seEncontroObservadores = controlador.encontrarObservador(ID);
            //boolean seEncontro = controlador.encontrarJugador(ID);
            if (seEncontroObservadores) {
                vista.println("se encontro el jugador 2 correctamente");
                vista.println("---Comienza el Juego---");
                controlador.iniciarPartida2Jugadores(idPrincipal, ID);
                return new FlujoJugador1(vista,controlador, idPrincipal, idPrincipal);
            } else {
                vista.println("no se encontro el jugador 2....");
                return new FlujoMenuPrincipal(vista, controlador, idPrincipal);

            }
        }
        return this;

    }

    @Override
    public void mostarSiguienteTexto() {
        switch (estadoActual) {
            case INGRESE_JUGADOR2 -> {
                vista.println("Ingrese el ID del Jugador 2:");
            }
        }

    }
}
