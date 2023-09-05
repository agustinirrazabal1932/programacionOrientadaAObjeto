package ar.edu.unlu.punto11;

import java.util.ArrayList;
import java.util.Scanner;

public class Juego {
    private String intentoDePalabra;
    private int cantPuntosPartida;
    private Diccionario diccionario=new Diccionario();

    public String getIntentoDePalabra() {
        return intentoDePalabra;
    }

    public void setIntentoDePalabra(String intentoDePalabra) {
        this.intentoDePalabra = intentoDePalabra;
    }

    public int getCantPuntosPartida() {
        return cantPuntosPartida;
    }

    public void setCantPuntosPartida(int cantPuntosPartida) {
        this.cantPuntosPartida = cantPuntosPartida;
    }

    public void iniciarJuego(Jugador jugador){


        setCantPuntosPartida(0);
        int puntos=0;
        boolean bandera=true;
        Scanner sc= new Scanner(System.in);
        boolean validacion;
        diccionario.agregarPalabra("exodo");
        diccionario.agregarPalabra("lluvia");
        diccionario.agregarPalabra("dedo");
        diccionario.agregarPalabra("queso");
        diccionario.agregarPalabra("kilogramo");
        diccionario.agregarPalabra("zanahoria");
        diccionario.agregarPalabra("whisky");
        diccionario.agregarPalabra("sexo");
        diccionario.agregarPalabra("arbol");
        diccionario.agregarPalabra("amor");
        diccionario.agregarPalabra("dinosaurio");
        diccionario.agregarPalabra("computadora");
        diccionario.agregarPalabra("vaca");
        diccionario.agregarPalabra("calendario");
        diccionario.agregarPalabra("zapallo");
        diccionario.agregarPalabra("arte");

        System.out.println("---EL JUEGO INICIO----");
        System.out.println("Bienvenido jugador "+ jugador.getNombre());
        while (bandera){
            System.out.println("ingrese la palabra: ");
            setIntentoDePalabra(sc.nextLine());
            puntos=validarPuntos(getIntentoDePalabra());
            validacion=diccionario.validaPalabra(getIntentoDePalabra());
            if (validacion){
                int puntosActuales=getCantPuntosPartida();
                setCantPuntosPartida(puntosActuales+=puntos);
                System.out.println("La palabra es correcta,tiene otro turno");
            }
            else {
                jugador.setPuntos(getCantPuntosPartida());
                bandera=false;
                System.out.println("La palabra no fue correcta, termino su turno.");
            }
        }
    }
    public int validarPuntos(String palabra){
        char letraActual;
        int puntos=0;
        for (int i = 0; i <palabra.length(); i++) {
            letraActual=palabra.charAt(i);
            if (letraActual=='x'|| letraActual=='y'|| letraActual=='z'|| letraActual=='w'|| letraActual=='k'|| letraActual=='q'){
                puntos+=2;
            }
            else {
                puntos++;
            }
        }
        return puntos;
    }


}
