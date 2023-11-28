package ar.edu.unlu.juego.vista.consola;

import ar.edu.unlu.juego.controlador.Controlador;
import ar.edu.unlu.juego.modelo.Carta;

public class FlujoJugador1 extends Flujo{


    private enum estados{
        INICIAR_TURNO_JUGADOR1,
        COMBINACION_SIMPLE_J1,
        ELIGE_CARTA_BOCA_ARRIBA,
        ELIGE_CARTA_PONER_BOCA_ARRIBA,
        COMBINACION_DOBLE_J1,
        COMBINACION_DOBLE_CARTA2_J1,
        ELIGE_CARTA_BOCA_ARRIBA_JUEGO_DOBLE_J1,
        CARTA_BOCA_ARRIBA_COMODIN,
        TOMAR_CARTA_DE_MAZO_J1,
        PASAR_TURNO,
        FIN_TURNO, FIN_JUEGO, VER_PUNTOS_JUEGO,

    }
    private estados estadoActual=estados.INICIAR_TURNO_JUGADOR1;
    private String idPrincipal;
    private String idJugador1;
    private String idJugador2;
    private int cartaElegidaJ1;
    private int carta2ElegidaJ1;
    private int cartaBocaArriba;
    private boolean juegoSimpleFull=false;
    private boolean juegoDobleFull=false;
    private boolean tomarCarta=false;
    private boolean juegoSimple=false;
    private boolean juegoDoble=false;


    public FlujoJugador1(ConsolaGrafica vista, Controlador controlador,String idJugador1,String idPrincipal) {

        super(vista, controlador);
        this.idJugador1=idJugador1;
        this.idPrincipal=idPrincipal;
    }

    @Override
    public Flujo procesarEntrada(String entrada) {
        switch (estadoActual){
            case VER_PUNTOS_JUEGO -> procesarLosPuntos(entrada);
            case INICIAR_TURNO_JUGADOR1 -> procesarTurnoJugador1(entrada);
            case COMBINACION_SIMPLE_J1 -> procesarIngresoCartaJuegoSimple(entrada);
            case ELIGE_CARTA_BOCA_ARRIBA -> procesarCombinacionJ1(entrada);
            case ELIGE_CARTA_PONER_BOCA_ARRIBA -> procesarJuegoConColor(entrada);
            case COMBINACION_DOBLE_J1 -> procesarIngresoCarta1(entrada);
            case COMBINACION_DOBLE_CARTA2_J1 -> procesarIngresoCarta2(entrada);
            case ELIGE_CARTA_BOCA_ARRIBA_JUEGO_DOBLE_J1 -> procesarCombinacionDoble(entrada);
            case CARTA_BOCA_ARRIBA_COMODIN -> procesarCombinacionDobleConComodin(entrada);
            case TOMAR_CARTA_DE_MAZO_J1 -> estadoActual=estados.INICIAR_TURNO_JUGADOR1;
            case PASAR_TURNO -> procesarPaso();
            case FIN_TURNO -> {
                return procesarFinTurno();
            }
            case FIN_JUEGO -> {
                return procesarFinPartida();
            }
        }
        return this;
    }

    private void procesarLosPuntos(String entrada) {
        int numeroEntrada;
        try {
            numeroEntrada=Integer.parseInt(entrada);
            if (numeroEntrada!=1){
                vista.println("Ingrese una opcion Correcta...");
                estadoActual=estados.VER_PUNTOS_JUEGO;
            }else {

                int totalJugadores=controlador.jugadoresPartida();
                for (int i = 0; i < totalJugadores; i++) {
                    String nombreId=controlador.jugadorNombrePartida(i);
                    int puntosId=controlador.jugadorPuntosPartida(i);
                    vista.println("JUGADOR: "+nombreId+", PUNTOS: "+puntosId);
                    vista.println("------------------------------------------");
                }
                estadoActual=estados.INICIAR_TURNO_JUGADOR1;
            }
        } catch (NumberFormatException e) {
            vista.println("Ingrese un número válido.");
        }
    }

    private Flujo procesarFinPartida() {
        vista.println("termino la Partida...");
        boolean isGanador=controlador.tareasDeFinDePartida(idJugador1);
        if (isGanador){
            controlador.sumarVictoria(idJugador1);
            vista.println("--- TENEMOS GANADOR DEL JUEGO ---");
            vista.println("--- EL GANADOR DEL JUEGO ES "+idJugador1+" ----");
            return new FlujoMenuPrincipal(vista,controlador, idPrincipal);
        }
        else {
            controlador.Partida2Jugadores();
            return new FlujoJugador1(vista,controlador,idJugador1,idPrincipal);
        }
    }

