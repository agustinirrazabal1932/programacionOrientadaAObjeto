package ar.edu.unlu.juego.vista;

import ar.edu.unlu.juego.controlador.Controlador;

public interface Ivista {
    void setControlador(Controlador controlador);
    void mostrarMenuPrincipal();

    void devolverConsolaGrafica();

    void jugar(String id);

    void terminoJuego(String idGanador);

    void terminoPartida(String idJugador);
}
