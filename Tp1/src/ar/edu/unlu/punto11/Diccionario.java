package ar.edu.unlu.punto11;

import java.util.ArrayList;

public class Diccionario {
    private ArrayList<String> listadePalabras = new ArrayList<String>();

    public boolean validaPalabra(String s){
        boolean bandera=true;
        for (int i = 0; i <listadePalabras.size() ; i++) {
            if (listadePalabras.get(i).equals(s)){
                return bandera;
            }
        }
        bandera=false;
        return bandera;
    }

    public void agregarPalabra(String s){
        listadePalabras.add(s);
    }
}