    private void procesarPaso() {
        if (juegoSimple || juegoSimpleFull || juegoDoble || juegoDobleFull || tomarCarta){
            vista.println("Termino su turno...");
            vista.println("presione enter para continuar....");

            if (juegoDobleFull){
                controlador.hiceJuegoDoble(idJugador1);
            }
            if (0==controlador.cantidadCartaJugador(idJugador1)) {
                estadoActual = estados.FIN_JUEGO;
            }
            else if (juegoSimpleFull || juegoDobleFull){
                estadoActual=estados.ELIGE_CARTA_PONER_BOCA_ARRIBA;
            }
            else {
                    estadoActual = estados.FIN_TURNO;
            }
        }else {
            vista.println("Para terminar su turno tiene que hacer un juego o tomar una carta...");
            estadoActual=estados.INICIAR_TURNO_JUGADOR1;
        }
    }

    private Flujo procesarFinTurno() {
        juegoSimpleFull=false;
        juegoSimple=false;
        juegoDoble=false;
        juegoDobleFull=false;
        tomarCarta=false;
        controlador.rellenarCartaBocaArriba();
        controlador.terminoTurno(idPrincipal);
        return new FlujoEsperar(vista,controlador);
    }

    private void procesarCombinacionDobleConComodin(String entrada) {
        Integer numeroCartaBocaArriba;
        try {
            numeroCartaBocaArriba = Integer.parseInt(entrada);
            if (numeroCartaBocaArriba < 1 ||numeroCartaBocaArriba >10) {
                vista.println("Ingrese un valor que se encuentre en las opciones...");
                estadoActual=estados.CARTA_BOCA_ARRIBA_COMODIN;
            }else{

                boolean validacionJuego = controlador.validarCombinacionDoble(true,idJugador1, cartaElegidaJ1, carta2ElegidaJ1, cartaBocaArriba,numeroCartaBocaArriba);
                if (validacionJuego) {
                    boolean validacionColor = controlador.validarColorDoble(idJugador1, cartaElegidaJ1, carta2ElegidaJ1, cartaBocaArriba);
                    if (validacionColor) {
                        vista.println("---Hizo un juego Doble con color----");
                        estadoActual = estados.INICIAR_TURNO_JUGADOR1;
                        juegoDobleFull = true;

                    } else {
                        vista.println("---Hizo un juego Doble sin color----");
                        juegoDoble=true;
                        estadoActual = estados.INICIAR_TURNO_JUGADOR1;
                    }
                    controlador.eliminarCartaUsadasDoble(idJugador1, cartaElegidaJ1, carta2ElegidaJ1, cartaBocaArriba);

                } else {
                    vista.println("No se pudo armar juego...");
                    vista.println("vuelva a intentarlo...");
                    estadoActual = estados.INICIAR_TURNO_JUGADOR1;
                }


            }


        } catch (NumberFormatException e) {
            vista.println("Ingrese un número válido.");
        }
    }

    private void procesarCombinacionDoble(String entrada) {
        Integer cartaBocaArribaOp;
        try {
            cartaBocaArribaOp = Integer.parseInt(entrada);
            if (cartaBocaArribaOp < 1 ||cartaBocaArribaOp > controlador.cartasBocaArriba().size()) {
                vista.println("Ingrese un valor que se encuentre en las opciones...");
                estadoActual=estados.INICIAR_TURNO_JUGADOR1;
            }else{
                cartaBocaArriba=cartaBocaArribaOp;
                boolean validarSiLaCartaBocaArribaEsComodin=controlador.validarSiEsComodin(cartaBocaArribaOp);

                if (validarSiLaCartaBocaArribaEsComodin){
                    vista.println("La carta que eligio Boca Arriba es un Comodin");
                    estadoActual=estados.CARTA_BOCA_ARRIBA_COMODIN;
                }
                else {
                    boolean validacionJuego = controlador.validarCombinacionDoble(false,idJugador1, cartaElegidaJ1, carta2ElegidaJ1, cartaBocaArribaOp,0);
                    if (validacionJuego) {
                        boolean validacionColor = controlador.validarColorDoble(idJugador1, cartaElegidaJ1, carta2ElegidaJ1, cartaBocaArribaOp);
                        if (validacionColor) {
                            vista.println("---Hizo un juego Doble con color----");
                            estadoActual = estados.INICIAR_TURNO_JUGADOR1;
                            juegoDobleFull = true;

                        } else {
                            vista.println("---Hizo un juego Doble sin color----");
                            estadoActual = estados.INICIAR_TURNO_JUGADOR1;
                            juegoDoble=true;
                        }
                        controlador.eliminarCartaUsadasDoble(idJugador1, cartaElegidaJ1, carta2ElegidaJ1, cartaBocaArribaOp);


                    } else {
                        vista.println("No se pudo armar juego...");
                        vista.println("vuelva a intentarlo...");
                        estadoActual = estados.INICIAR_TURNO_JUGADOR1;
                    }
                }

            }


        } catch (NumberFormatException e) {
            vista.println("Ingrese un número válido.");
        }
    }

