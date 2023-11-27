package ar.edu.unlu.juego.controlador;

import ar.edu.unlu.juego.modelo.Carta;
import ar.edu.unlu.juego.modelo.Jugador;
import ar.edu.unlu.juego.modelo.Modelo;
import ar.edu.unlu.juego.modelo.Observadores;
import ar.edu.unlu.juego.vista.Ivista;
import ar.edu.unlu.juego.vista.consola.ConsolaGrafica;
import ar.edu.unlu.juego.vista.consola.FlujoEsperar;

import java.util.ArrayList;

public class Controlador implements Observadores {
    private  Ivista vistaJuego;
    private Modelo modeloJuego;
    private String IdPrincipal;

    public Controlador(Ivista vistaJuego){
        this.vistaJuego = vistaJuego;
        vistaJuego.setControlador(this);
        this.IdPrincipal="";
    }
    public void cargarUsuario(String nombre,String apellido,String id){
        modeloJuego.cargarUsuarioAdm(nombre, apellido, id);
    }
    public void iniciarPartida2Jugadores(String idJugador1, String idJugador2){
        this.modeloJuego.iniciarPartida2Jugadores(idJugador1,idJugador2);
        this.modeloJuego.informarJugadorQueEntroALaPartida(idJugador2);
    }

    public void setModeloJuego(Modelo modeloJuego) {

        this.modeloJuego = modeloJuego;
        this.modeloJuego.attach(this);
    }

    public ArrayList<Jugador> listaDeJugadoresCargados(){
        ArrayList<Jugador> jugadores;
        jugadores=modeloJuego.VerTodosLosJugadores();
        return jugadores;
    }

    public ArrayList<Carta> cartasDelJugador(String idJugador1) {
        return modeloJuego.encontrarCartaJugador(idJugador1);
    }

    public ArrayList<Carta> cartasBocaArriba() {
        return modeloJuego.CartasBocaArriba();
    }

    public Integer cantidadCartaJugador(String idJugador1) {
        Jugador jugador1= modeloJuego.encontrarJugador(idJugador1);
        return jugador1.catidadDeCartasDeMano();
    }

    public boolean validarCombinacionSimple(String jugador,int cartaElegidaJ1, Integer cartaBocaArribaOp) {
        boolean validacion=modeloJuego.validarCombinacionSimple(jugador,cartaElegidaJ1,cartaBocaArribaOp);
        return validacion;
    }

    public boolean validarColor(String idJugador1, int cartaElegidaJ1, Integer cartaBocaArribaOp) {
        boolean validacion=modeloJuego.validarColor(idJugador1,cartaElegidaJ1,cartaBocaArribaOp);
        return validacion;
    }

    public boolean encontrarJugador(String id) {
        boolean seEncontro=false;
        Jugador jugadorAux=modeloJuego.encontrarJugador(id);
        if (jugadorAux != null){
            seEncontro=true;
        }
        return seEncontro;
    }

    public void eliminarCartaUsadas(String idJugador1, int cartaElegidaJ1, Integer cartaBocaArribaOp) {
        modeloJuego.eliminarCartaUsadas(idJugador1,cartaElegidaJ1,cartaBocaArribaOp);
    }

    public boolean validarCombinacionDoble(boolean isComodin,String idJugador1, int cartaElegidaJ1, int carta2ElegidaJ1, int cartaBocaArribaOp,int numeroCartaBocaArriba) {
        boolean validacion=modeloJuego.validarCombinacionDoble(isComodin,idJugador1,cartaElegidaJ1,carta2ElegidaJ1,cartaBocaArribaOp,numeroCartaBocaArriba);
        return validacion;
    }

    public boolean validarSiEsComodin(Integer cartaBocaArribaOp) {
        boolean validacion=modeloJuego.validarComodin(cartaBocaArribaOp);
        return validacion;
    }

    public boolean validarColorDoble(String idJugador1, int cartaElegidaJ1, int carta2ElegidaJ1, Integer cartaBocaArribaOp) {
        boolean validacion=modeloJuego.validarColorDoble(idJugador1,cartaElegidaJ1,carta2ElegidaJ1,cartaBocaArribaOp);
        return validacion;
    }

    public void eliminarCartaUsadasDoble(String idJugador1, int cartaElegidaJ1, int carta2ElegidaJ1, Integer cartaBocaArribaOp) {
        modeloJuego.eliminarCartaUsadasDoble(idJugador1,cartaElegidaJ1,carta2ElegidaJ1,cartaBocaArribaOp);
    }

    public boolean tomarCartaMazo(String idJugador) {

        boolean tomarCarta=modeloJuego.tomarCartaMazo(idJugador);
        if (!tomarCarta){
            tomarCarta=modeloJuego.tomarCartaMazo(idJugador);
        }
        return tomarCarta;
    }

    public void hiceJuegoDoble(String idJugador) {
        modeloJuego.hiceJuegoDoble(idJugador);
    }

    public void eliminarCartaUsadas(String idJugador1, int cartaElegidaJ1) {
        modeloJuego.eliminarCartaUsadas(idJugador1,cartaElegidaJ1);
    }

    public void ponerBocaArriba(Integer opcion,String idJugador) {
        modeloJuego.ponerCartaBocaArriba(opcion,idJugador);
    }

    public void rellenarCartaBocaArriba() {
        modeloJuego.rellenarCartaBocaArriba();
    }


    public boolean tareasDeFinDePartida(String idJugador) {
        return modeloJuego.tareasDeFinDePartida(idJugador);
    }

    public void sumarVictoria(String idJugador) {
        modeloJuego.sumarVictoria(idJugador);
    }

    @Override
    public void update() {
        vistaJuego.devolverConsolaGrafica();
    }

    @Override
    public String devolverID() {
        return IdPrincipal;
    }

    @Override
    public void jugar(String id) {
        vistaJuego.jugar(id);
    }

    public void agregarID(String idDelJugador) {
        this.IdPrincipal=idDelJugador;
    }

    public boolean encontrarObservador(String id) {
        return modeloJuego.buscarObservador(id);
    }

    public void terminoTurno(String idPrincipal) {
        modeloJuego.cambioTurno(idPrincipal);
    }
}
