package ar.edu.unlu.juego.modelo;


import java.util.ArrayList;
import java.util.Scanner;

public class Modelo implements Observado {
    private Mazo mazo;
    private ArrayList<Jugador> listaDeJuegadores;
    private ArrayList<Carta> cartasBocaArriba;
    private ArrayList<Carta> cartasUsadas;
    private ArrayList<Jugador> partida;
    private Validacion validacion;
    private ArrayList<Observadores> observadores;

    public Modelo() {
        this.mazo = new Mazo();
        this.mazo.mezclar();
        this.mazo.mezclar();
        this.listaDeJuegadores =new ArrayList<Jugador>();
        this.cartasBocaArriba = new ArrayList<Carta>();
        this.cartasUsadas = new ArrayList<Carta>();
        this.partida=new ArrayList<Jugador>();
        this.observadores= new ArrayList<Observadores>();
    }
    public void cargarUsuarioAdm(String nombre,String apellido,String id){
            Jugador jugadorNuevo=new Jugador(nombre,apellido,id);
            listaDeJuegadores.add(jugadorNuevo);
    }

    public void cargarUsuariosConJuegosGanados(String nombre,String apellido,String id,int juegos){
        Jugador jugadorNuevo=new Jugador(nombre, apellido, id);
        jugadorNuevo.agregarGanadas(juegos);
        this.listaDeJuegadores.add(jugadorNuevo);
    }
    public void verCartaMazo(){
        this.mazo.mezclar();
        this.mazo.VerMazo();
    }
    public void verCartaBocaArriba(){
        if (!this.cartasBocaArriba.isEmpty()) {
            for (Carta cartaAux : this.cartasBocaArriba) {
                System.out.println(cartaAux);
            }
        }else {
            System.out.println("Ya no hay cartas boca Arriba libres en la mesa para armar juegos...");
        }
    }
    public void iniciarPartida2Jugadores(String idJugador1,String idJugador2) {

        //busco si el id esta en el juego;
        Jugador jugador2 = null;
        for (Jugador jugadorAux : this.listaDeJuegadores) {
            if (jugadorAux.getId().equals(idJugador2)) {
                jugador2 = jugadorAux;
            }
        }

        if (jugador2 != null) {

            //busco si el id esta en el juego;
            Jugador jugador1 = null;
            for (Jugador jugadorAux : this.listaDeJuegadores) {
                if (jugadorAux.getId().equals(idJugador1)) {
                    jugador1 = jugadorAux;
                }
            }

            if (jugador1 != null) {

                //cargo los jugadores en la partida
                cargarJugadoresPartida(jugador1, jugador2);
                //esperarEnter();


                //reparte las carta de la mano

                int totalDeCarta = 7 * this.partida.size();
                int manejoDeReparto = 0;
                int maxJugador = this.partida.size();
                for (int i = 0; i < totalDeCarta; i++) {
                    Carta cartaAux = this.mazo.darCarta();
                    if (cartaAux != null) {

                        if (manejoDeReparto == 0) {
                            jugador1.tomarCarta(cartaAux);
                        } else if (manejoDeReparto == 1) {
                            jugador2.tomarCarta(cartaAux);
                        }

                        manejoDeReparto++;
                        if (manejoDeReparto == maxJugador) {
                            manejoDeReparto = 0;
                        }

                    }
                }


                //poner la dos carta boca arriba en la meza
                for (int i = 0; i < 2; i++) {
                    Carta cartaBocaArriba = this.mazo.darCarta();
                    if (cartaBocaArriba != null) {
                        this.cartasBocaArriba.add(cartaBocaArriba);
                    }
                }
            }
        }
    }