    private void procesarIngresoCarta2(String entrada) {
        Integer opcion;
        try {
            opcion = Integer.parseInt(entrada);
            if (opcion < 1 || opcion > controlador.cantidadCartaJugador(idJugador1) || opcion== cartaElegidaJ1) {
                vista.println("Ingrese un valor que se encuentre en las opciones...");
            }else{
                carta2ElegidaJ1=opcion;
                estadoActual=estados.ELIGE_CARTA_BOCA_ARRIBA_JUEGO_DOBLE_J1;
            }

        } catch (NumberFormatException e) {
            vista.println("Ingrese un número válido.");
        }
    }

    private void procesarIngresoCarta1(String entrada) {
        Integer opcion;
        try {
            opcion = Integer.parseInt(entrada);
            if (opcion < 1 || opcion > controlador.cantidadCartaJugador(idJugador1)) {
                vista.println("Ingrese un valor que se encuentre en las opciones...");
            }else{
                cartaElegidaJ1=opcion;
                estadoActual=estados.COMBINACION_DOBLE_CARTA2_J1;
            }

        } catch (NumberFormatException e) {
            vista.println("Ingrese un número válido.");
        }
    }

    private void procesarJuegoConColor(String entrada) {
        Integer opcion;
        try {
            opcion = Integer.parseInt(entrada);
            if (opcion < 1 ||opcion > controlador.cantidadCartaJugador(idJugador1)) {
                vista.println("Ingrese un valor que se encuentre en las opciones...");
            }else{
                controlador.rellenarCartaBocaArriba();
                controlador.ponerBocaArriba(opcion,idJugador1);
                controlador.eliminarCartaUsadas(idJugador1,opcion);
                if (0==controlador.cantidadCartaJugador(idJugador1)){
                    estadoActual=estados.FIN_JUEGO;
                }else {
                    estadoActual = estados.FIN_TURNO;
                }
            }

        } catch (NumberFormatException e) {
            vista.println("Ingrese un número válido.");
        }

    }

    private void procesarCombinacionJ1(String entrada) {
        Integer cartaBocaArribaOp;
        try {
            cartaBocaArribaOp = Integer.parseInt(entrada);
            if (cartaBocaArribaOp < 1 ||cartaBocaArribaOp > controlador.cartasBocaArriba().size()) {
                vista.println("Ingrese un valor que se encuentre en las opciones...");
                estadoActual=estados.INICIAR_TURNO_JUGADOR1;
            }else{
                boolean validacionJuego=controlador.validarCombinacionSimple(idJugador1,cartaElegidaJ1,cartaBocaArribaOp);
                if (validacionJuego){
                    boolean validacionColor=controlador.validarColor(idJugador1,cartaElegidaJ1,cartaBocaArribaOp);
                    if (validacionColor){
                        vista.println("---Hizo un juego simple con color----");
                        estadoActual=estados.INICIAR_TURNO_JUGADOR1;
                        juegoSimpleFull=true;

                    }else {
                        vista.println("---Hizo un juego simple sin color----");
                        juegoSimple=true;
                        estadoActual=estados.INICIAR_TURNO_JUGADOR1;
                    }
                    controlador.eliminarCartaUsadas(idJugador1,cartaElegidaJ1,cartaBocaArribaOp);

                }else{
                    vista.println("No se pudo armar juego...");
                    vista.println("vuelva a intentarlo...");
                    estadoActual=estados.INICIAR_TURNO_JUGADOR1;
                }

            }


        } catch (NumberFormatException e) {
            vista.println("Ingrese un número válido.");
        }
    }

    private void procesarIngresoCartaJuegoSimple(String entrada) {
        Integer opcion;
        try {
            opcion = Integer.parseInt(entrada);
            if (opcion < 1 ||opcion > controlador.cantidadCartaJugador(idJugador1)) {
                vista.println("Ingrese un valor que se encuentre en las opciones...");
            }else{
                cartaElegidaJ1=opcion;
                estadoActual=estados.ELIGE_CARTA_BOCA_ARRIBA;
            }

        } catch (NumberFormatException e) {
            vista.println("Ingrese un número válido.");
        }
    }

