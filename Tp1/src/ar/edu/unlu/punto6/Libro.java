package ar.edu.unlu.punto6;

public class Libro {
    private String autor;
    private Object nombre;
    private int cantPaginas;
    private int cantDisponibles;
    private int cantPrestados;

    public int getCantDisponibles() {
        return cantDisponibles;
    }

    public void setCantDisponibles(int cantDisponibles) {
        this.cantDisponibles = cantDisponibles;
    }

    public int getCantPrestados() {
        return cantPrestados;
    }

    public void setCantPrestados(int cantPrestados) {
        this.cantPrestados = cantPrestados;
    }

    public void setAutor(String autor){
        this.autor=autor;
    }
    public String getAutor(){
        return autor;
    }

    public void setNombre(Object nombre) {
        this.nombre = nombre;
    }

    public Object getNombre() {
        return nombre;
    }

    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    public int getCantPaginas() {
        return cantPaginas;
    }
}