                //empezar a jugar
//                boolean finDeLaPartida = false;
//                boolean finDelJuego = false;
//                int turno = 0;
//                boolean juegoDobleColor2 = false;
//                boolean juegoDobleColor1 = false;
//                while (!finDelJuego) {
//                    while (!finDeLaPartida) {
//
//                        if (turno == 0) {
//
//                            }
//                            //verifico si algun jugador no dijo dos
//                            verificarSiJugadorDijoDos(jugador1);
//
//                            //verifico si se quedo sin carta el jugador 1
//                            if (jugador1.catidadDeCartasDeMano() == 0) {
//                                finDeLaPartida = true;
//                                System.out.println("¡¡¡¡ Termino La partida el ganador es " + jugador2.getId() + " !!!!");
//                                esperarEnter();
//
//                                //le sumo los valores de la carta del jugador contrario
//                                sumarValores(jugador2);
//                                //poner todas las cartas de los otros jugadores en el mazo
//                                limpiarManoDeJugadores(jugador2);
//                            }
//
//                        } else if (turno == 2) {
//
//                            }
//                            //verifico si algun jugador no dijo dos
//                            verificarSiJugadorDijoDos(jugador2);
//
//                            //verifico si se quedo sin carta el jugador 2
//                            if (jugador2.catidadDeCartasDeMano() == 0) {
//                                finDeLaPartida = true;
//                                System.out.println("¡¡¡¡ Termino La partida el ganador es " + jugador2.getId() + " !!!!");
//                                esperarEnter();
//
//                                //le sumo los valores de la carta del jugador contrario
//                                sumarValores(jugador2);
//                                //poner todas las cartas de los otros jugadores en el mazo
//                                limpiarManoDeJugadores(jugador2);
//                            }
//                        }
//                        turno++;
//                        if (turno > maxJugador) {
//                            turno = 0;
//                        }
//                    }
//                    //para agarrar todas las cartas que se usaron en la partida y ponerla en el mazo
//                    sinCartasEnElMazo();
//                    //poner las cartas boca arriba en el mazo y limpiar el array de cartas boca arriba
//                    for (Carta cartaAux: cartasBocaArriba){
//                        mazo.tomarCartaMazo(cartaAux);
//                    }
//                    cartasBocaArriba.clear();
//
//                    //verifico si termino el juego
//                    if (verificarSiTerminoELjuego()){
//                        finDelJuego=true;
//                    }
//                }
//                //busco al ganador y muestro y limpio los puntos de todos lo de la partida
//                buscarGanador();
//                partida.clear();
//            }
//        }
//    }

    private void limpiarPuntosDeJugadores() {
        for (Jugador jugadorAux : partida){
            jugadorAux.limpiarPuntos();
        }
    }

    private boolean verificarSiTerminoELjuego() {
        boolean termino=false;
        for (Jugador jugadorAux:partida){
            if (jugadorAux.getPuntos() >= 200) {
                termino = true;
                break;
            }
        }
        return termino;
    }

    private void limpiarManoDeJugadores(Jugador jugadorGanador) {
        for (Jugador jugador: partida) {
            if (!jugador.getId().equals(jugadorGanador.getId())) {
                ArrayList<Carta> cartasDeLaMano=jugador.liberarMano();
                for (Carta cartaAux: cartasDeLaMano){
                    mazo.tomarCartaMazo(cartaAux);
                }
                cartasDeLaMano.clear();
            }
        }
    }

    private void sumarValores(Jugador jugadorASumar) {
        int total=0;
        for (Jugador jugador: partida){
            if (!jugador.getId().equals(jugadorASumar.getId())){
                total+=jugador.valorDeCartasDeMano();
            }

        }
        jugadorASumar.sumarPuntos(total);
    }

    private void verificarSiJugadorDijoDos(Jugador jugador1) {
        for (Jugador jugadorPartida:this.partida){
            if (!jugadorPartida.getId().equals(jugador1.getId())){
                if (jugadorPartida.catidadDeCartasDeMano()<=2){
                    if (!jugadorPartida.isDecirDos()){
                        System.out.println("el jugador "+jugadorPartida.getId()+" no dijo DOS y" +
                                " le quedan 2 o 1 cartas en la mano...");
                        System.out.println("entoces tomara dos cartas del mazo...");
                        for (int i = 0; i < 2; i++) {
                            Carta carta=this.mazo.darCarta();
                            if (carta!=null){
                                jugadorPartida.tomarCarta(carta);
                            }else {
                                sinCartasEnElMazo();
                                Carta cartaNueva=this.mazo.darCarta();
                                jugadorPartida.tomarCarta(cartaNueva);
                            }
                        }
                        esperarEnter();
                    }
                }
            }
        }
    }

    private void cargarJugadoresPartida(Jugador jugador1, Jugador jugador2) {
        this.partida.add(jugador1);
        this.partida.add(jugador2);
        //System.out.println("Se encontraron los 2 jugadores en la partida...");
    }

