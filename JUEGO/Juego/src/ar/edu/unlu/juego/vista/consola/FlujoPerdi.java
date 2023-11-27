package ar.edu.unlu.juego.vista.consola;

import ar.edu.unlu.juego.controlador.Controlador;

public class FlujoPerdi extends Flujo{
    private String ganador;
    public FlujoPerdi(ConsolaGrafica vista, Controlador controlador,String idGanador) {
        super(vista, controlador);
        this.ganador=idGanador;
    }

    @Override
    public Flujo procesarEntrada(String string) {
        return new FlujoMenuPrincipal(vista,controlador, controlador.devolverID());
    }

    @Override
    public void mostarSiguienteTexto() {
        vista.println("---------------------------------------------------------");
        vista.println("----- PERDISTE EL JUEGO, EL GANADOR FUE "+ganador+" ------");
        vista.println("----- PRESIONE ENTER PARA VOLVER AL MENU PRINCIPAL -----");
        vista.println("---------------------------------------------------------");


    }
}
