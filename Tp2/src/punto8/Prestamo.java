package punto8;

public class Prestamo {

    private int idSocio;
    private Libro libro;

    public Prestamo(int idSocio,Libro libro) {
        setIdSocio(idSocio);
        setLibro(libro);
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
}
