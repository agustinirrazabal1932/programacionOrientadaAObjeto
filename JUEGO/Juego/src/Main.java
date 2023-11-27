import ar.edu.unlu.juego.controlador.Controlador;
import ar.edu.unlu.juego.modelo.Modelo;
import ar.edu.unlu.juego.vista.Ivista;
import ar.edu.unlu.juego.vista.consola.ConsolaGrafica;

public class Main {
    public static void main(String[] args) {
        Modelo modelo = new Modelo();
        Ivista vistaJuego1 =new ConsolaGrafica();
        Controlador controlador1=new Controlador(vistaJuego1);
        controlador1.setModeloJuego(modelo);

        Ivista vistaJuego2 =new ConsolaGrafica();
        Controlador controlador2=new Controlador(vistaJuego2);
        controlador2.setModeloJuego(modelo);

        modelo.cargarUsuariosConJuegosGanados("agustin","irrazabal","agus1234",1);
        modelo.cargarUsuariosConJuegosGanados("florencia","quevedo","florchu",3);
        modelo.cargarUsuariosConJuegosGanados("josefina","gutierrez","joseG",5);


        vistaJuego1.mostrarMenuPrincipal();
        vistaJuego2.mostrarMenuPrincipal();

    }
}