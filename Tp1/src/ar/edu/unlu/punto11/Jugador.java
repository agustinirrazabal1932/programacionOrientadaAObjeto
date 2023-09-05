package ar.edu.unlu.punto11;

public class Jugador {
    private String nombre;
    private int puntos;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPuntos() {
        return puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarJugador(String s){
        setNombre(s);
        setPuntos(0);
    }
    public String toString(){
        String cadena="";
        cadena+="el jugador: "+this.nombre+"\n";
        cadena+="los puntos son: "+this.puntos+"\n";
        return cadena;
    }
    public void quienTieneMasPuntos(Jugador jugador2){
        if (this.puntos>jugador2.getPuntos()){
            System.out.println("el jugador "+this.nombre+" tiene mas puntos que el jugador "+jugador2.getNombre());
        }
        else if (this.puntos<jugador2.getPuntos()) {
            System.out.println("el jugador "+jugador2.getNombre()+" tiene mas puntos que el jugador "+this.nombre);
        }
        else {
            System.out.println("el jugador "+this.nombre+" tiene los mismos puntos que el jugador "+jugador2.getNombre());
        }
    }
}
