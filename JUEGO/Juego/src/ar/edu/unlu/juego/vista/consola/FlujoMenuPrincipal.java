package ar.edu.unlu.juego.vista.consola;

import ar.edu.unlu.juego.controlador.Controlador;
import ar.edu.unlu.juego.modelo.Jugador;

import java.util.ArrayList;

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
            case "4"-> mostrarMaximosGanadores();
            case "0" -> {
                vista.println("Gracias por jugar "+idDelJugador+"...");
                return new FlujoMenuInicial(vista,controlador);
            }
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
        vista.println("4. Mostrar los jugadores mas Ganadores");
        vista.println("0. Salir");
        vista.println("Seleccione una opción: ");
    }

    public void mostrarJugadores(){
        for (Jugador jugadorAux: controlador.listaDeJugadoresCargados()){
            vista.println(jugadorAux.toString());
            vista.println("----");
        }
    }

    private void mostrarMaximosGanadores() {
        ArrayList<Jugador>maxJugadores=new ArrayList<Jugador>();
        maxJugadores.addAll(controlador.listaDeJugadoresCargados());
        boolean bandera=true;
        while (bandera){
            bandera=false;
            for (int j = 0; j < maxJugadores.size()-1; j++) {
                Jugador jugador= maxJugadores.get(j);
                if (jugador.getJuegoGanados()<maxJugadores.get(j+1).getJuegoGanados()){
                    bandera=true;
                    Jugador jugadorAux=maxJugadores.get(j+1);
                    maxJugadores.set((j+1),jugador);
                    maxJugadores.set(j,jugadorAux);
                }
            }
        }
        int i=1;
        vista.println("---------------------------------------------------");
        vista.println("------ Max ganadores del Juego El Dos------");
        for(Jugador jugador:maxJugadores){
            vista.println(i+". "+jugador.toString());
            vista.println("---------------------------------------------------");
        }
    }

}
