package ar.edu.unlu.juego.vista.consola;

import ar.edu.unlu.juego.controlador.Controlador;
import ar.edu.unlu.juego.modelo.Jugador;

public class FlujoMenuPrincipal extends Flujo {
    private String idDelJugador;
    public FlujoMenuPrincipal(ConsolaGrafica vista, Controlador controlador, String IdPrincipal) {
        super(vista, controlador);
        this.idDelJugador=IdPrincipal;
        this.controlador.agregarID(idDelJugador);
    }


    @Override
    public Flujo procesarEntrada(String string) {
        switch (string) {
            case "1" -> mostrarJugadores();
            case "2" -> {
                return new FlujoCargaJugador(vista,controlador,idDelJugador);
            }
            case "3" -> {
                return new FlujoIniciarJuego(vista,controlador,idDelJugador);
            }
            case "0" -> vista.println("Opcion 5");
            default -> vista.println("Opción inválida");
        }
        return this;
    }


    @Override
    public void mostarSiguienteTexto() {
        vista.println("----- Bienvenido Jugador "+idDelJugador+" -----");
        vista.println("Menú Principal:");
        vista.println("1. Mostrar todos los jugadores");
        vista.println("2. Cargar nuevo Jugador");
        vista.println("3. Iniciar Partida");
        vista.println("0. Salir");
        vista.println("Seleccione una opción: ");
    }

    public void mostrarJugadores(){
        for (Jugador jugadorAux: controlador.listaDeJugadoresCargados()){
            vista.println(jugadorAux.toString());
            vista.println("----");
        }
    }

}
