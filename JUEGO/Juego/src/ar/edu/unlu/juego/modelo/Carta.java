package ar.edu.unlu.juego.modelo;

public class Carta {
    private String color;
    private int numero;
    private int valor;
    private boolean enUso;

    public Carta(String color, int numero) {
        this.color = color;
        this.numero = numero;
        this.enUso=false;
        setValor();
    }

    public String getColor() {
        return color;
    }

    public int getValor() {
        return valor;
    }

    public int getNumero() {
        return numero;
    }

    public String toString(){
        String cadena="";
        if (getNumero()==0){
            cadena += "el color es: " + getColor() + ", el numero es: #.\n";
        }else {
            cadena += "el color es: " + getColor() + ", el numero es: " + getNumero() + ".\n";
        }
        return cadena;
    }

    private void setValor(){
        if (numero==2) {
            this.valor=20;
        } else if (numero==0) {
            this.valor=40;
        }else {
            this.valor=numero;
        }
    }
    public void seVaUsar() {
        this.enUso=true;
    }

    public boolean isEnUso() {
        return enUso;
    }

    public void noSeUso() {
        this.enUso=false;
    }
}

