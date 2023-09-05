package ar.edu.unlu.punto8;

import java.util.Random;

public class Contraseña {
    private String contraseña="";

    public void generarContraseña(int cantLetras){
        contraseña="";
        Random aleatorio= new Random();
        char letra;
        for (int i =0;i<cantLetras;i++){
            int numAleatorio= aleatorio.nextInt(1,4);
            if (numAleatorio==1){
                letra=(char) aleatorio.nextInt(97,123);
                contraseña= contraseña+letra;
            }
            else if (numAleatorio==2){
                letra=(char) aleatorio.nextInt(65,91);
                contraseña= contraseña+letra;
            }
            else {
                letra=(char) aleatorio.nextInt(48,58);
                contraseña= contraseña+letra;
            }
        }
        System.out.println("la contraseña que se genero fue: "+contraseña);
        System.currentTimeMillis();
    }
    public void generarContraseñaFuerte(int cantLetras){
        boolean bandera=true;
        while (bandera) {
            contraseña = "";
            Random aleatorio = new Random();
            char letra;
            for (int i = 0; i < cantLetras; i++) {
                int numAleatorio = aleatorio.nextInt(1, 4);
                if (numAleatorio == 1) {
                    letra = (char) aleatorio.nextInt(97, 123);
                    contraseña = contraseña + letra;
                } else if (numAleatorio == 2) {
                    letra = (char) aleatorio.nextInt(65, 91);
                    contraseña = contraseña + letra;
                } else {
                    letra = (char) aleatorio.nextInt(48, 58);
                    contraseña = contraseña + letra;
                }
            }
            boolean validacion=validarContraseña();
            if (validacion){
                bandera=false;
            }
            else {
                //System.out.println("la contraseña no es fuerte, se va a volver crear.");
            }

        }
        System.out.println("la contraseña que se genero fue: "+contraseña);
        System.currentTimeMillis();
    }

    public boolean validarContraseña(){
        boolean bandera=true;
        int acumuladorMayuscula=0;
        int acumuladorMinusculas=0;
        int acumuladorNumeros=0;
        char letra;
        int letraAscii;
        for (int i=0;i<contraseña.length();i++){
            letra=contraseña.charAt(i);
            letraAscii= (int) letra;
            if (letraAscii>=97  && letraAscii<123){
                acumuladorMinusculas++;
            }
            if (letraAscii>=65  && letraAscii<91){
                acumuladorMayuscula++;
            }
            if (letraAscii>=48  && letraAscii<58){
                acumuladorNumeros++;
            }

        }
        if (acumuladorMayuscula>2 && bandera==true){

        }
        else {
            bandera=false;
        }
        if (acumuladorMinusculas>1 && bandera==true){

        }
        else {
            bandera=false;
        }
        if (acumuladorNumeros>1 && bandera==true){

        }
        else {
            bandera=false;
        }
      return bandera;
    }
}