    private void esperarEnter(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Para Continuar presione Enter...");
        sc.nextLine();
    }
    private boolean menuJugador(Jugador jugador1) {
        Scanner sc = new Scanner(System.in);
        boolean juegoSimpleFull = false;
        boolean juegoSimple = false;
        boolean juegoDoble = false;
        boolean juegoDobleFull = false;
        boolean tomarCarta = false;
        int opcion = 0;
        int opcionFinal = 1;
        if (juegoSimple) {


        } else if (opcion == 5) {
            if (jugador1.catidadDeCartasDeMano() <= 2) {
                jugador1.avisarDeDos();
                esperarEnter();
            } else {
                System.out.println("ingrese una opcion valida...");
                esperarEnter();
            }
        } else {
            System.out.println("ingrese una opcion valida...");
            esperarEnter();
        }

        //verifico si tine 2 o menos carta en la mano despues de descartar 1 por hacer un juego de color
        if (jugador1.catidadDeCartasDeMano() <= 2 && !jugador1.isDecirDos()) {
            boolean validarDatoString = false;
            while (!validarDatoString) {
                System.out.println("Tiene 2 o menos cartas en la mano...");
                System.out.println("¿Quiere decir DOS?");
                System.out.println("1. Si");
                System.out.println("2. No");
                System.out.println("seleccione un numero de la opciones");
                String decirDos = sc.nextLine();
                if (decirDos.equals("1")) {
                    validarDatoString = true;
                    jugador1.avisarDeDos();
                    esperarEnter();
                } else if (decirDos.equals("2")) {
                    validarDatoString = true;
                } else {
                    System.out.println("ingrese una opcion correcta...");
                    esperarEnter();
                }
            }
        }
        return juegoDobleFull;

    }

    private void removerCartasUsadasDoble(Carta cartaUsar1, Carta cartaUsar2, Carta cartaUsarBocaArriba) {
        this.cartasUsadas.add(cartaUsar1);
        this.cartasUsadas.add(cartaUsar2);
        this.cartasBocaArriba.remove(cartaUsarBocaArriba);
        this.cartasUsadas.add(cartaUsarBocaArriba);
    }

    private void removerCartasUsadas(Carta cartaUsar, Carta cartaUsarBocaArriba) {
        this.cartasUsadas.add(cartaUsar);
        this.cartasBocaArriba.remove(cartaUsarBocaArriba);
        this.cartasUsadas.add(cartaUsarBocaArriba);
    }

    private void sinCartasEnElMazo() {
        for (Carta cartaAux:this.cartasUsadas){
            this.mazo.tomarCartaMazo(cartaAux);
        }
        this.cartasUsadas.clear();
        this.mazo.mezclar();
        this.mazo.mezclar();
    }

    public ArrayList<Jugador> VerTodosLosJugadores() {
        return listaDeJuegadores;
    }

    public ArrayList<Carta> encontrarCartaJugador(String idJugador1) {
        for (Jugador jugadorAux: partida){
            if (jugadorAux.getId().equals(idJugador1)){
                return jugadorAux.verCartaDelJugador();
            }
        }
        return null;
    }

    public ArrayList<Carta> CartasBocaArriba() {
        return cartasBocaArriba;
    }

    public Jugador encontrarJugador(String idJugador1) {
        for (Jugador jugadorAux: listaDeJuegadores){
            if (jugadorAux.getId().equals(idJugador1)){
                return jugadorAux;
            }
        }
        return null;
    }

    public boolean validarCombinacionSimple(String jugadorID,int cartaElegidaJ1, Integer cartaBocaArribaOp) {
        Jugador jugador=encontrarJugador(jugadorID);
        Carta cartaElegida=jugador.seleccionarCarta(cartaElegidaJ1);
        Carta cartaBocaArriba=cartasBocaArriba.get(cartaBocaArribaOp-1);
        validacion=new Validacion(cartaElegida,cartaBocaArriba);
        boolean juegoSimple=validacion.validarSimple();

        return juegoSimple;
    }
    public boolean validarColor(String jugadorID,int cartaElegidaJ1, Integer cartaBocaArribaOp){
        Jugador jugador=encontrarJugador(jugadorID);
        Carta cartaElegida=jugador.seleccionarCarta(cartaElegidaJ1);
        Carta cartaBocaArriba=cartasBocaArriba.get(cartaBocaArribaOp-1);
        validacion=new Validacion(cartaElegida,cartaBocaArriba);
        boolean colorV=validacion.validarColor();
        return colorV;
    }

