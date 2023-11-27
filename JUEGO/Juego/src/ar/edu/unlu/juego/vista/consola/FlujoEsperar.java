package ar.edu.unlu.juego.vista.consola;

import ar.edu.unlu.juego.controlador.Controlador;

public class FlujoEsperar extends Flujo{
    public FlujoEsperar(ConsolaGrafica vista, Controlador controlador) {
        super(vista, controlador);
    }

    @Override
    public Flujo procesarEntrada(String string) {
        vista.println("----------------------------");
        vista.println("----- NO PRESIONE ENTER, ESPERE SU TURNO -----");
        return this;
    }

    @Override
    public void mostarSiguienteTexto() {
        vista.println("----- SE UNIO A UNA PARTIDA ESPERE SU TURNO -----");

    }
}
