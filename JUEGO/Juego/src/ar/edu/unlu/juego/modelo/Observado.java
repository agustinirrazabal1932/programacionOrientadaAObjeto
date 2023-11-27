package ar.edu.unlu.juego.modelo;

public interface Observado {
    public void attach(Observadores anObserver);
    public void detach(Observadores anObserver);
    public void notifyMessage();
    public void informarJugadorQueEntroALaPartida(String id);
    public void informarJugadorQueLeToca(String id);
}