    public void eliminarCartaUsadas(String jugadorID, int cartaElegidaJ1, Integer cartaBocaArribaOp) {
        Jugador jugador=encontrarJugador(jugadorID);
        Carta cartaElegida=jugador.seleccionarCarta(cartaElegidaJ1);
        Carta cartaBocaArriba=cartasBocaArriba.get(cartaBocaArribaOp-1);

        //muevo la carta al lugar de cartas usadas
        jugador.UsateLaCartaMano(cartaElegida);
        removerCartasUsadas(cartaElegida,cartaBocaArriba);

    }

    public boolean validarCombinacionDoble(boolean isComodin,String jugadorID, int cartaElegidaJ1, int carta2ElegidaJ1, int cartaBocaArribaOp,int numeroCartaBocaArriba) {
        Jugador jugador=encontrarJugador(jugadorID);
        Carta cartaElegida=jugador.seleccionarCarta(cartaElegidaJ1);
        Carta carta2Elegida=jugador.seleccionarCarta(carta2ElegidaJ1);
        Carta cartaBocaArriba=cartasBocaArriba.get(cartaBocaArribaOp-1);
        validacion=new Validacion(cartaElegida,carta2Elegida,cartaBocaArriba);
        boolean juegoDoble=validacion.validarDoble(isComodin,numeroCartaBocaArriba);

        return juegoDoble;
    }

    public boolean validarComodin(Integer cartaBocaArribaOp) {
        boolean isComodin=false;
        Carta cartaBocaArriba=cartasBocaArriba.get(cartaBocaArribaOp-1);
        if (cartaBocaArriba.getNumero()==0){
            isComodin=true;
        }
        return isComodin;
    }

    public void eliminarCartaUsadasDoble(String jugadorID, int cartaElegidaJ1,int carta2ElegidaJ1 ,Integer cartaBocaArribaOp) {
        Jugador jugador=encontrarJugador(jugadorID);
        Carta cartaElegida=jugador.seleccionarCarta(cartaElegidaJ1);
        Carta carta2Elegida=jugador.seleccionarCarta(carta2ElegidaJ1);
        Carta cartaBocaArriba=cartasBocaArriba.get(cartaBocaArribaOp-1);

        jugador.UsateLaCartaMano(cartaElegida);
        jugador.UsateLaCartaMano(carta2Elegida);
        removerCartasUsadasDoble(cartaElegida,carta2Elegida,cartaBocaArriba);
    }

    public boolean validarColorDoble(String jugadorID, int cartaElegidaJ1, int carta2ElegidaJ1, Integer cartaBocaArribaOp) {
        Jugador jugador=encontrarJugador(jugadorID);
        Carta cartaElegida=jugador.seleccionarCarta(cartaElegidaJ1);
        Carta carta2Elegida=jugador.seleccionarCarta(carta2ElegidaJ1);
        Carta cartaBocaArriba=cartasBocaArriba.get(cartaBocaArribaOp-1);
        validacion=new Validacion(cartaElegida,carta2Elegida,cartaBocaArriba);
        boolean colorV=validacion.validarColorDoble();
        return colorV;
    }

    public boolean tomarCartaMazo(String idJugador) {
        boolean tomarCarta=false;
        Jugador jugador=encontrarJugador(idJugador);
        Carta cartaNueva = this.mazo.darCarta();
        if (cartaNueva != null) {
            jugador.tomarCarta(cartaNueva);
            tomarCarta=true;
        } else {
            sinCartasEnElMazo();
        }
        return tomarCarta;
    }

    public void ponerCartaBocaArriba(Integer opcion, String idJugador) {
        Jugador jugador=encontrarJugador(idJugador);
        Carta cartaElegida=jugador.seleccionarCarta(opcion);
        cartasBocaArriba.add(cartaElegida);
    }

    public void eliminarCartaUsadas(String idJugador1, int cartaElegidaJ1) {
        Jugador jugador=encontrarJugador(idJugador1);
        Carta cartaElegida=jugador.seleccionarCarta(cartaElegidaJ1);
        jugador.UsateLaCartaMano(cartaElegida);

    }