    private void procesarTurnoJugador1(String entrada) {
        switch (entrada){
            case "1"->{
                estadoActual=estados.COMBINACION_SIMPLE_J1;
            }
            case "2"->{
                estadoActual=estados.COMBINACION_DOBLE_J1;
            }
            case "3"->{
                estadoActual=estados.TOMAR_CARTA_DE_MAZO_J1;

            }
            case "4"->{
                estadoActual=estados.PASAR_TURNO;
            }
            case "5"->{
                estadoActual=estados.VER_PUNTOS_JUEGO;
            }
            default -> vista.println("ingrese un valor valido...");
        }

    }
    @Override
    public void mostarSiguienteTexto() {
        switch (estadoActual){
            case INICIAR_TURNO_JUGADOR1 -> {
                vista.println("---------------------------------------------------");
                vista.println("---Es el Turno del Jugador "+idJugador1+"---");
                vista.println("---Las Cartas de Su Mano----");
                for (Carta cartaAux: controlador.cartasDelJugador(idJugador1)){
                    vista.println(cartaAux.toString());
                }
                vista.println("---Las Cartas Boca Arriba---");
                if (controlador.cartasBocaArriba().isEmpty()){
                    vista.println("No hay Cartas disponible para usar");
                }
                for (Carta cartaAux :controlador.cartasBocaArriba()){
                    vista.println(cartaAux.toString());
                }
                vista.println("1. Combinacion Simple");
                vista.println("2. Combinacion Doble");
                vista.println("3. Tomar Carta");
                vista.println("4. Paso");
                vista.println("5. Ver puntos del juego");

            }
            case VER_PUNTOS_JUEGO -> {
                vista.println("para ver los puntos ingrese 1...");
            }
            case COMBINACION_SIMPLE_J1 -> {
                int contador=1;
                vista.println("---Las Cartas de Su Mano----");
                for (Carta cartaAux: controlador.cartasDelJugador(idJugador1)){
                    vista.println(contador+"."+cartaAux.toString());
                    contador++;
                }
                vista.println("Seleccione el numero de la opcion de la carta que desea...");
            }
            case ELIGE_CARTA_BOCA_ARRIBA -> {
                int contador=1;
                vista.println("---Las Cartas Boca Arriba---");
                for (Carta cartaAux :controlador.cartasBocaArriba()){
                    vista.println(contador+"."+cartaAux.toString());
                    contador++;
                }
                vista.println("Seleccione el numero de la opcion de la carta que desea...");
            }
            case ELIGE_CARTA_PONER_BOCA_ARRIBA -> {
                int contador=1;
                vista.println("---Eliga una Carta de tu Mano para Poner Boca Arriba---");
                for (Carta cartaAux :controlador.cartasDelJugador(idJugador1)){
                    vista.println(contador+"."+cartaAux.toString());
                    contador++;
                }
                vista.println("Seleccione el numero de la opcion de la carta que desea...");

            }
            case COMBINACION_DOBLE_J1 -> {
                int contador=1;
                vista.println("---Las Cartas de Su Mano----");
                for (Carta cartaAux: controlador.cartasDelJugador(idJugador1)){
                    vista.println(contador+"."+cartaAux.toString());
                    contador++;
                }
                vista.println("Seleccione el numero de la opcion de la carta que desea para la carta 1...");
            }
            case COMBINACION_DOBLE_CARTA2_J1 -> {
                int contador=1;
                int numerocart1= cartaElegidaJ1;
                System.out.println(numerocart1);
                vista.println("---Las Cartas de Su Mano----");
                for (Carta cartaAux: controlador.cartasDelJugador(idJugador1)){
                    if (numerocart1 != contador) {
                        vista.println(contador + "." + cartaAux.toString());
                    }
                    contador++;
                }
                vista.println("Seleccione el numero de la opcion de la carta que desea para la carta 2...");
            }
            case ELIGE_CARTA_BOCA_ARRIBA_JUEGO_DOBLE_J1 -> {
                int contador=1;
                vista.println("---Las Cartas Boca Arriba---");
                for (Carta cartaAux :controlador.cartasBocaArriba()){
                    vista.println(contador+"."+cartaAux.toString());
                    contador++;
                }
                vista.println("Seleccione el numero de la opcion de la carta que desea para el juego doble...");
            }
            case CARTA_BOCA_ARRIBA_COMODIN -> {
                vista.println("Ingrese un valor del 1 al 10 incluidos...");
            }
            case TOMAR_CARTA_DE_MAZO_J1 -> {
                if (!tomarCarta && !juegoDobleFull && !juegoSimpleFull) {
                    vista.println("---Tomaste una carta del mazo----");
                    tomarCarta=true;
                    controlador.tomarCartaMazo(idJugador1);
                }else {
                    vista.println("Usted no puede tomar una carta porque ya hizo un juego o tomo una carta...");
                }
                vista.println("presione enter para Continuar...");
            }
            case FIN_JUEGO -> {
                vista.println("---El ganador de la partida fue el jugador "+idJugador1+"---");
            }
        }

    }
}
