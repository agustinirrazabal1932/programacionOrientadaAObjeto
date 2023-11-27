package ar.edu.unlu.juego.modelo;

public interface Observadores {
    public void update();
    public String devolverID();

    void jugar(String id);
}