    public void rellenarCartaBocaArriba() {
        //verifico si faltan cartas boca arriba,tienen que ser dos siempre

        if (this.cartasBocaArriba.isEmpty()){
            for (int i = 0; i < 2; i++) {
                Carta cartaNuevaBocaArriba=this.mazo.darCarta();
                if (cartaNuevaBocaArriba!=null){
                    this.cartasBocaArriba.add(cartaNuevaBocaArriba);
                }else {
                    sinCartasEnElMazo();
                    cartaNuevaBocaArriba=this.mazo.darCarta();
                    this.cartasBocaArriba.add(cartaNuevaBocaArriba);

                }
            }

        } else if (cartasBocaArriba.size() == 1) {
            Carta cartaNuevaBocaArriba=this.mazo.darCarta();
            if (cartaNuevaBocaArriba!=null){
                this.cartasBocaArriba.add(cartaNuevaBocaArriba);
            }else {
                sinCartasEnElMazo();
                cartaNuevaBocaArriba=this.mazo.darCarta();
                this.cartasBocaArriba.add(cartaNuevaBocaArriba);

            }
        }
    }
    public void hiceJuegoDoble(String idJugador){
        for (Jugador jugadorAux:partida) {
            if (!jugadorAux.getId().equals(idJugador)) {
                Carta cartaPorJuegoDoble = this.mazo.darCarta();
                if (cartaPorJuegoDoble != null) {
                    jugadorAux.tomarCarta(cartaPorJuegoDoble);
                } else {
                    sinCartasEnElMazo();
                    cartaPorJuegoDoble = this.mazo.darCarta();
                    jugadorAux.tomarCarta(cartaPorJuegoDoble);
                }
            }
        }
    }

    public boolean tareasDeFinDePartida(String idJugador) {
        Jugador jugadorGanoPartida=encontrarJugador(idJugador);
        sumarValores(jugadorGanoPartida);

        //para agarrar todas las cartas que se usaron en la partida y ponerla en el mazo
        sinCartasEnElMazo();
        //poner las cartas boca arriba en el mazo y limpiar el array de cartas boca arriba
        for (Carta cartaAux: cartasBocaArriba){
            mazo.tomarCartaMazo(cartaAux);
        }
        cartasBocaArriba.clear();

        limpiarManoDeJugadores(jugadorGanoPartida);
        boolean isGanador=verificarSiTerminoELjuego();
        if (isGanador){
            avisarQueTerminoJuego(idJugador);
            limpiarPuntosDeJugadores();
            partida.clear();
        }
        return isGanador;

    }

    private void avisarQueTerminoJuego(String idJugadorGanador) {
        for (Observadores observadores1 : observadores) {
            String idControl = observadores1.devolverID();
            if (!idControl.equals(idJugadorGanador)) {
                observadores1.TerminoJuego(idJugadorGanador);
            }
        }
    }

    public void sumarVictoria(String idJugador) {
        Jugador jugadorGanoPartida=encontrarJugador(idJugador);
        jugadorGanoPartida.sumarJuegoGanado();
    }

    @Override
    public void attach(Observadores controlador) {
        observadores.add(controlador);
    }

    @Override
    public void detach(Observadores Controlador) {
        observadores.remove(Controlador);
    }

    @Override
    public void notifyMessage() {

    }

    @Override
    public void informarJugadorQueEntroALaPartida(String id) {
        for (Observadores observadores1 : observadores) {
            String idControl = observadores1.devolverID();
            if (idControl.equals(id)) {
                observadores1.update();
            }
        }
    }

    @Override
    public void informarJugadorQueLeToca(String id) {

        for (Observadores observadores1 : observadores) {
            String idControl = observadores1.devolverID();
            if (idControl.equals(id)) {
                observadores1.jugar(id);
            }
        }
    }

    public boolean buscarObservador(String id) {
        boolean bandera=false;

        for (Observadores observadores1 : observadores) {
            String idControl = observadores1.devolverID();
            if (idControl.equals(id) && !bandera) {
                bandera = true;
            }
        }
        return bandera;
    }

    public void cambioTurno(String idPrincipal) {
        boolean bandera=false;
        String idControl="";
        int contador=0;
        int contadorFinal=0;

        for (Observadores observadores1 : observadores) {
            idControl = observadores1.devolverID();
            if (idControl.equals(idPrincipal) && !bandera) {
                bandera = true;
                contadorFinal=contador;
            }
            contador++;
        }

        if (bandera){
            if (contadorFinal==(observadores.size()-1)) {
                Observadores observadorAux=observadores.get(0);
                idControl=observadorAux.devolverID();
                informarJugadorQueLeToca(idControl);
                System.out.println("el id que se paso fue " + idControl);
            }else {
                Observadores observadorAux=observadores.get(contadorFinal+1);
                idControl=observadorAux.devolverID();
                informarJugadorQueLeToca(idControl);
                System.out.println("el id que se paso fue " + idControl);
            }
        }
    }
}
